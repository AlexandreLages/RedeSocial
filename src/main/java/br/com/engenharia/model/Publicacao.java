package br.com.engenharia.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Publicacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String titulo;
	private String conteudo;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dataDaPostagem;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getDataDaPostagem() {
		return dataDaPostagem;
	}
	
	public void setDataDaPostagem(Date dataDaPostagem) {
		this.dataDaPostagem = dataDaPostagem;
	}
	
	public String getConteudo() {
		return conteudo;
	}
	
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}