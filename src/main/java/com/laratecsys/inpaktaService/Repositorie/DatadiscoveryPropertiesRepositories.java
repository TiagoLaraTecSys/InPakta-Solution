package com.laratecsys.inpaktaService.Repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laratecsys.inpaktaService.Domain.Redatasense.DatadiscoveryProperties;

@Repository
public interface DatadiscoveryPropertiesRepositories extends JpaRepository<DatadiscoveryProperties, Integer> {

}
