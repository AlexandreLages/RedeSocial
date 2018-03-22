package br.com.engenharia.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.engenharia.dao.UsuarioDAO;
import br.com.engenharia.model.Usuario;
import br.com.engenharia.session.UsuarioSession;

@Controller
public class LoginController {
	
	@Inject private UsuarioSession usuarioSession;
	@Inject private UsuarioDAO usuarioDAO;
	@Inject private Result result;
	
	@Get("/login/")
	public void telaLogin() {}

	@Post({"/login/", "/login"})
	public void login(Usuario usuario) {
		Usuario usuarioLogado = usuarioDAO.pesquisarUsuarioPorEmailESenha(usuario);  
		if(usuarioLogado != null) {
			usuarioSession.login(usuarioLogado);
			result.redirectTo(UsuarioController.class).principal();
		} else {
			result.include("erro", "Usuário/Senha inválido(s).");
			result.redirectTo(LoginController.class).telaLogin();
		}
	}
	
	@Get({"/logout", "/logout/"})
	public void logout() {
		if(usuarioSession.isLogado()) {
			usuarioSession.logout();
			result.redirectTo(LoginController.class).telaLogin();
		}
	}
}