package com.yonathan.notas.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Notas")
public class Nota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Size(min = 1, max = 50)
	@Column(length = 50, nullable = false)
	private String titulo;

	@NotNull
	@Size(min = 1, max = 50)
	@Column(length = 50, nullable = false)
	private String contenido;

	@NotNull
	@Column(nullable = false)
	private Date fecha;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Nota() {

	}

	public Nota(@NotNull @Size(min = 1, max = 50) String titulo, @NotNull @Size(min = 1, max = 50) String contenido,
			@NotNull Date fecha) {
		super();
		this.titulo = titulo;
		this.contenido = contenido;
		this.fecha = fecha;
	}

	public Nota(int id, @NotNull @Size(min = 1, max = 50) String titulo,
			@NotNull @Size(min = 1, max = 50) String contenido, @NotNull Date fecha) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.contenido = contenido;
		this.fecha = fecha;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Nota [id=" + id + ", titulo=" + titulo + ", contenido=" + contenido + ", fecha=" + fecha + "]";
	}

}
