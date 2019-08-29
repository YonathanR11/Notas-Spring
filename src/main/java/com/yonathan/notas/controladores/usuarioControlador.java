package com.yonathan.notas.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yonathan.notas.entidades.Usuario;
import com.yonathan.notas.servicio.usuarioServicio;

@RestController
@RequestMapping(path = "/")
public class usuarioControlador {
	
	@Autowired
	@Qualifier("usuarioServicio")
	usuarioServicio usuarioServicio;
	
	ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
	
	@RequestMapping(path = "usuarios", method = RequestMethod.GET)
	public @ResponseBody List<Usuario> listarUsuarios() {
		try {
			return usuarioServicio.listar();
		} catch (Exception ex) {
			return null;
		}
	}
	
	@RequestMapping(path = "usuarios", method = RequestMethod.POST)
	public @ResponseBody boolean registrarUsuario(@RequestBody String usuarioJSON) {
		try {
			Usuario usuario = new Usuario();
//
			usuario = mapper.readValue(usuarioJSON, Usuario.class);
			if (usuarioServicio.agregar(usuario)) {
				return true;
			}
			return false;
		} catch (Exception ex) {
			return false;
		}
	}
	
	@RequestMapping(path = "usuarios", method = RequestMethod.PUT)
	public @ResponseBody boolean actualizarUsuario(@RequestBody String usuarioJSON) {
		try {
			Usuario usuario = new Usuario();

			usuario = mapper.readValue(usuarioJSON, Usuario.class);

			if (usuarioServicio.actualizar(usuario)) {
				return true;
			}
			return false;
		} catch (Exception ex) {
			return false;
		}
	}
	
	@RequestMapping(path = "usuarios", method = RequestMethod.DELETE)
	public @ResponseBody boolean borrarUsuario(@RequestBody String usuarioJSON) {
		try {
			if (usuarioJSON != null) {
				Usuario usuario = mapper.readValue(usuarioJSON, Usuario.class);
				return usuarioServicio.borrar(usuario);
			}
			return false;
		} catch (Exception ex) {
			return false;
		}
	}

}
