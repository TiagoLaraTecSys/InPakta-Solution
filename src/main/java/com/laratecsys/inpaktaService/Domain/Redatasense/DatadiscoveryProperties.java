package com.laratecsys.inpaktaService.Domain.Redatasense;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//@Entity
public class DatadiscoveryProperties{
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private double probabilityThreshold;
	private String modeloGeneric;
	private String tokens;
	private String skipTablesName;
	private Integer limiti;
	private Integer thresholdCount;
	private Integer thresholdHighRisk;
	private Integer scoreCalculation;
	private String extensions;
	private String models;
	private String dictionaryPath;
	private String NERmodel;

	public DatadiscoveryProperties() {

	}

	public DatadiscoveryProperties(Integer id,double probabilityThreshold, String modeloGeneric, String tokens,
			String skipTablesName, Integer limit, Integer thresholdCount, Integer thresholdHighRisk,
			Integer scoreCalculation, String extensions, String models, String dictionaryPath, String nERmodel) {
		super();
		this.id = id;
		this.probabilityThreshold = probabilityThreshold;
		this.modeloGeneric = modeloGeneric;
		this.tokens = tokens;
		this.skipTablesName = skipTablesName;
		this.limiti = limit;
		this.thresholdCount = thresholdCount;
		this.thresholdHighRisk = thresholdHighRisk;
		this.scoreCalculation = scoreCalculation;
		this.extensions = extensions;
		this.models = models;
		this.dictionaryPath = dictionaryPath;
		NERmodel = nERmodel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getProbabilityThreshold() {
		return probabilityThreshold;
	}

	public void setProbabilityThreshold(double probabilityThreshold) {
		this.probabilityThreshold = probabilityThreshold;
	}

	public String getModeloGeneric() {
		return modeloGeneric;
	}

	public void setModeloGeneric(String modeloGeneric) {
		this.modeloGeneric = modeloGeneric;
	}

	public String getTokens() {
		return tokens;
	}

	public void setTokens(String tokens) {
		this.tokens = tokens;
	}

	public String getSkipTablesName() {
		return skipTablesName;
	}

	public void setSkipTablesName(String skipTablesName) {
		this.skipTablesName = skipTablesName;
	}

	public Integer getLimit() {
		return limiti;
	}

	public void setLimit(Integer limit) {
		this.limiti = limit;
	}

	public Integer getThresholdCount() {
		return thresholdCount;
	}

	public void setThresholdCount(Integer thresholdCount) {
		this.thresholdCount = thresholdCount;
	}

	public Integer getThresholdHighRisk() {
		return thresholdHighRisk;
	}

	public void setThresholdHighRisk(Integer thresholdHighRisk) {
		this.thresholdHighRisk = thresholdHighRisk;
	}

	public Integer getScoreCalculation() {
		return scoreCalculation;
	}

	public void setScoreCalculation(Integer scoreCalculation) {
		this.scoreCalculation = scoreCalculation;
	}

	public String getExtensions() {
		return extensions;
	}

	public void setExtensions(String extensions) {
		this.extensions = extensions;
	}

	public String getModels() {
		return models;
	}

	public void setModels(String models) {
		this.models = models;
	}

	public String getDictionaryPath() {
		return dictionaryPath;
	}

	public void setDictionaryPath(String dictionaryPath) {
		this.dictionaryPath = dictionaryPath;
	}

	public String getNERmodel() {
		return NERmodel;
	}

	public void setNERmodel(String nERmodel) {
		NERmodel = nERmodel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DatadiscoveryProperties other = (DatadiscoveryProperties) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
