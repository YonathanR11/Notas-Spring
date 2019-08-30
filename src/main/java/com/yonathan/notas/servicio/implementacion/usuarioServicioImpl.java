package com.yonathan.notas.servicio.implementacion;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yonathan.notas.entidades.Usuario;
import com.yonathan.notas.repositorio.usuarioRepositorio;
import com.yonathan.notas.servicio.usuarioServicio;

@Service("usuarioServicio")
public class usuarioServicioImpl implements usuarioServicio {
	@Autowired
	public usuarioRepositorio usuarioRepositorio;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public Usuario obtenerPorId(int usuarioID) {
		try {
			if (usuarioID > 0) {
				return usuarioRepositorio.findById(usuarioID).get();
			}
			return null;
		} catch (Exception ex) {
			log.error("ERROR IMPL(obtenerPorId): "+ex.getMessage());
			return null;
		}
	}

	@Override
	public Usuario login(Usuario usuario) {
		try {
			if (usuario != null) {
				Usuario user = usuarioRepositorio.login(usuario.getUsuario());
				log.info("USER: " + user);
				if (user.getPassword().equals(usuario.getPassword())) {
					return user;
				}else {
					log.error("ELSE #1 IMPL(login)");
					return null;
				}
			}else {
				log.error("ELSE #2 IMPL(login)");
				return null;
			}
//			log.info("ERROR # 1 ");
//			return null;
		} catch (Exception ex) {
			log.error("ERROR IMPL(login): "+ex.getMessage());
			return null;
		}

	}

	@Override
	public boolean agregar(Usuario usuario) {
		try {
			if (usuario != null) {
				usuarioRepositorio.save(usuario);
				return true;
			}
			return false;
		} catch (Exception ex) {
			log.error("ERROR IMPL(agregar): "+ex.getMessage());
			return false;
		}
	}

	@Override
	public List<Usuario> listar() {
		try {
			return (List<Usuario>) usuarioRepositorio.findAll();
		} catch (Exception ex) {
			log.error("ERROR IMPL(listar): "+ex.getMessage());
			return null;
		}
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
			log.error("ERROR IMPL(actualizar): "+ex.getMessage());
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
			log.error("ERROR IMPL(borrar): "+ex.getMessage());
			return false;
		}
	}
}
