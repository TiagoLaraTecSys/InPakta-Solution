package com.laratecsys.inpaktaService.Domain.Redatasense;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.laratecsys.inpaktaService.Domain.Cliente;

@Entity
public class FileProperties implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String limiteDeProbabilidade;
	private String modeloGenerico;
	private	String token;
	private String modelos;
	private String diretorios;
	private String arquivosExcluidos;
	private String pastaDoDicionario;
	private String extensaoArquivo;
	private String NERmodel;
	private Date dataInsercao;
	
	@ManyToOne()
	@JoinColumn(name ="cliente_id")
	@JsonIgnore
	private Cliente cliente;
	
	@OneToMany(mappedBy="fileProperties", cascade = CascadeType.ALL)
	private List<FileResults> fileResults = new ArrayList<>();
	
	public FileProperties() {
		
	}
	

	public FileProperties(Integer id, String limiteDeProbabilidade, String modeloGenerico, String token, String modelos,
			String diretorios, String arquivosExcluidos, String pastaDoDicionario, String extensaoArquivo,
			String nERmodel, Date dataInsercao, Cliente cliente) {
		super();
		this.id = id;
		this.limiteDeProbabilidade = limiteDeProbabilidade;
		this.modeloGenerico = modeloGenerico;
		this.token = token;
		this.modelos = modelos;
		this.diretorios = diretorios;
		this.arquivosExcluidos = arquivosExcluidos;
		this.pastaDoDicionario = pastaDoDicionario;
		this.extensaoArquivo = extensaoArquivo;
		NERmodel = nERmodel;
		this.dataInsercao = dataInsercao;
		this.cliente = cliente;

	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataInsercao() {
		return dataInsercao;
	}

	public void setDataInsercao(Date dataInsercao) {
		this.dataInsercao = dataInsercao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<FileResults> getFileResults() {
		return fileResults;
	}

	public void setFileResults(List<FileResults> fileResults) {
		this.fileResults = fileResults;
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

	public String getPastaDoDicionario() {
		return pastaDoDicionario;
	}

	public void setPastaDoDicionario(String pastaDoDicionario) {
		this.pastaDoDicionario = pastaDoDicionario;
	}
	
	

}
