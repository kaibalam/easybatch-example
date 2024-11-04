package com.ericsson.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ericsson.crm.model.Tablas;

@Repository
public interface TablasRepository extends JpaRepository<Tablas, Integer> {
	
	Tablas findByDescripcion(String name);

}
