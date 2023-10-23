package com.Grupo6.Lab1.Controllers;

import com.Grupo6.Lab1.Security.JwtUtil;
import com.Grupo6.Lab1.models.Institucion;
import com.Grupo6.Lab1.models.Voluntario;
import com.Grupo6.Lab1.services.InstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/institucion")
@CrossOrigin(origins = "http://localhost:5173")
public class InstitucionController {
    @Autowired
    private InstitucionService institucionService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Institucion institucion){
        System.out.println(institucion.getCorreoInstitucion());
        if (institucion.getCorreoInstitucion() == null){
            System.out.println("email null");
            return ResponseEntity.badRequest().build();
        }
        if(!institucionService.login(institucion)){
            System.out.println("login ok");
            Map<String, Object> response = new HashMap<>();
            response.put("token", JwtUtil.generateToken(institucion.getCorreoInstitucion()));
            response.put("institucion", institucionService.getInstitucion(institucion.getCorreoInstitucion()));
            return ResponseEntity.ok().body(response);
        }
        System.out.println("login bad");
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity<String> registrarInstitucion(@RequestBody Institucion institucion){
        System.out.println(institucion);
        if (institucion.getCorreoInstitucion() == null || institucion.getCorreoInstitucion().isEmpty()){
            System.out.println("email null");
            return ResponseEntity.badRequest().build();
        }
        institucionService.registrarInstitucion(institucion);
        return ResponseEntity.ok().build();
    }
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
