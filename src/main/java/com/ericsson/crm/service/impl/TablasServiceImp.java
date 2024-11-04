package com.ericsson.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ericsson.crm.commons.GenericServiceImp;
import com.ericsson.crm.model.Tablas;
import com.ericsson.crm.repository.TablasRepository;
import com.ericsson.crm.service.TablasService;

@Service
public class TablasServiceImp extends GenericServiceImp<Tablas, Integer> implements TablasService {
	
	@Autowired
	private TablasRepository tablasRepository;

	@Override
	public CrudRepository<Tablas, Integer> getDao() {
		
		return tablasRepository;
	}

}
