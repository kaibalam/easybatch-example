package com.ericsson.crm.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="tc_crm_canal")
@SequenceGenerator(name="canalSq", sequenceName="cw_canal_sq", allocationSize=1)
public class CanalEnvio {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="canalSq")
	private int id;
	
	private String descripcion;
	
	private String createdby;
	
	@Column(name="fecha_creacion")
	private LocalDateTime fechaCreacion;	
}
