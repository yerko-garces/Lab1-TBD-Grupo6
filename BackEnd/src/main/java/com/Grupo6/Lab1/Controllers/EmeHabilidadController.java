package com.Grupo6.Lab1.Controllers;

import com.Grupo6.Lab1.models.EmeHabilidad;
import com.Grupo6.Lab1.services.EmeHabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmeHabilidadController {

    @Autowired
    private EmeHabilidadService emeHabilidadService;

    @PostMapping("/crearEmeHabilidad")
    public void crearEmeHa(@RequestBody EmeHabilidad emeHabilidad){
        emeHabilidadService.crearEmeHabilidad(emeHabilidad);
    }

    @PutMapping("/actualizarEmeHabilidad/{id}")
    public void actualizarEmeHa(@RequestBody EmeHabilidad emeHabilidad, @PathVariable Long id){
        emeHabilidadService.actualizarEmeHabilidad(emeHabilidad, id);
    }

    @GetMapping("/verEmeHabilidad")
    public void mostrarEmeHa(){
        emeHabilidadService.verEmeHabilidad();
    }

    @DeleteMapping("/borrarEmeHabilidad/{id}")
    public void borrarEmeHa(@PathVariable Long id){emeHabilidadService.borrarEmeHabilidad(id);}


}
