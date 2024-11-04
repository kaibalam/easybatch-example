package com.ericsson.crm.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ericsson.crm.security.entity.AppConfiguration;

public interface ConfigurationRepository extends JpaRepository<AppConfiguration, Long> {

	Optional<AppConfiguration> findByAplicacionAndTipoObjetoAndActivadaAndObjeto(String aplicacion, String tipoObjeto,
			String activada, String objeto);

	Optional<AppConfiguration> findByAplicacionAndTipoObjetoAndObjeto(String aplicacion, String tipoObjeto, String objeto);

}
