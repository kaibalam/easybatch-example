package com.ericsson.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ericsson.crm.model.Campania;

@Repository
public interface CampaniaRepository extends JpaRepository<Campania, Integer> {

	Campania getById(Integer id);
}
