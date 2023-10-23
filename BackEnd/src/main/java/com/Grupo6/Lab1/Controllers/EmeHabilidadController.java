package com.Grupo6.Lab1.Controllers;

import com.Grupo6.Lab1.models.EmeHabilidad;
import com.Grupo6.Lab1.services.EmeHabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class EmeHabilidadController {

    @Autowired
    private EmeHabilidadService emeHabilidadService;

    @PostMapping("/crearEmeHabilidad")
    public EmeHabilidad crearEmeHa(@RequestBody EmeHabilidad emeHabilidad){
        return emeHabilidadService.crearEmeHabilidad(emeHabilidad);
    }

    @PutMapping("/actualizarEmeHabilidad/{id}")
    public String actualizarEmeHa(@RequestBody EmeHabilidad emeHabilidad, @PathVariable Long id){
        return emeHabilidadService.actualizarEmeHabilidad(emeHabilidad, id);
    }

    @GetMapping("/verEmeHabilidad")
    public List<EmeHabilidad> mostrarEmeHa(){
        return emeHabilidadService.verEmeHabilidad();
    }

    @DeleteMapping("/borrarEmeHabilidad/{id}")
    public void borrarEmeHa(@PathVariable Long id){emeHabilidadService.borrarEmeHabilidad(id);}


}
