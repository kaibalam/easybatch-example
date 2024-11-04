package com.ericsson.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ericsson.crm.model.CanalEnvio;

@Repository
public interface CanalEnvioRepository extends JpaRepository<CanalEnvio, Integer> {

}
