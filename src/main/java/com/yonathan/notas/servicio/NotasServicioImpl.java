package com.yonathan.notas.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yonathan.notas.entidades.Nota;
import com.yonathan.notas.repositorio.NotasRepositorio;
import com.yonathan.notas.servicio.NotasServicio;

@Service("NotasServicio")
public class NotasServicioImpl implements NotasServicio {
	@Autowired
	public NotasRepositorio notasRepositorio;

	@Override
	public boolean agregarNota(Nota nota) {
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
	public boolean actualizarNota(Nota nota) {
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
	public boolean borrarNota(Nota nota) {
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
	public Nota obtenerNota(int notaID) {
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
	public List<Nota> listaNota() {
		try {
			return (List<Nota>) notasRepositorio.findAll();
		} catch (Exception ex) {
		}
		return null;
	}
}
