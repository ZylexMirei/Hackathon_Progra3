package com.unifranz.programaciontres.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UsuarioAdmin extends Usuario{
    public UsuarioAdmin(){
        setRol("ADMIN");
    }
}
