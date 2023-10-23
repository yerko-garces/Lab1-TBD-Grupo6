package com.Grupo6.Lab1.Controllers;

import com.Grupo6.Lab1.models.Tarea;
import com.Grupo6.Lab1.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class TareaController {
    @Autowired
    private TareaService tareaService;

    @PostMapping("/crearTarea")
    public Tarea crearTarea(@RequestBody Tarea tarea) {
        return tareaService.createTarea(tarea);
    }

    @PutMapping("/actualizarTarea/{id}")
    public String actualizarTarea(@RequestBody Tarea tarea, @PathVariable Long id) {
        return tareaService.updateTarea(tarea, id);
    }

    @GetMapping("/verTareas")
    public List<Tarea> mostrarTareas() {
        return tareaService.getAllTareas();
    }

    @DeleteMapping("/borrarTarea/{id}")
    public void borrarTarea(@PathVariable Long id) {
        tareaService.deleteTarea(id);
    }
}
