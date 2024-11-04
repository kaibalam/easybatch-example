package com.ericsson.crm.service;


import com.ericsson.crm.commons.GenericService;
import com.ericsson.crm.model.Campania;
import com.ericsson.crm.model.RequestCampania;

public interface CampaniaService extends GenericService<Campania, Integer>{

    RequestCampania saveOrderAndDetails(RequestCampania objOrdenCompra);
    
    Campania updateEjecution(Integer id);
	
}
