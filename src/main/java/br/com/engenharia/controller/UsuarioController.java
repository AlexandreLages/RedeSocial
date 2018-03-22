package br.com.engenharia.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.engenharia.dao.UsuarioDAO;
import br.com.engenharia.model.Usuario;

@Controller
public class UsuarioController {
	
	@Inject private UsuarioDAO usuarios;
	@Inject private Result result;

	@Post({"/usuario/adicionar", "/usuario/adicionar/"})
	public void adicionar(Usuario usuario) {
		if(usuarios.verificarUsuarioPorEmail(usuario)) {
			result.include("erro", "J� existe um usu�rio com esse email.");
		} else {
			usuarios.adicionar(usuario);
			result.include("mensagem", "Usu�rio adicionado com sucesso.");
		}
		result.redirectTo(LoginController.class).telaLogin();
	}
	
	@Get({"/usuario/principal", "/usuario/principal/"})
	public void principal() {
		
	}
}