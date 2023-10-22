package com.Grupo6.Lab1.Controllers;

import com.Grupo6.Lab1.models.Habilidad;
import com.Grupo6.Lab1.models.VoluntarioHabilidad;
import com.Grupo6.Lab1.services.VoluntarioHabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static com.Grupo6.Lab1.Security.JwtUtil.validarToken;

@RestController
@RequestMapping("/voluntarioHabilidad")
@CrossOrigin(origins = "*")
public class VoluntarioHabilidadController {

    private final VoluntarioHabilidadService voluntarioHabilidadService;

    @Autowired
    public VoluntarioHabilidadController(VoluntarioHabilidadService voluntarioHabilidadService) {
        this.voluntarioHabilidadService = voluntarioHabilidadService;
    }

    @PostMapping("/crearVoluntarioHabilidad")
    public VoluntarioHabilidad crearVoluntarioHabilidad(@RequestBody VoluntarioHabilidad voluntarioHabilidad) {
        System.out.println(voluntarioHabilidad.getIdHabilidad());
        System.out.println(voluntarioHabilidad.getIdVoluntario());
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

    //obtiene las habilidades que ya tiene el voluntario
    @GetMapping("/getHabilidadesVoluntario/{id}")
    public List<Habilidad> getHabilidades(@RequestHeader("Authorization") String token, @PathVariable Long id) {
        if(token == null || validarToken(token)){
            return null;
        }
        System.out.println("el id:"+    id);
        return voluntarioHabilidadService.getHabilidadesVoluntario(id);
    }

    @GetMapping("/getAllHabilidadesVoluntario/{id}")
    public List<Habilidad> getHabilidadesVol(@PathVariable Long id) {
        System.out.println("el id:"+    id);
        return voluntarioHabilidadService.getHabilidadesVoluntario(id);
    }

    @PostMapping("/actualizarHabilidadesVoluntario/{id}")
    public ResponseEntity<String> actualizar(@RequestHeader("Authorization") String token, @PathVariable Long id,@RequestBody List<List<Habilidad>> data) {
        System.out.println(token);
        if(token == null || validarToken(token)){
            System.out.println("token invalido");
            return ResponseEntity.badRequest().build();
        }
        List<Habilidad> listaOriginal = data.get(0);
        List<Habilidad> listaNueva = data.get(1);

        System.out.println("actualizar");
        voluntarioHabilidadService.actualizar2(id, listaOriginal, listaNueva);

        return ResponseEntity.ok("Actualización exitosa");
    }


}
