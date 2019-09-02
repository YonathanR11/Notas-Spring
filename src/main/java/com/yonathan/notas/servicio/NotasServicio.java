package com.yonathan.notas.servicio;

import java.util.List;
import com.yonathan.notas.entidades.Nota;

public interface NotasServicio {

	public Nota obtenerPorId(int nota);

	public List<Nota> listar();
	
	public List<Nota> listarNotasDeUser(int userId);

	public boolean agregar(Nota nota);

	public boolean actualizar(Nota nota);

	public boolean borrar(Nota nota);

}