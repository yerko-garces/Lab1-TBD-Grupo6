package com.Grupo6.Lab1.services;

import com.Grupo6.Lab1.models.Institucion;
import com.Grupo6.Lab1.models.Voluntario;
import com.Grupo6.Lab1.respositories.InstitucionRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitucionService {
    @Autowired
    private InstitucionRepository institucionRepository;



    public boolean login(Institucion institucion){
        Institucion i = institucionRepository.getInstitucionByEmail(institucion.getCorreoInstitucion());
        System.out.println(i.getContraseniaInstitucion());
        System.out.println(institucion.getContraseniaInstitucion());
        if(i == null){
            System.out.println("v null");
            return false;
        }
        return BCrypt.checkpw(institucion.getContraseniaInstitucion(), i.getContraseniaInstitucion());
    }
    public Institucion createInstitucion(Institucion institucion) {
        return institucionRepository.crear(institucion);
    }

    public int registrarInstitucion(Institucion institucion) {
        if(institucionRepository.getInstitucionByEmail(institucion.getCorreoInstitucion()) != null){
            return 0;
        }
        institucionRepository.registrarInstitucion(institucion);
        return 1;
    }

    public Institucion getInstitucion(String email){
        return institucionRepository.getInstitucionByEmail(email);
    }
    public String updateInstitucion(Institucion institucion, Long idInstitucion) {
        return institucionRepository.update(institucion, idInstitucion);
    }

    public List<Institucion> getAllInstituciones() {
        return institucionRepository.getAll();
    }

    public void deleteInstitucion(Long idInstitucion) {
        institucionRepository.delete(idInstitucion);
    }
}