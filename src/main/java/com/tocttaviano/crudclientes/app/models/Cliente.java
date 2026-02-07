package com.tocttaviano.crudclientes.app.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "El nombre no puede estar vacío")
	@Size(max = 45, message = "No se admiten nombres con más de 45 caracteres")
	private String nombre;
	
	@NotEmpty(message = "El apellido no puede estar vacío")
	@Size(max = 45, message = "No se admiten apellidos con más de 45 caracteres")
	private String apellido;
	
	@NotEmpty(message = "El email no puede estar vacío")
	@Email(message = "El email debe ser válido")
	@Size(max = 45, message = "No se admiten emails con más de 45 caracteres")
	private String email;
	
	@Column(name = "fecha_creacion")
	private LocalDateTime fechaCreacion;
	
	@PrePersist
	public void prePersist() {
		fechaCreacion = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", fechaCreacion=" + fechaCreacion + "]";
	}
}
