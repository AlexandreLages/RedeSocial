package br.com.engenharia.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.engenharia.model.Usuario;

@RequestScoped
public class UsuarioDAO {

	@Inject private Session session;
	
	public void adicionar(Usuario usuario) {
		this.session.save(usuario);
	}
	
	public Boolean verificarUsuario(Usuario usuario) {
		return this.session.createCriteria(Usuario.class)
				.add(Restrictions.eq("email", usuario.getEmail()))
				.uniqueResult() != null;
	}
}