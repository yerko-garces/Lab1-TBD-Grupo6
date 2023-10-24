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

import static com.Grupo6.Lab1.Security.JwtUtil.validarToken;

@RestController
@RequestMapping("/voluntario")
@CrossOrigin(origins = "http://localhost:5173")
public class voluntarioController {

    @Autowired
    private VoluntarioService voluntarioService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Voluntario voluntario){
        System.out.println(voluntario);
        if (voluntario.getEmailVoluntario() == null){
            return ResponseEntity.badRequest().build();
        }
        if(voluntarioService.login(voluntario)){
            Map<String, Object> response = new HashMap<>();
            if(validarToken(JwtUtil.generateToken(voluntario.getEmailVoluntario()))){
                System.out.println("token valido");}
            response.put("token", JwtUtil.generateToken(voluntario.getEmailVoluntario()));
            response.put("voluntario", voluntarioService.getVoluntario(voluntario.getEmailVoluntario()));
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> registrar(@RequestBody Voluntario voluntario){
        System.out.println(voluntario);
        if (voluntario.getEmailVoluntario() == null || voluntario.getEmailVoluntario().isEmpty() || voluntario.getRutVoluntario() == null || voluntario.getRutVoluntario().isEmpty()){
            System.out.println("email null");
            return ResponseEntity.badRequest().build();
        }
        voluntarioService.registrar(voluntario);
        Map<String, Object> response = new HashMap<>();
        response.put("token", JwtUtil.generateToken(voluntario.getEmailVoluntario()));
        response.put("voluntario", voluntarioService.getVoluntario(voluntario.getEmailVoluntario()));
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("voluntarios")
    public List<Voluntario> voluntarios(){
        return voluntarioService.getVoluntarios();
    }

    @PutMapping("/actualizarUser/{idVoluntario}")
    public ResponseEntity<String> actualizar (@PathVariable Long idVoluntario, @RequestBody Voluntario voluntario){
        System.out.println("entro en actualizar");
        System.out.println(voluntario);
        if (voluntario.getEmailVoluntario() == null || voluntario.getEmailVoluntario().isEmpty() || voluntario.getRutVoluntario() == null || voluntario.getRutVoluntario().isEmpty()){
            System.out.println("email null");
            return ResponseEntity.badRequest().build();
        }
        voluntarioService.actualizar(idVoluntario,voluntario);
        return ResponseEntity.ok().build();
    }
}