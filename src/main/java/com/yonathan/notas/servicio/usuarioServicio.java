package com.yonathan.notas.servicio;

import java.util.List;

import com.yonathan.notas.entidades.Usuario;

public interface usuarioServicio {
	
	public Usuario obtenerPorId(int usuario);
	
	public Usuario login(Usuario usuario);

	public List<Usuario> listar();

	public boolean agregar(Usuario usuario);

	public boolean actualizar(Usuario usuario);

	public boolean borrar(Usuario usuario);
}
