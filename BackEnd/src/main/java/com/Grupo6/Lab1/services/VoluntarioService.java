package com.Grupo6.Lab1.services;

import com.Grupo6.Lab1.models.Voluntario;
import com.Grupo6.Lab1.respositories.VoluntarioRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoluntarioService {

    @Autowired
    private VoluntarioRepository voluntarioRepository;
    public List<Voluntario> getVoluntario(){
        return voluntarioRepository.getVoluntarios();
    }

    public boolean login(Voluntario voluntario){
        System.out.println("busca voluntario");
        Voluntario v = voluntarioRepository.getVoluntarioByEmail(voluntario.getEmailVoluntario());
        System.out.println("se econtro voluntario");
        System.out.println(v);
        if(v == null){
            System.out.println("v null");
            return false;
        }
        return BCrypt.checkpw(voluntario.getContraseniaVoluntario(), v.getContraseniaVoluntario());
    }

    public Voluntario getVoluntario(String email){
        return voluntarioRepository.getVoluntarioByEmail(email);
    }

    public int registrar(Voluntario voluntario) {
        if(voluntarioRepository.getVoluntarioByEmail(voluntario.getEmailVoluntario()) != null){
            return 0;
        }
        voluntarioRepository.registrar(voluntario);
        return 1;
    }
}
