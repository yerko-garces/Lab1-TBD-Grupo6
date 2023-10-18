package com.Grupo6.Lab1.Controllers;

import com.Grupo6.Lab1.Security.JwtUtil;
import com.Grupo6.Lab1.models.Voluntario;
import com.Grupo6.Lab1.services.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voluntario")
public class voluntarioController {

    @Autowired
    private VoluntarioService voluntarioService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Voluntario voluntario){
        if (voluntario.getEmail() == null || voluntario.getEmail().isEmpty() || voluntario.getRut() == null || voluntario.getRut().isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        if(voluntarioService.login(voluntario)){
            return ResponseEntity.ok(JwtUtil.generateToken(voluntario.getEmail()));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registrar(@RequestBody Voluntario voluntario){
        if (voluntario.getEmail() == null || voluntario.getEmail().isEmpty() || voluntario.getRut() == null || voluntario.getRut().isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        voluntarioService.registrar(voluntario);
        return ResponseEntity.ok().build();
    }

    @GetMapping("voluntarios")
    public List<Voluntario> voluntarios(){
        return voluntarioService.getVoluntario();
    }
}
