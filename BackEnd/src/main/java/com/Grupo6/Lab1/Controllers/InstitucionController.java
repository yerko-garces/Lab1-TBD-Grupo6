package com.Grupo6.Lab1.Controllers;

import com.Grupo6.Lab1.models.Institucion;
import com.Grupo6.Lab1.services.InstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class InstitucionController {
    @Autowired
    private InstitucionService institucionService;

    @PostMapping("/crearInstitucion")
    public Institucion crearInstitucion(@RequestBody Institucion institucion) {
        return institucionService.createInstitucion(institucion);
    }

    @PutMapping("/actualizarInstitucion/{id}")
    public String actualizarInstitucion(@RequestBody Institucion institucion, @PathVariable Long id) {
        return institucionService.updateInstitucion(institucion, id);
    }

    @GetMapping("/verInstituciones")
    public List<Institucion> mostrarInstituciones() {
        return institucionService.getAllInstituciones();
    }

    @DeleteMapping("/borrarInstitucion/{id}")
    public void borrarInstitucion(@PathVariable Long id) {
        institucionService.deleteInstitucion(id);
    }
}
