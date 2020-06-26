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
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DataResult implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id_data;
	String run_id;
	@JsonFormat(pattern = "dd/MM/yy HH:mm")
	Date	run_timestamp;
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
	
	@ManyToOne()
	@JoinColumn(name = "id_db")
	@JsonIgnore
	private DbProperties dbProperties;
	
	public DataResult(){
		
	}


	public DataResult(Integer id_data, String run_id, Date run_timestamp, String schema_name, String table_name,
			String column_name, double probability, String model, String model_mode, String dictionary,
			Integer num_rows, Integer score, String sample_data, DbProperties dbProperties) {
		super();
		this.id_data = id_data;
		this.run_id = run_id;
		this.run_timestamp = run_timestamp;
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
		this.dbProperties = dbProperties;
	}


	public Integer getId_data() {
		return id_data;
	}

	public void setId_data(Integer id_data) {
		this.id_data = id_data;
	}
	

	public String getRun_id() {
		return run_id;
	}

	public void setRun_id(String run_id) {
		this.run_id = run_id;
	}

	public Date getRun_timestamp() {
		return run_timestamp;
	}

	public void setRun_timestamp(Date run_timestamp) {
		this.run_timestamp = run_timestamp;
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
	
	public DbProperties getDbProperties() {
		return dbProperties;
	}

	public void setDbProperties(DbProperties optional) {
		this.dbProperties = optional;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_data == null) ? 0 : id_data.hashCode());
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
		DataResult other = (DataResult) obj;
		if (id_data == null) {
			if (other.id_data != null)
				return false;
		} else if (!id_data.equals(other.id_data))
			return false;
		return true;
	}
	
	
	
}
