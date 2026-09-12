package com.unifranz.programaciontres.infrastructure.web.controller;

import com.unifranz.programaciontres.application.dto.UsuarioDto;
import com.unifranz.programaciontres.application.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDto> guardar (@RequestBody UsuarioDto usuarioDto){
        UsuarioDto usuario = usuarioService.guardar(usuarioDto);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> listarUsuarios(){
        return ResponseEntity.ok(usuarioService.listar());
    }

    @GetMapping("/listarUsuarios")
    public ResponseEntity<List<UsuarioDto>> listarUsuariosActivos(){
        return ResponseEntity.ok(usuarioService.listarActivos());
    }

    @PostMapping("/guardarAdmin")
    public ResponseEntity<UsuarioDto> guardarAdmin (@RequestBody UsuarioDto usuarioDto){
        UsuarioDto usuario = usuarioService.guardarAdmin(usuarioDto);
        return ResponseEntity.ok(usuario);
    }
    @DeleteMapping("/{id}/eliminar")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Long id) {
        try {
            usuarioService.eliminarUsuarioLogico(id);
            return ResponseEntity.ok().body("{\"mensaje\": \"Usuario marcado como eliminado correctamente\"}");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }
}