package com.ericsson.crm.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tc_crm_tablas")
@AllArgsConstructor
@NoArgsConstructor
@Data
@SequenceGenerator(name="tablasSq", sequenceName="cw_tablas_sq", allocationSize=1)
public class Tablas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tablasSq")
	private int id;
	
	private String descripcion;
	
	private String tablaReferencia;
	
	@Column(name="fecha_creacion") @JsonIgnore
	private LocalDateTime fechaCreacion;	
}
