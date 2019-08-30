package com.yonathan.notas.repositorio;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yonathan.notas.entidades.Usuario;

@Repository("usuarioRepositorio")
public interface usuarioRepositorio extends CrudRepository<Usuario, Serializable> {
	@Query(value = "SELECT * FROM usuario WHERE usuario = :usuario", nativeQuery = true)
    public Usuario login(@Param("usuario") String usuario);
}
