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
@Table(name="tc_crm_tipo_producto")
@Getter
@Setter
@SequenceGenerator(name="tipoProductoSq", sequenceName="cw_tipoproducto_sq", allocationSize=1)
public class TipoProducto {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tipoProductoSq")
	private int id;
	
	private String descripcion;
	
	private String createdby;
	
	@Column(name="fecha_creacion")
	private LocalDateTime fechaCreacion;	
}


