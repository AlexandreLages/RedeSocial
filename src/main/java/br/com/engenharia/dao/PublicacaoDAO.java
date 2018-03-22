package br.com.engenharia.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Session;

import br.com.engenharia.model.Publicacao;

@RequestScoped
public class PublicacaoDAO {

	@Inject private Session session;
	
	public void salvar(Publicacao p) {
		session.save(p);
	}
}
