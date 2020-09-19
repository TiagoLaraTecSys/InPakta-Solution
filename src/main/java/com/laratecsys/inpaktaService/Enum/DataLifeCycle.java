package com.laratecsys.inpaktaService.Enum;

public enum DataLifeCycle {
	
	COLLECTION(1,"Collection"),
	RETENTION(2, "Retention"),
	PROCESSING(3, "Processing"),
	TRANSFORMATION(4,"Transformation");
	
	private int cod;
	private String descricao;
	
	private DataLifeCycle(int cod, String descricao) {
		
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static DataLifeCycle toEnum(Integer cod){
		
		if (cod == null) {
			return null;
		}
		
		for (DataLifeCycle x : DataLifeCycle.values()) {
			
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
}
