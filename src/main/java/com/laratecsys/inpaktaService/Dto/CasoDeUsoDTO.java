package com.laratecsys.inpaktaService.Dto;

import java.util.ArrayList;
import java.util.List;

import com.laratecsys.inpaktaService.Domain.Redatasense.ERP.DadosPessoais;

public class CasoDeUsoDTO {

	private String nome;
	private String descricao;
	private List<DadosPessoais> dadosPessoais = new ArrayList<>();
}
