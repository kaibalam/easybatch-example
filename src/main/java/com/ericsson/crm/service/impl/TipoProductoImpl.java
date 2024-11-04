package com.ericsson.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ericsson.crm.commons.GenericServiceImp;
import com.ericsson.crm.model.TipoProducto;
import com.ericsson.crm.repository.TipoProductoRepository;
import com.ericsson.crm.service.TipoProductoService;

@Service
public class TipoProductoImpl extends GenericServiceImp<TipoProducto, Integer> implements TipoProductoService{
	
	@Autowired
	TipoProductoRepository repository;

	@Override
	public CrudRepository<TipoProducto, Integer> getDao() {
		return repository;
	}

}
