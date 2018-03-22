package br.com.engenharia.session;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.engenharia.model.Usuario;

@Named("usuariologado")
@SessionScoped
public class UsuarioSession implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	
	public void login(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public boolean isLogado() {
		return usuario != null;
	}
	
	public void logout() {
		this.usuario = null;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
}