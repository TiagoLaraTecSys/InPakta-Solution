package com.laratecsys.inpaktaService.Repositorie;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laratecsys.inpaktaService.Domain.Cliente;

public interface ClienteRepositories extends JpaRepository<Cliente, Integer> {

}
