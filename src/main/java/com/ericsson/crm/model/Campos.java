package com.ericsson.crm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tc_crm_campos")
@AllArgsConstructor@NoArgsConstructor
@Data
@SequenceGenerator(name="camposSq", sequenceName="cw_campos_sq", allocationSize=1)
public class Campos {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="camposSq")
	private int id;
	
	private String nombre;
	
	private String campoReferencia;
	
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name="id_tabla", nullable=false, updatable=false)
	@JsonBackReference
	private Tablas tabla;
	
}
