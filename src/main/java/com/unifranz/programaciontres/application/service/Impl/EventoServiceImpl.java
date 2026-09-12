package com.unifranz.programaciontres.application.service.Impl;

import com.unifranz.programaciontres.application.service.EventoService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EventoServiceImpl implements EventoService {

    @Override
    public Map<String, Object> validarAcceso (int edad, boolean pago){
        boolean puedeEntrar;
        String motivo;

        if (edad < 18){
            puedeEntrar = false;
            motivo = "es menor de edad";
        } else if (!pago) {
           puedeEntrar = false;
           motivo = "No Pago";
        } else {
            puedeEntrar = true;
            motivo=" si esta permitido";
        }
        Map<String, Object> salida = new HashMap<>();
        salida.put("puedeEntrar", puedeEntrar);
        salida.put("motivo", motivo);

        return salida;
    }

}
