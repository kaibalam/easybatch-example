package com.ericsson.crm.service;

import java.util.List;

import com.ericsson.crm.commons.GenericService;
import com.ericsson.crm.model.Campos;

public interface CamposService extends GenericService<Campos, Integer>{

	List<Campos> getCamposByTabla(int idTabla);

	
}
