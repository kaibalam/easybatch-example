package com.ericsson.crm.security.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SecUsuario {

	private long secusuarioid;
	private String usuario;
	private String nombre;
	private String apellido;
	private String clave;
	private String email;
	private long expira;
	private long bloqueado;
	private long intentosFallidos;
	private String creadoEl;
	private String creadoPor;
	private String estado;
	private long usuarioLDAP;
	private String token;
	
	public SecUsuario() {
	}
	
	public SecUsuario(Date creadoEl, String creadoPor, Long id, String usuario, String nombre, String apellido,
			String email, Integer expira, Integer bloqueado, Integer intentosFallidos, String estado,
			Integer usuarioLdap) {
		this.secusuarioid = id;
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.expira = expira;
		this.bloqueado = bloqueado;
		this.intentosFallidos = intentosFallidos;
		this.estado = estado;
		this.usuarioLDAP = usuarioLdap;
	}

	@JsonProperty("secusuarioid")
	public long getSecusuarioid() {
		return secusuarioid;
	}

	@JsonProperty("secusuarioid")
	public void setSecusuarioid(long value) {
		this.secusuarioid = value;
	}

	@JsonProperty("usuario")
	public String getUsuario() {
		return usuario;
	}

	@JsonProperty("usuario")
	public void setUsuario(String value) {
		this.usuario = value;
	}

	@JsonProperty("nombre")
	public String getNombre() {
		return nombre;
	}

	@JsonProperty("nombre")
	public void setNombre(String value) {
		this.nombre = value;
	}

	@JsonProperty("apellido")
	public String getApellido() {
		return apellido;
	}

	@JsonProperty("apellido")
	public void setApellido(String value) {
		this.apellido = value;
	}

	@JsonProperty("clave")
	public String getClave() {
		return clave;
	}

	@JsonProperty("clave")
	public void setClave(String value) {
		this.clave = value;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String value) {
		this.email = value;
	}

	@JsonProperty("expira")
	public long getExpira() {
		return expira;
	}

	@JsonProperty("expira")
	public void setExpira(long value) {
		this.expira = value;
	}

	@JsonProperty("bloqueado")
	public long getBloqueado() {
		return bloqueado;
	}

	@JsonProperty("bloqueado")
	public void setBloqueado(long value) {
		this.bloqueado = value;
	}

	@JsonProperty("intentos_fallidos")
	public long getIntentosFallidos() {
		return intentosFallidos;
	}

	@JsonProperty("intentos_fallidos")
	public void setIntentosFallidos(long value) {
		this.intentosFallidos = value;
	}

	@JsonProperty("creado_el")
	public String getCreadoEl() {
		return creadoEl;
	}

	@JsonProperty("creado_el")
	public void setCreadoEl(String value) {
		this.creadoEl = value;
	}

	@JsonProperty("creado_por")
	public String getCreadoPor() {
		return creadoPor;
	}

	@JsonProperty("creado_por")
	public void setCreadoPor(String value) {
		this.creadoPor = value;
	}

	@JsonProperty("estado")
	public String getEstado() {
		return estado;
	}

	@JsonProperty("estado")
	public void setEstado(String value) {
		this.estado = value;
	}

	@JsonProperty("usuario_ldap")
	public long getUsuarioLDAP() {
		return usuarioLDAP;
	}

	@JsonProperty("usuario_ldap")
	public void setUsuarioLDAP(long value) {
		this.usuarioLDAP = value;
	}

	@Override
	public String toString() {
		return "AuthorizationResponse [secusuarioid=" + secusuarioid + ", usuario=" + usuario + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", clave=" + clave + ", email=" + email + ", expira=" + expira
				+ ", bloqueado=" + bloqueado + ", intentosFallidos=" + intentosFallidos + ", creadoEl=" + creadoEl
				+ ", creadoPor=" + creadoPor + ", estado=" + estado + ", usuarioLDAP=" + usuarioLDAP + "]";
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
