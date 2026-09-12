package com.unifranz.programaciontres.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract  class Auditable {
    @Column(updatable = false)
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
    @Column(updatable = false)
    private String creadoPor;
    private String modificadoPor;
    private Boolean eliminado;

    @PrePersist
    public void antesDeCrear(){
        this.fechaCreacion = LocalDateTime.now();
        this.creadoPor = "Sistema";
        this.eliminado = false;
    }

    @PreUpdate
    public void antesDeActualizar(){
        this.fechaModificacion = LocalDateTime.now();
        this.modificadoPor = "Sistema";
    }


}
