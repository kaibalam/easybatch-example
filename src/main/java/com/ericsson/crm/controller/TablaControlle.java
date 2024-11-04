package com.ericsson.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ericsson.crm.model.Campos;
import com.ericsson.crm.model.Tablas;
import com.ericsson.crm.service.CamposService;
import com.ericsson.crm.service.TablasService;

@RestController
public class TablaControlle {

	@Autowired
	private TablasService tablasService;
	
	@Autowired
	private CamposService camposService;
	
	@GetMapping("/api/tablas")
	public List<Tablas> getTablas(){
		List<Tablas> list = tablasService.getAll();
		return list;
	}
	
	@GetMapping("/api/campos/{id}")
	public List<Campos> getCamposByIdTablas(@PathVariable int id){
		List<Campos> list = camposService.getCamposByTabla(id);
		
		return list;
	}
	
	
}
