package com.laratecsys.inpaktaService.Enum;

public enum TipoSubject {
	
	EXCLUSAO(1, "EXCLUSAO"),
	DONWLOAD(2, "DOWNLOAD"),
	ALTERACAO(3, "ALTERACAO");
	
	private int cod;
	private String descricao;
	
	private TipoSubject(int cod, String descricao) {
		
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
	
	public static TipoSubject toEnum(Integer cod){
		
		if (cod == null) {
			return null;
		}
		
		for (TipoSubject x : TipoSubject.values()) {
			
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}


}
