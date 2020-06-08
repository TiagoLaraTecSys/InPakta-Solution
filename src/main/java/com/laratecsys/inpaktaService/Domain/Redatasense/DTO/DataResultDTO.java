package com.laratecsys.inpaktaService.Domain.Redatasense.DTO;

public class DataResultDTO {
	
	String run_id;
	String 	schema_name;
	String 	table_name;
	String 	column_name;
	double 	probability;
	String 	model;
	String 	model_mode;
	String 	dictionary;
	Integer	num_rows;
	Integer	score;
	String 	sample_data;
	Integer id_db;
	
	public DataResultDTO() {}
	
	
	public DataResultDTO(String run_id, String schema_name, String table_name, String column_name, double probability,
			String model, String model_mode, String dictionary, Integer num_rows, Integer score, String sample_data,
			Integer id_db) {
		super();
		this.run_id = run_id;
		this.schema_name = schema_name;
		this.table_name = table_name;
		this.column_name = column_name;
		this.probability = probability;
		this.model = model;
		this.model_mode = model_mode;
		this.dictionary = dictionary;
		this.num_rows = num_rows;
		this.score = score;
		this.sample_data = sample_data;
		this.id_db = id_db;
	}
	public String getRun_id() {
		return run_id;
	}
	public void setRun_id(String run_id) {
		this.run_id = run_id;
	}
	public String getSchema_name() {
		return schema_name;
	}
	public void setSchema_name(String schema_name) {
		this.schema_name = schema_name;
	}
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	public String getColumn_name() {
		return column_name;
	}
	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}
	public double getProbability() {
		return probability;
	}
	public void setProbability(double probability) {
		this.probability = probability;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getModel_mode() {
		return model_mode;
	}
	public void setModel_mode(String model_mode) {
		this.model_mode = model_mode;
	}
	public String getDictionary() {
		return dictionary;
	}
	public void setDictionary(String dictionary) {
		this.dictionary = dictionary;
	}
	public Integer getNum_rows() {
		return num_rows;
	}
	public void setNum_rows(Integer num_rows) {
		this.num_rows = num_rows;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getSample_data() {
		return sample_data;
	}
	public void setSample_data(String sample_data) {
		this.sample_data = sample_data;
	}
	public Integer getId_db() {
		return id_db;
	}
	public void setId_db(Integer id_db) {
		this.id_db = id_db;
	}
	
	
	
	

}
