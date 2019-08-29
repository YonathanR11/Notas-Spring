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
import com.yonathan.notas.entidades.Nota;
import com.yonathan.notas.servicio.NotasServicio;

@RestController
@RequestMapping(path = "/")
public class NotaControlador {

	@Autowired
	@Qualifier("NotasServicio")
	NotasServicio notaService;

	ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
	
//	private static final Logger logger = LoggerFactory.getLogger(NotaControlador.class);
	
	@RequestMapping(path = "notas", method = RequestMethod.GET)
	public @ResponseBody List<Nota> listaNota() {
		try {
			return notaService.listar();
		} catch (Exception ex) {
			return null;
		}
	}

	@RequestMapping(path = "notas", method = RequestMethod.POST)
	public @ResponseBody boolean registrarNota(@RequestBody String notaJSON) {
		try {
			Nota nota = new Nota();
//
			nota = mapper.readValue(notaJSON, Nota.class);
			if (notaService.agregar(nota)) {
				return true;
			}
			return false;
		} catch (Exception ex) {
			return false;
		}
	}

	@RequestMapping(path = "notas", method = RequestMethod.PUT)
	public @ResponseBody boolean actualizarNota(@RequestBody String notaJSON) {
		try {
			Nota nota = new Nota();

			nota = mapper.readValue(notaJSON, Nota.class);

			if (notaService.actualizar(nota)) {
				return true;
			}
			return false;
		} catch (Exception ex) {
			return false;
		}
	}

	@RequestMapping(path = "notas", method = RequestMethod.DELETE)
	public @ResponseBody boolean borrarNota(@RequestBody String notaJSON) {
		try {
			if (notaJSON != null) {
				Nota nota = mapper.readValue(notaJSON, Nota.class);
				return notaService.borrar(nota);
			}
			return false;
		} catch (Exception ex) {
			return false;
		}
	}

}
