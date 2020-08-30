package com.laratecsys.inpaktaService.Domain.Redatasense;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class FileResults implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_File;
	private String run_Id;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date run_TimeStamp;
	
	@ManyToOne()
	@JoinColumn(name="diretorio")
	private FileProperties diretorio;
	private String nomeDoArquivo;
	private String probabilidade;
	private String modelo;
	private String modeloDoModulo;
	private String dicionario;
	
	private String dadosColetados;

	

		
	public FileResults() {
	
	}
	
	
	
	public FileResults(Integer id_File, String run_Id, Date run_TimeStamp, FileProperties diretorio, String nomeDoArquivo,
			String probabilidade, String modelo, String modeloDoModulo, String dicionario, String dadosColetados) {
		super();
		this.id_File = id_File;
		this.run_Id = run_Id;
		this.run_TimeStamp = run_TimeStamp;
		this.diretorio = diretorio;
		this.nomeDoArquivo = nomeDoArquivo;
		this.probabilidade = probabilidade;
		this.modelo = modelo;
		this.modeloDoModulo = modeloDoModulo;
		this.dicionario = dicionario;
		this.dadosColetados = dadosColetados;
	}



	public Integer getId_File() {
		return id_File;
	}

	public void setId_File(Integer id_File) {
		this.id_File = id_File;
	}

	public String getRun_Id() {
		return run_Id;
	}

	public void setRun_Id(String run_Id) {
		this.run_Id = run_Id;
	}

	public Date getRun_TimeStamp() {
		return run_TimeStamp;
	}

	public void setRun_TimeStamp(Date run_TimeStamp) {
		this.run_TimeStamp = run_TimeStamp;
	}

	public FileProperties getDiretorio() {
		return diretorio;
	}

	public void setDiretorio(FileProperties diretorio) {
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

	public String getDadosColetados() {
		return dadosColetados;
	}

	public void setDadosColetados(String dadosColetados) {
		this.dadosColetados = dadosColetados;
	}



}
