package com.ericsson.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ericsson.crm.commons.GenericServiceImp;
import com.ericsson.crm.model.Campos;
import com.ericsson.crm.model.Tablas;
import com.ericsson.crm.repository.CamposRepository;
import com.ericsson.crm.repository.TablasRepository;
import com.ericsson.crm.service.CamposService;

@Service
public class CamposImpl extends GenericServiceImp<Campos, Integer> implements CamposService{

	@Autowired
	private CamposRepository camposRepository;
	
	@Autowired
	private TablasRepository tablasRepository;
	
	@Override
	public CrudRepository<Campos, Integer> getDao() {
		return camposRepository;
	}


	@Override
	public List<Campos> getCamposByTabla(int idTabla) {
		Tablas tabla = tablasRepository.findById(idTabla).get();

		List<Campos> campos = camposRepository.findByTabla(tabla);
		
		return campos;
	}

}
