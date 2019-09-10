package com.yonathan.notas.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Size(min = 1, max = 100)
	@Column(length = 50, nullable = false)
	private String nombre;
	
	@NotNull
	@Size(min = 1, max = 50)
	@Column(length = 50, nullable = false, unique = true)
	private String correo;
	
	@NotNull
	@Size(min = 1, max = 25)
	@Column(length = 50, nullable = false, unique = true)
	private String usuario;
	
	@NotNull
	@Size(min = 1, max = 25)
	@Column(length = 50, nullable = false)
	private String password;
	
	@NotNull
	@Column(length = 50, nullable = false, columnDefinition = "integer default 1")
//	@Column(length = 50, nullable = false)
	private int estatus;
	
//	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
//	private List<Nota> notas;
	
//	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
//	private List<Archivos> notas;

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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

//	public List<Nota> getNotas() {
//		return null;
//	}
//
//	public void setNotas(List<Nota> notas) {
//		this.notas = new ArrayList<>();
//	}
	
	public Usuario() {
		
	}

	public Usuario(@NotNull @Size(min = 1, max = 25) String usuario,
			@NotNull @Size(min = 1, max = 25) String password) {
		super();
		this.usuario = usuario;
		this.password = password;
	}

	public Usuario(@NotNull @Size(min = 1, max = 100) String nombre, @NotNull @Size(min = 1, max = 50) String correo,
			@NotNull @Size(min = 1, max = 25) String usuario, @NotNull @Size(min = 1, max = 25) String password) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.usuario = usuario;
		this.password = password;
	}

	public Usuario(@NotNull @Size(min = 1, max = 100) String nombre, @NotNull @Size(min = 1, max = 50) String correo,
			@NotNull @Size(min = 1, max = 25) String usuario, @NotNull @Size(min = 1, max = 25) String password,
			@NotNull @Size(min = 1, max = 100) int estatus) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.usuario = usuario;
		this.password = password;
		this.estatus = estatus;
	}

	public Usuario(int id, @NotNull @Size(min = 1, max = 100) String nombre,
			@NotNull @Size(min = 1, max = 50) String correo, @NotNull @Size(min = 1, max = 25) String usuario,
			@NotNull @Size(min = 1, max = 25) String password, @NotNull @Size(min = 1, max = 100) int estatus) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.usuario = usuario;
		this.password = password;
		this.estatus = estatus;
	}
	
	

//	public Usuario(int id, @NotNull @Size(min = 1, max = 100) String nombre,
//			@NotNull @Size(min = 1, max = 50) String correo, @NotNull @Size(min = 1, max = 25) String usuario,
//			@NotNull @Size(min = 1, max = 25) String password, @NotNull int estatus, List<Nota> notas) {
//		super();
//		this.id = id;
//		this.nombre = nombre;
//		this.correo = correo;
//		this.usuario = usuario;
//		this.password = password;
//		this.estatus = estatus;
////		this.notas = notas;
//	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", usuario=" + usuario
				+ ", password=" + password + ", estatus=" + estatus + "]";
	}
	
}
