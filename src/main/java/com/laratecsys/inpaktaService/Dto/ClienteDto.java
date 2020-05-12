package com.laratecsys.inpaktaService.Dto;

public class ClienteDto {
	
	private Integer id;
	
	private String nome;
	private String sobNome;
	private String email;
	
	public ClienteDto() {
		
	}
	
	public ClienteDto(Integer id, String nome, String sobNome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobNome = sobNome;
		this.email = email;
	}
		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobNome() {
		return sobNome;
	}
	public void setSobNome(String sobNome) {
		this.sobNome = sobNome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
