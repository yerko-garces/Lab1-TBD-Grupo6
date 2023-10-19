package com.Grupo6.Lab1.Controllers;

import com.Grupo6.Lab1.models.VoluntarioHabilidad;
import com.Grupo6.Lab1.services.VoluntarioHabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class VoluntarioHabilidadController {

    @Autowired
    private VoluntarioHabilidadService voluntarioHabilidadService;

    @PostMapping("/crearVoluntarioHabilidad")
    public VoluntarioHabilidad crearVoluntarioHabilidad(@RequestBody VoluntarioHabilidad voluntarioHabilidad) {
        return voluntarioHabilidadService.createVoluntarioHabilidad(voluntarioHabilidad);
    }

    @PutMapping("/actualizarVoluntarioHabilidad/{id}")
    public String actualizarVoluntarioHabilidad(@RequestBody VoluntarioHabilidad voluntarioHabilidad, @PathVariable Long id) {
        return voluntarioHabilidadService.updateVoluntarioHabilidad(voluntarioHabilidad, id);
    }

    @GetMapping("/verVoluntarioHabilidades")
    public List<VoluntarioHabilidad> mostrarVoluntarioHabilidades() {
        return voluntarioHabilidadService.getAllVoluntarioHabilidades();
    }

    @DeleteMapping("/borrarVoluntarioHabilidad/{id}")
    public void borrarVoluntarioHabilidad(@PathVariable Long id) {
        voluntarioHabilidadService.deleteVoluntarioHabilidad(id);
    }
}
