package com.yonathan.notas.servicio.implementacion;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yonathan.notas.entidades.Nota;
import com.yonathan.notas.repositorio.NotasRepositorio;
import com.yonathan.notas.servicio.NotasServicio;

@Service("NotasServicio")
public class NotasServicioImpl implements NotasServicio {
	@Autowired
	public NotasRepositorio notasRepositorio;
	
	private static final Logger logger = LoggerFactory.getLogger(NotasServicioImpl.class);

	@Override
	public boolean agregar(Nota nota) {
		try {
			if (nota != null) {
				notasRepositorio.save(nota);
				return true;
			}
			return false;
		} catch (Exception ex) {
			logger.error("ERROR: "+ex.getMessage());
			return false;
		}
	}

	@Override
	public boolean actualizar(Nota nota) {
		try {
			if (nota != null) {
				notasRepositorio.save(nota);
				return true;
			}
			return false;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean borrar(Nota nota) {
		try {
			if (nota != null) {
				notasRepositorio.delete(nota);
				return true;
			}
			return false;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public Nota obtenerPorId(int notaID) {
		try {
			if (notaID > 0) {
				return notasRepositorio.findById(notaID).get();
			}
			return null;
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public List<Nota> listar() {
		try {
			return (List<Nota>) notasRepositorio.findAll();
		} catch (Exception ex) {
		}
		return null;
	}
	
	@Override
	public List<Nota> listarNotasDeUser(int userId) {
		try {
			return (List<Nota>) notasRepositorio.findByUsuario_Id(userId);
		} catch (Exception ex) {
		}
		return null;
	}
}
