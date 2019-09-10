package com.yonathan.notas.servicio;

import java.util.List;

import com.yonathan.notas.entidades.Archivos;


public interface ArchivosServicio {
	public Archivos obtenerPorId(int archivo);
	
	public List<Archivos> listarArchivosDeUser(int userId);
	
	public List<Archivos> listar();
	
	public boolean subir(Archivos archivo);
	
	public boolean actualizar(Archivos archivo);
	
	public boolean elminar(Archivos archivo);
}
