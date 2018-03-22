package br.com.engenharia.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.engenharia.dao.UsuarioDAO;
import br.com.engenharia.model.Usuario;

@Controller
public class UsuarioController {
	
	@Inject private UsuarioDAO usuarios;
	@Inject private Result result;

	@Post
	public void adicionar(Usuario usuario) {
		if(usuarios.verificarUsuario(usuario)) {
			result.include("erro", "Já existe um usuário com esse email.");
		} else {
			usuarios.adicionar(usuario);
			result.include("mensagem", "Usuário adicionado com sucesso.");
		}
		result.redirectTo(LoginController.class).telaLogin();
	}
}