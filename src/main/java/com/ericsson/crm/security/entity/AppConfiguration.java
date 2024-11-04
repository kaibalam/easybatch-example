package com.ericsson.crm.security.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "tc_conf_aplicacion")
public class AppConfiguration {

	@Id
	@Column(name = "tcconfaplicacionid")
	private Long id;
	private String aplicacion;
	@Column(name = "tipo_objeto")
	private String tipoObjeto;
	private String objeto;
	@Column(name = "valor_objeto1")
	private String valorObjeto1;
	@Column(name = "valor_objeto2")
	private String valorObjeto2;
	private String descripcion;
	private String activada;
	@Column(name = "swcreatedy")
	private String swCreatedY;
	@Column(name = "swdatecreated")
	private LocalDateTime swDateCreated;
	
}
