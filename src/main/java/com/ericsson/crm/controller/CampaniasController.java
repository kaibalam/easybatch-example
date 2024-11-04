package com.ericsson.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ericsson.crm.model.Campania;
import com.ericsson.crm.model.RequestCampania;
import com.ericsson.crm.service.CampaniaService;

@RestController
public class CampaniasController {

	@Autowired
	CampaniaService service;
	
	@GetMapping("/api/campanias")
	public List<Campania> getOrdenesCompra(){
		return service.getAll();
	}
	
	
	@PostMapping("/api/campanias-add")
	public RequestCampania postOrdenCompra(@RequestBody RequestCampania orden) {
		return service.saveOrderAndDetails(orden);
	}
	
	@DeleteMapping("/api/delete/{id}")
	public Map<String, Boolean> postOrdenCompra(@PathVariable("id") int item) {
		service.delete(item);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@PutMapping("/api/update/{id}")
	public Campania updateEjecution(@PathVariable("id") int id) {
		return service.updateEjecution(id);
	}
}
