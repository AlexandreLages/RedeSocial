package br.com.engenharia.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.engenharia.model.Usuario;

@RequestScoped
public class UsuarioDAO {

	@Inject private Session session;
	
	public void adicionar(Usuario usuario) {
		this.session.save(usuario);
	}
	
	public Usuario atualizar(Usuario usuario) {
		return (Usuario) session.merge(usuario);
	}
	
	public Usuario buscar(Long id) {
		return (Usuario) this.session.createCriteria(Usuario.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}
	
	public Boolean verificarUsuarioPorEmail(Usuario usuario) {
		return this.session.createCriteria(Usuario.class)
				.add(Restrictions.eq("email", usuario.getEmail()))
				.uniqueResult() != null;
	}
	
	public Usuario pesquisarUsuarioPorEmailESenha(Usuario usuario) {
		return (Usuario) this.session.createCriteria(Usuario.class)
				.add(Restrictions.eq("email", usuario.getEmail()))
				.add(Restrictions.eq("senha", usuario.getSenha()))
				.uniqueResult();
	}

	public Usuario pesquisarUsuarioPorId(long id) {
		return (Usuario) this.session.createCriteria(Usuario.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarUsuarios(String nome) {
		return session.createCriteria(Usuario.class)
				.add(Restrictions.like("nome", nome, MatchMode.ANYWHERE))
				.list();
	}
}