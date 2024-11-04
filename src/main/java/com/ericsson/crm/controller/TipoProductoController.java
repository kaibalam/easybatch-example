package com.ericsson.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ericsson.crm.model.TipoProducto;
import com.ericsson.crm.service.TipoProductoService;

@RestController
public class TipoProductoController {
	
	@Autowired
	private TipoProductoService tipoProductoService;
	
	@GetMapping("/api/tipo_producto")
	public List<TipoProducto> getTipoProducto(){
		List<TipoProducto> list = tipoProductoService.getAll();
		
		return list;
	}
	
}
