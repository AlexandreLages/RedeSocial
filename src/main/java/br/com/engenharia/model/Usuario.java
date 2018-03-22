package br.com.engenharia.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import br.com.engenharia.util.OrdenacaoGenerica;
import br.com.engenharia.util.SortType;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	private String email;
	private String senha;
	
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private List<Usuario> amigos = new ArrayList<>();
	
	@OneToMany(mappedBy = "usuario", targetEntity = Publicacao.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Publicacao> publicacoes = new ArrayList<>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Usuario> getAmigos() {
		return amigos;
	}

	public void setAmigos(List<Usuario> amigos) {
		this.amigos = amigos;
	}

	public List<Publicacao> getPublicacoes() {
		return publicacoes;
	}

	public void setPublicacoes(List<Publicacao> publicacoes) {
		this.publicacoes = publicacoes;
	}
	
	public List<Publicacao> publicacoesParaLinhaDoTempo() {
		ArrayList<Publicacao> minhasPublicacoes = new ArrayList<Publicacao>();
		
		minhasPublicacoes.addAll(publicacoes);
		
		for (Usuario usuario : amigos) {
			minhasPublicacoes.addAll(usuario.getPublicacoes());
		}
		
		OrdenacaoGenerica.sortList(minhasPublicacoes, "dataDaPostagem", SortType.DESC);
		
		return minhasPublicacoes;
	}
	
	
}