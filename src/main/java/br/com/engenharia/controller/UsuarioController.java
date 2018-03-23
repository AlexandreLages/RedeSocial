package br.com.engenharia.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.engenharia.dao.UsuarioDAO;
import br.com.engenharia.model.Publicacao;
import br.com.engenharia.model.Usuario;
import br.com.engenharia.session.UsuarioSession;

@Controller
public class UsuarioController {
	
	@Inject private UsuarioDAO usuarios;
	@Inject private Result result;
	@Inject private UsuarioSession session;
	
	@Post({"/usuario/adicionar", "/usuario/adicionar/"})
	public void adicionar(Usuario usuario) {
		if(usuarios.verificarUsuarioPorEmail(usuario)) {
			result.include("erro", "Já existe um usuário com esse email.");
		} else {
			usuarios.adicionar(usuario);
			result.include("mensagem", "Usuário adicionado com sucesso.");
		}
		result.redirectTo(LoginController.class).telaLogin();
	}
	
	@Get({"/usuario/principal", "/usuario/principal/"})
	public void principal() {
		Long idUsuario = session.getUsuario().getId();
		
		Usuario usuario = usuarios.buscar(idUsuario);
		List<Publicacao> publicacoesParaLinhaDoTempo = usuario.publicacoesParaLinhaDoTempo();
		List<Usuario> amigos = usuario.getAmigos();
		
		result.include("feed", publicacoesParaLinhaDoTempo);
		result.include("amigos", amigos);
	}
	
	@Get({"/usuario/seguir/{id}", "/usuario/seguir/{id}/"})
	public void seguir(long id) {
		Usuario usuario = usuarios.pesquisarUsuarioPorId(id);
		Usuario usuarioLogado = usuarios.pesquisarUsuarioPorId(session.getUsuario().getId());
		
		usuarioLogado.getAmigos().add(usuario);
		
		usuarios.atualizar(usuarioLogado);
	}
	
	@Get({"/usuario/listar/", "/usuario/listar"})
	public void listar(String nome) {
		List<Usuario> listaUsuarios = usuarios.listarUsuarios(nome);
		result.include("seguir", listaUsuarios);
	}
}