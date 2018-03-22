package br.com.engenharia.controller;

import java.util.Date;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.engenharia.dao.PublicacaoDAO;
import br.com.engenharia.model.Publicacao;
import br.com.engenharia.model.Usuario;
import br.com.engenharia.session.UsuarioSession;

@Controller
public class PublicacaoController {

	@Inject private UsuarioSession sessao;
	@Inject private Result result;
	@Inject private PublicacaoDAO dao;

	
	@Post("/publicacao/adicionar")
	public void adicionar(Publicacao publicacao) {
	
		Usuario usuario = sessao.getUsuario();
		
		
		publicacao.setDataDaPostagem(new Date());
		publicacao.setUsuario(usuario);
	
		dao.salvar(publicacao);
		
		result.redirectTo(UsuarioController.class).principal();
		
	}
}
