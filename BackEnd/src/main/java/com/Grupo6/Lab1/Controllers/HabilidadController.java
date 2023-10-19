package com.Grupo6.Lab1.Controllers;

import com.Grupo6.Lab1.models.EstadoTarea;
import com.Grupo6.Lab1.models.Habilidad;
import com.Grupo6.Lab1.services.HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class HabilidadController {

    @Autowired
    private HabilidadService habilidadService;

    @PostMapping("/crearHabilidad")
    public void crearHabilidad(@RequestBody Habilidad habilidad){
        habilidadService.crearHabilidad(habilidad);
    }

    @PutMapping("/actualizarHabilidad/{id}")
    public void actualizarHabilidad(@RequestBody Habilidad habilidad, @PathVariable Long id){
        habilidadService.actualizarHabilidad(habilidad, id);
    }

    @GetMapping("/verHabilidad")
    public void mostrarHabilidad(){habilidadService.verHabilidad();}

    @DeleteMapping("/borrarEmergencia/{id}")
    public void borrarHabilidad(@PathVariable Long id){habilidadService.borrarHabilidad(id);}

}
