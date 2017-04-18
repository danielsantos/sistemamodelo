package com.danrock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.danrock.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
