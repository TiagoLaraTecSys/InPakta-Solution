package com.laratecsys.inpaktaService.Dto;

public class FileResultsDTO {
	
	private Integer id_File;
	private String diretorio;
	private String nomeDoArquivo;
	private String probabilidade;
	private String modelo;
	private String modeloDoModulo;
	private String dicionario;
	
	public FileResultsDTO() {}
	
	 
	
	public FileResultsDTO(Integer id_File, String diretorio, String nomeDoArquivo, String probabilidade, String modelo,
			String modeloDoModulo, String dicionario) {
		super();
		this.id_File = id_File;
		this.diretorio = diretorio;
		this.nomeDoArquivo = nomeDoArquivo;
		this.probabilidade = probabilidade;
		this.modelo = modelo;
		this.modeloDoModulo = modeloDoModulo;
		this.dicionario = dicionario;
	}


	public Integer getId_File() {
		return id_File;
	}
	public void setId_File(Integer id_File) {
		this.id_File = id_File;
	}
	public String getDiretorio() {
		return diretorio;
	}
	public void setDiretorio(String diretorio) {
		this.diretorio = diretorio;
	}
	public String getNomeDoArquivo() {
		return nomeDoArquivo;
	}
	public void setNomeDoArquivo(String nomeDoArquivo) {
		this.nomeDoArquivo = nomeDoArquivo;
	}
	public String getProbabilidade() {
		return probabilidade;
	}
	public void setProbabilidade(String probabilidade) {
		this.probabilidade = probabilidade;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getModeloDoModulo() {
		return modeloDoModulo;
	}
	public void setModeloDoModulo(String modeloDoModulo) {
		this.modeloDoModulo = modeloDoModulo;
	}
	public String getDicionario() {
		return dicionario;
	}
	public void setDicionario(String dicionario) {
		this.dicionario = dicionario;
	}


}
