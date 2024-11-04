package com.ericsson.crm.model;

import java.sql.Date;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestCampania {
	
	private String nombre;
	private int tipoProductoId;
	private int tipoCanalId;
	private String[] fchInicio;
	private Date fechaEjecucion;
	private Date fechaFin;
	private String horaInicio;
	private Boolean prioridad;
	private String remitente;
	private String estado;
	private String mensaje;
	private String[] campos;
	private ArrayList<DetalleCampania> detalle;
	
}
