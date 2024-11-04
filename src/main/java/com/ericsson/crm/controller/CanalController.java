package com.ericsson.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ericsson.crm.model.CanalEnvio;
import com.ericsson.crm.service.CanalEnvioService;

@RestController
public class CanalController {

	@Autowired
	private CanalEnvioService canalEnvioService;
	
	@GetMapping("/api/canal_envio")
	public List<CanalEnvio> getCanalEnvio(){

		return canalEnvioService.getAll();
	}
	
}
