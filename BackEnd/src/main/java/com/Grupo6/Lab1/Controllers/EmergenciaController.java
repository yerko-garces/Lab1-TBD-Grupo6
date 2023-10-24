package com.Grupo6.Lab1.Controllers;

import com.Grupo6.Lab1.models.Emergencia;
import com.Grupo6.Lab1.services.EmergenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emergencia")
@CrossOrigin(origins = "http://localhost:5173")
public class EmergenciaController {

    @Autowired
    private EmergenciaService emergenciaService;

    @PostMapping("/crearEmergencia")
    public Emergencia crearEmergencia(@RequestBody Emergencia emergencia){return emergenciaService.crearEmergencia(emergencia);}

    @PutMapping("/actualizarEmergencia/{id}")
    public String actualizarEmergencia(@RequestBody Emergencia emergencia, @PathVariable Long id){
        return emergenciaService.actualizarEmergencia(emergencia, id);
    }

    @GetMapping("/verEmergencia")
    public List<Emergencia> mostrarEmergencia(){return emergenciaService.verEmergencia();}

    @DeleteMapping("/borrarEmergencia/{id}")
    public void borrarEmergencia(@PathVariable Long id){emergenciaService.borrarEmergencia(id);}

    @PostMapping("/mostrarPrerequisitos/{id}")
    public List<String> mostrarPrerequisitos(@RequestBody Long id){
        return emergenciaService.obtenerPrerequisitos(id);
    }
    @GetMapping("/verEmergenciasDisponibles/{id}")
    public List<Emergencia> verEmergenciasDisponibles(@PathVariable Long id){
        return emergenciaService.verEmergenciasDisponibles(id);
    }
}
