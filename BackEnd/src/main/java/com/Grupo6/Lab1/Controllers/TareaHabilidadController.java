package com.Grupo6.Lab1.Controllers;

import com.Grupo6.Lab1.models.TareaHabilidad;
import com.Grupo6.Lab1.services.TareaHabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class TareaHabilidadController {
    @Autowired
    private TareaHabilidadService tareaHabilidadService;

    @PostMapping("/crearTareaHabilidad")
    public TareaHabilidad crearTareaHabilidad(@RequestBody TareaHabilidad tareaHabilidad) {
        return tareaHabilidadService.createTareaHabilidad(tareaHabilidad);
    }

    @PutMapping("/actualizarTareaHabilidad/{id}")
    public String actualizarTareaHabilidad(@RequestBody TareaHabilidad tareaHabilidad, @PathVariable Long id) {
        return tareaHabilidadService.updateTareaHabilidad(tareaHabilidad, id);
    }

    @GetMapping("/verTareaHabilidades")
    public List<TareaHabilidad> mostrarTareaHabilidades() {
        return tareaHabilidadService.getAllTareaHabilidades();
    }

    @DeleteMapping("/borrarTareaHabilidad/{id}")
    public void borrarTareaHabilidad(@PathVariable Long id) {
        tareaHabilidadService.deleteTareaHabilidad(id);
    }
}
