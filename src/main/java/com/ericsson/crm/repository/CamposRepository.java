package com.ericsson.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ericsson.crm.model.Campos;
import com.ericsson.crm.model.Tablas;

@Repository
public interface CamposRepository extends JpaRepository<Campos, Integer> {

	 List<Campos> findByTabla(Tablas tabla);
}
