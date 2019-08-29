package com.yonathan.notas.repositorio;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yonathan.notas.entidades.Usuario;

@Repository("usuarioRepositorio")
public interface usuarioRepositorio extends CrudRepository<Usuario, Serializable> {

}
