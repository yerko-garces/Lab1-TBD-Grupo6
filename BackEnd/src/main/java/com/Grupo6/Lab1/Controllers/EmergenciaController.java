package com.Grupo6.Lab1.Controllers;

import com.Grupo6.Lab1.models.Emergencia;
import com.Grupo6.Lab1.services.EmergenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmergenciaController {

    @Autowired
    private EmergenciaService emergenciaService;

    @PostMapping("/crearEmergencia")
    public void crearEmergencia(@RequestBody Emergencia emergencia){
        emergenciaService.crearEmergencia(emergencia);
    }

    @PutMapping("/actualizarEmergencia/{id}")
    public void actualizarEmergencia(@RequestBody Emergencia emergencia, @PathVariable Long id){
        emergenciaService.actualizarEmergencia(emergencia, id);
    }

    @GetMapping("/verEmergencia")
    public void mostrarEmergencia(){
        emergenciaService.verEmergencia();
    }

    @DeleteMapping("/borrarEmergencia/{id}")
    public void borrarEmergencia(@PathVariable Long id){emergenciaService.borrarEmergencia(id);}

}
