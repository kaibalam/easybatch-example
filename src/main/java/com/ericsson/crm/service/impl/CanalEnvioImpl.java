package com.ericsson.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ericsson.crm.commons.GenericServiceImp;
import com.ericsson.crm.model.CanalEnvio;
import com.ericsson.crm.repository.CanalEnvioRepository;
import com.ericsson.crm.service.CanalEnvioService;

@Service
public class CanalEnvioImpl extends GenericServiceImp<CanalEnvio, Integer> implements CanalEnvioService{

	@Autowired
	private CanalEnvioRepository canalEnvioRepository;
	
	@Override
	public CrudRepository<CanalEnvio, Integer> getDao() {
		return canalEnvioRepository;
	}



}
