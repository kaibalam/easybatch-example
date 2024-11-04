package com.ericsson.crm.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tc_crm_campania")
@AllArgsConstructor
@NoArgsConstructor
@Data
@SequenceGenerator(name="campaniaSq", sequenceName="cw_campania_sq", allocationSize=1)
public class Campania {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="campaniaSq")
	private int id;
	private String nombre;
	private int tipoProductoId;
	private int tipoCanalId;
	private LocalDate fchInicio;
	private LocalDate fchFin;
	private String horaInicio;
	private int prioridad;
	private String remitente;

	private String estado;
	private String mensaje;
	private String campos;
	private String funcionalidad;
	private String filtros;
}
