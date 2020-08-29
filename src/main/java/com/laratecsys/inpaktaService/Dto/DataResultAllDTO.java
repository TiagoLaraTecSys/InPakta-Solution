package com.laratecsys.inpaktaService.Dto;

import java.util.ArrayList;

import com.laratecsys.inpaktaService.Domain.Redatasense.DataResult;

public class DataResultAllDTO {
	
	private ArrayList<DataResult> dataResultAll;

	public DataResultAllDTO() {
		
	}
	
	public DataResultAllDTO(ArrayList<DataResult> dataResultAll) {
		super();
		this.dataResultAll = dataResultAll;
	}

	public ArrayList<DataResult> getDataResultAll() {
		return dataResultAll;
	}

	public void setDataResultAll(ArrayList<DataResult> dataResultAll) {
		this.dataResultAll = dataResultAll;
	}
	
	

}
