package com.unifranz.programaciontres.infrastructure.persistence;

import com.unifranz.programaciontres.application.dto.UsuarioDto;
import com.unifranz.programaciontres.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {



    @Query("SELECT new com.unifranz.programaciontres.application.dto.UsuarioDto(u)"+
            " FROM Usuario u" +
            " WHERE u.eliminado = false")
    List<UsuarioDto> listarActivos();
}
