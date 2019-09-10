package com.yonathan.notas.controladores;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yonathan.notas.entidades.Archivos;
import com.yonathan.notas.servicio.ArchivosServicio;

@RestController
@RequestMapping(path = "/")
public class ArchivoControlador {

	@Autowired
	@Qualifier("ArchivosServicio")
	ArchivosServicio archivosServicio;

	ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
	private static final Logger logger = LoggerFactory.getLogger(Archivos.class);
	
	@RequestMapping(path = "archivos", method = RequestMethod.GET)
	public @ResponseBody List<Archivos> listaArchivos() {
		try {
			return archivosServicio.listar();
		} catch (Exception ex) {
			return null;
		}
	}
	
	@RequestMapping(path = "archivos", method = RequestMethod.POST)
	public @ResponseBody boolean subirArchivo(@RequestBody String archivoJSON) {
		try {
			Archivos archivo = mapper.readValue(archivoJSON, Archivos.class);
			if (archivosServicio.subir(archivo)) {
				return true;
			}
			return false;
		} catch (Exception ex) {
			return false;
		}
	}
	
	@RequestMapping(path = "archivos", method = RequestMethod.PUT)
	public @ResponseBody boolean actualizarArchivo(@RequestBody String archivoJSON) {
		try {
			Archivos archivo = mapper.readValue(archivoJSON, Archivos.class);

			if (archivosServicio.actualizar(archivo)) {
				return true;
			}
			return false;
		} catch (Exception ex) {
			return false;
		}
	}
	
	@RequestMapping(path = "archivos", method = RequestMethod.DELETE)
	public @ResponseBody boolean eliminarArchivo(@RequestBody String archivoJSON) {
		try {
			if (archivoJSON != null) {
				Archivos archivo = mapper.readValue(archivoJSON, Archivos.class);
				return archivosServicio.elminar(archivo);
			}
			return false;
		} catch (Exception ex) {
			return false;
		}
	}
}
