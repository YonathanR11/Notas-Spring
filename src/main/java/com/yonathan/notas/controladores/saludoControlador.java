package com.yonathan.notas.controladores;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.yonathan.notas.entidades.Mensaje;
import com.yonathan.notas.entidades.Saludo;

@Controller
public class saludoControlador {

	@MessageMapping("/hola")
    @SendTo("/tema/saludos")
    public Saludo saludo(Mensaje mensaje) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Saludo("Hola, " + HtmlUtils.htmlEscape(mensaje.getNombre()) + "!");
    }
}
