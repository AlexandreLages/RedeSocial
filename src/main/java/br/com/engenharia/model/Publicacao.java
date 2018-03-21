package br.com.engenharia.model;

import java.util.Date;

public class Publicacao {
	
	private String conteudo;
	private Date dataDaPostagem;
	
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
}
