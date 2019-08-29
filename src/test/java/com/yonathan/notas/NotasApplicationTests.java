package com.yonathan.notas;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yonathan.notas.entidades.Nota;
import com.yonathan.notas.entidades.Usuario;

import com.yonathan.notas.servicio.NotasServicio;
import com.yonathan.notas.servicio.usuarioServicio;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NotasApplicationTests {

	@Autowired
	@Qualifier("NotasServicio")
	NotasServicio notaService;

	@Autowired
	@Qualifier("usuarioServicio")
	usuarioServicio usuarioService;

//	 TESTS DE NOTA =================================================
	@Test
	public void AgregarNota() {
		for (int i = 0; i < 10; i++) {
			int numero = (int) (Math.random() * 10000) + 1;
			int dia = (int) (Math.random() * 30) + 1;
			int mes = (int) (Math.random() * 9) + 1;
			try {
				Nota nota = new Nota("Titulo de la nota numero: " + numero,
						"Texto de Contenido en la nota numero: " + numero, Date.valueOf("2018-" + mes + "-" + dia));
				if (notaService.agregar(nota)) {
					System.out.println("SI SE AGREGO LA NOTA c:");
				} else {
					System.out.println("NO SE AGREGO LA NOTA :c");
				}
			} catch (Exception ex) {
				System.out.println("ERROR: " + ex.getMessage());
			}
		}
	}

	@Test
	public void borrarNota() {
		try {
			Nota nota = notaService.obtenerPorId(4);
			if (notaService.borrar(nota)) {
			} else {
				System.out.println("NO SE ELIMINO :c");
			}
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	}

	@Test
	public void actualizarNota() {
		try {
			Nota nota = new Nota(5, "Contenido 006", "Quinta nota", Date.valueOf("2019-08-23"));

			if (notaService.obtenerPorId(5) != null) {
				notaService.actualizar(nota);
			} else {
				System.out.println("NO SE ACTUALIZO :c");
			}
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	}

	@Test
	public void ListarNotas() {
		try {
			List<Nota> notas = new ArrayList<>();
			notas = notaService.listar();
			System.out.println("\n============ NOTAS ============");
			for (Nota nota : notas) {
				System.out.println(nota.toString());
			}
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	}
//	 FIN TESTS DE NOTA =================================================

//	 TESTS DE USUARIO =================================================
	@Test
	public void ListarUsuarios() {
		try {
			List<Usuario> usuarios = new ArrayList<>();
			usuarios = usuarioService.listar();
			System.out.println("\n============ USUARIOS ============");
			for (Usuario usuario : usuarios) {
				System.out.println(usuario.toString());
			}
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	}

	@Test
	public void AgregarUsuario() {
		for (int i = 0; i < 10; i++) {
			int numero = (int) (Math.random() * 100) + 1;
			try {
				Usuario usuario = new Usuario("Nombre " + numero, "correo" + numero + "@mail.com", "user" + numero,
						"pass" + numero, 1);
				System.out.println("User: "+usuario);
				if (usuarioService.agregar(usuario)) {
					System.out.println("SI SE AGREGO EL USUARIO c:");
				} else {
					System.out.println("NO SE AGREGO EL USUARIO :c");
				}
			} catch (Exception ex) {
				System.out.println("ERROR: " + ex.getMessage());
			}
		}
	}

	@Test
	public void actualizarUsuario() {
		try {
			Usuario usuario = new Usuario(1,"Nombre actualizado", "correoUpdate@mail.com", "UsuarioActualizado",
					"passActualizado",1);

			if (usuarioService.obtenerPorId(1) != null) {
				System.out.println("SI SE ACTUALIZO c:");
				usuarioService.actualizar(usuario);
			} else {
				System.out.println("NO SE ACTUALIZO :c");
			}
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	}

	@Test
	public void borrarUsuario() {
		try {
			Usuario usuario = usuarioService.obtenerPorId(11);
			if (usuarioService.borrar(usuario)) {
			} else {
				System.out.println("NO SE ELIMINO :c");
			}
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	}
}
