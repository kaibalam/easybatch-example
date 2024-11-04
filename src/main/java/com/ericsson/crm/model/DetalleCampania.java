package com.ericsson.crm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleCampania {

	private String funcionalidad;
	private String variables;
	private String comparador;
	private String valor;
}
