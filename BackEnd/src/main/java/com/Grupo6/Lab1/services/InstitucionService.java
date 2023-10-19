package com.Grupo6.Lab1.services;

import com.Grupo6.Lab1.models.Institucion;
import com.Grupo6.Lab1.respositories.InstitucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitucionService {
    @Autowired
    private InstitucionRepository institucionRepository;

    public Institucion createInstitucion(Institucion institucion) {
        return institucionRepository.crear(institucion);
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