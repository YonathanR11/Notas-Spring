package com.yonathan.notas.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yonathan.notas.entidades.Usuario;
import com.yonathan.notas.repositorio.usuarioRepositorio;
import com.yonathan.notas.servicio.usuarioServicio;


@Service("usuarioServicio")
public class usuarioServicioImpl implements usuarioServicio {
	@Autowired
	public usuarioRepositorio usuarioRepositorio;
	
	@Override
	public boolean agregar(Usuario usuario) {
		try {
			if (usuario != null) {
				usuarioRepositorio.save(usuario);
				return true;
			}
			return false;
		} catch (Exception ex) {
			System.out.println("\nError agregar\n"+ex.getMessage());
			return false;
		}
	}

	@Override
	public Usuario obtenerPorId(int usuarioID) {
		try {
			if (usuarioID > 0) {
				return usuarioRepositorio.findById(usuarioID).get();
			}
			return null;
		} catch (Exception ex) {
			System.out.println("\nError obtenerPorId\n"+ex.getMessage());
			return null;
		}
	}

	@Override
	public List<Usuario> listar() {
		try {
			return (List<Usuario>) usuarioRepositorio.findAll();
		} catch (Exception ex) {
			System.out.println("\nError listar\n"+ex.getMessage());
		}
		return null;
	}

	@Override
	public boolean actualizar(Usuario usuario) {
		try {
			if (usuario != null) {
				usuarioRepositorio.save(usuario);
				return true;
			}
			return false;
		} catch (Exception ex) {
			System.out.println("\nError actualizar\n"+ex.getMessage());
			return false;
		}
	}

	@Override
	public boolean borrar(Usuario usuario) {
		try {
			if (usuario != null) {
				usuarioRepositorio.delete(usuario);
				return true;
			}
			return false;
		} catch (Exception ex) {
			System.out.println("\nError borrar\n"+ex.getMessage());
			return false;
		}
	}
}
