package com.laratecsys.inpaktaService.Domain.Redatasense.DTO;

public class FilePropertiesDTO {
	
	private String limiteDeProbabilidade;
	private String modeloGenerico;
	private	String token;
	private String modelos;
	private String diretorios;
	private String arquivosExcluidos;
	private String pastaDoDicionario;
	private String extensaoArquivo;
	private String NERmodel;
	
	
	public FilePropertiesDTO() {
		
	}
	
	public FilePropertiesDTO(String limiteDeProbabilidade, String modeloGenerico, String token, String modelos,
			String diretorios, String arquivosExcluidos, String pastaDoDicionario, String extensaoArquivo,
			String nERmodel) {
		super();
		this.limiteDeProbabilidade = limiteDeProbabilidade;
		this.modeloGenerico = modeloGenerico;
		this.token = token;
		this.modelos = modelos;
		this.diretorios = diretorios;
		this.arquivosExcluidos = arquivosExcluidos;
		this.pastaDoDicionario = pastaDoDicionario;
		this.extensaoArquivo = extensaoArquivo;
		NERmodel = nERmodel;
	}
	public String getLimiteDeProbabilidade() {
		return limiteDeProbabilidade;
	}
	public void setLimiteDeProbabilidade(String limiteDeProbabilidade) {
		this.limiteDeProbabilidade = limiteDeProbabilidade;
	}
	public String getModeloGenerico() {
		return modeloGenerico;
	}
	public void setModeloGenerico(String modeloGenerico) {
		this.modeloGenerico = modeloGenerico;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getModelos() {
		return modelos;
	}
	public void setModelos(String modelos) {
		this.modelos = modelos;
	}
	public String getDiretorios() {
		return diretorios;
	}
	public void setDiretorios(String diretorios) {
		this.diretorios = diretorios;
	}
	public String getArquivosExcluidos() {
		return arquivosExcluidos;
	}
	public void setArquivosExcluidos(String arquivosExcluidos) {
		this.arquivosExcluidos = arquivosExcluidos;
	}
	public String getPastaDoDicionario() {
		return pastaDoDicionario;
	}
	public void setPastaDoDicionario(String pastaDoDicionario) {
		this.pastaDoDicionario = pastaDoDicionario;
	}
	public String getExtensaoArquivo() {
		return extensaoArquivo;
	}
	public void setExtensaoArquivo(String extensaoArquivo) {
		this.extensaoArquivo = extensaoArquivo;
	}
	public String getNERmodel() {
		return NERmodel;
	}
	public void setNERmodel(String nERmodel) {
		NERmodel = nERmodel;
	}
	
	

}
