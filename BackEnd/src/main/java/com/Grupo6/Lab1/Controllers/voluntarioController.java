package com.Grupo6.Lab1.Controllers;

import com.Grupo6.Lab1.Security.JwtUtil;
import com.Grupo6.Lab1.models.Voluntario;
import com.Grupo6.Lab1.services.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/voluntario")
@CrossOrigin(origins = "*")
public class voluntarioController {

    @Autowired
    private VoluntarioService voluntarioService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Voluntario voluntario){
        System.out.println(voluntario);
        if (voluntario.getEmailVoluntario() == null){
            System.out.println("email null");
            return ResponseEntity.badRequest().build();
        }
        if(voluntarioService.login(voluntario)){
            System.out.println("login ok");
            Map<String, Object> response = new HashMap<>();
            response.put("token", JwtUtil.generateToken(voluntario.getEmailVoluntario()));
            response.put("voluntario", voluntarioService.getVoluntario(voluntario.getEmailVoluntario()));
            return ResponseEntity.ok().body(response);
        }
        System.out.println("login bad");
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity<String> registrar(@RequestBody Voluntario voluntario){
        System.out.println(voluntario);
        if (voluntario.getEmailVoluntario() == null || voluntario.getEmailVoluntario().isEmpty() || voluntario.getRutVoluntario() == null || voluntario.getRutVoluntario().isEmpty()){
            System.out.println("email null");
            return ResponseEntity.badRequest().build();
        }
        voluntarioService.registrar(voluntario);
        return ResponseEntity.ok().build();
    }

    @GetMapping("voluntarios")
    public List<Voluntario> voluntarios(){
        return voluntarioService.getVoluntarios();
    }
}
