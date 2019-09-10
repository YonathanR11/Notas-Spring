package com.yonathan.notas.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="archivo")
public class Archivos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column()
	private String nombre;
	
	@NotNull
	@Column()
	private String path;
	
	@NotNull
	@Column()
	private String extension;
	
	@ManyToOne()
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Archivos() {
	}

	public Archivos(@NotNull String nombre, @NotNull String path, @NotNull String extension) {
		super();
		this.nombre = nombre;
		this.path = path;
		this.extension = extension;
	}
	
	public Archivos(@NotNull String nombre, @NotNull String path, @NotNull String extension, Usuario usuario) {
		super();
		this.nombre = nombre;
		this.path = path;
		this.extension = extension;
		this.usuario = usuario;
	}

	public Archivos(int id, @NotNull String nombre, @NotNull String path, @NotNull String extension, Usuario usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.path = path;
		this.extension = extension;
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Archivos [id=" + id + ", nombre=" + nombre + ", path=" + path + ", extension=" + extension + "]";
	}
	
	
}
