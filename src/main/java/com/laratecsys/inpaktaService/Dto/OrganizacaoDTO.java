package com.laratecsys.inpaktaService.Dto;

import java.util.ArrayList;
import java.util.List;

import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.CasoDeUso;

public class OrganizacaoDTO {
	
	private String email;
	
	private String organizacao;
	
	private String subDominio;
	private String cor;
	private Byte[] icone;
	
	private List<CasoDeUso> casoDeUso = new ArrayList<>();
	
	public OrganizacaoDTO() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrganizacao() {
		return organizacao;
	}

	public void setOrganizacao(String organizacao) {
		this.organizacao = organizacao;
	}

	public String getSubDominio() {
		return subDominio;
	}

	public void setSubDominio(String subDominio) {
		this.subDominio = subDominio;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Byte[] getIcone() {
		return icone;
	}

	public void setIcone(Byte[] icone) {
		this.icone = icone;
	}

	public List<CasoDeUso> getCasoDeUso() {
		return casoDeUso;
	}

	public void setCasoDeUso(List<CasoDeUso> casoDeUso) {
		this.casoDeUso = casoDeUso;
	}
	

}
