package com.yonathan.notas.repositorio;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yonathan.notas.entidades.Archivos;

@Repository("ArchivoRepositorio")
public interface ArchivoRepositorio extends CrudRepository<Archivos, Serializable>  {
	List<Archivos> findByUsuario_Id(int id);
}
