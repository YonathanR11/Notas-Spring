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
import com.yonathan.notas.servicio.NotasServicio;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NotasApplicationTests {


	@Autowired
	@Qualifier("NotasServicio")
	NotasServicio notaService;
	
	@Test
	public void AgregarNota() {		
		for(int i = 0; i < 5; i++) {
			int numero = (int) (Math.random() * 10000) + 1;
			int dia = (int) (Math.random() * 30) + 1;
			int mes = (int) (Math.random() * 9) + 1;
		try {
            Nota nota = new Nota("Titulo de la nota numero: "+numero, "Texto de Contenido en la nota numero: "+numero, Date.valueOf("2018-"+mes+"-"+dia));
            if (notaService.agregarNota(nota)) {
            } else {
            	System.out.println("NO SE AGREGO LA NOTA :c");
            }
        }
        catch (Exception ex) {
        	System.out.println("ERROR: "+ex.getMessage());
        }
		}
	}
	
	@Test
    public void borrarNota() {
        try {
        	Nota nota = notaService.obtenerNota(4);
            if (notaService.borrarNota(nota)) {
            } else {
            	System.out.println("NO SE ELIMINO :c");
            }
        }
        catch (Exception ex) {
        	System.out.println("ERROR: "+ex.getMessage());
        }
    }
	
	@Test
    public void actualizarNota() {
        try {
        	Nota nota = new Nota(5, "Contenido 006", "Quinta nota", Date.valueOf("2019-08-23"));

            if (notaService.obtenerNota(5) != null) {
            	notaService.actualizarNota(nota);
            } else {
            	System.out.println("NO SE ACTUALIZO :c");
            }
        }
        catch (Exception ex) {
        	System.out.println("ERROR: "+ex.getMessage());
        }
    }
	
	@Test
    public void ListarNotas() {
        try {
            List<Nota> notas = new ArrayList<>();
            notas = notaService.listaNota();
            System.out.println("\n============ NOTAS ============");
            for (Nota nota : notas) {
            	System.out.println(nota.toString());
            }
        }
        catch (Exception ex) {
        	System.out.println("ERROR: "+ex.getMessage());
        }
    }

}
