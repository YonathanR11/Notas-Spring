package com.yonathan.notas.servicio;

import java.util.List;
import com.yonathan.notas.entidades.Nota;

public interface NotasServicio {
	public boolean agregarNota(Nota nota);

    public boolean actualizarNota(Nota nota);

    public boolean borrarNota(Nota nota);

    public Nota obtenerNota(int nota);

    public List<Nota> listaNota();
}