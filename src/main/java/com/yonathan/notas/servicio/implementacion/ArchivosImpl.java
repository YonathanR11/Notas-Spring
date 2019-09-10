package com.yonathan.notas.servicio.implementacion;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.yonathan.notas.entidades.Archivos;
import com.yonathan.notas.repositorio.ArchivoRepositorio;
import com.yonathan.notas.servicio.ArchivosServicio;

@Service("ArchivosServicio")
public class ArchivosImpl implements ArchivosServicio{

	
	@Autowired
	public ArchivoRepositorio archivoRepositorio;
	@Value("app.upload.files.dir")
	private String pathArchivos;
	
	private static final Logger logger = LoggerFactory.getLogger(NotasServicioImpl.class);

	@Override
	public Archivos obtenerPorId(int archivo) {
		try {
			if (archivo > 0) {
				return archivoRepositorio.findById(archivo).get();
			}
			return null;
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public List<Archivos> listarArchivosDeUser(int userId) {
		try {
			return (List<Archivos>) archivoRepositorio.findByUsuario_Id(userId);
		} catch (Exception ex) {
		}
		return null;
	}

	@Override
	public List<Archivos> listar() {
		try {
			return (List<Archivos>) archivoRepositorio.findAll();
		} catch (Exception ex) {
		}
		return null;
	}

	@Override
	public boolean subir(Archivos archivo) {
		try {
			if (archivo != null) {
				archivoRepositorio.save(archivo);
				return true;
			}
			return false;
		} catch (Exception ex) {
			logger.error("ERROR: "+ex.getMessage());
			return false;
		}
	}

	@Override
	public boolean actualizar(Archivos archivo) {
		try {
			if (archivo != null) {
				archivoRepositorio.save(archivo);
				return true;
			}
			return false;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean elminar(Archivos archivo) {
		try {
			if (archivo != null) {
				archivoRepositorio.delete(archivo);
				return true;
			}
			return false;
		} catch (Exception ex) {
			return false;
		}
	}
	
}
