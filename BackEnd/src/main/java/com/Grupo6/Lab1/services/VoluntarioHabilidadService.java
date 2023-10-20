package com.Grupo6.Lab1.services;

import com.Grupo6.Lab1.models.VoluntarioHabilidad;
import com.Grupo6.Lab1.respositories.VoluntarioHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoluntarioHabilidadService {
    @Autowired
    private VoluntarioHabilidadRepository voluntarioHabilidadRepository;

    public VoluntarioHabilidad createVoluntarioHabilidad(VoluntarioHabilidad voluntarioHabilidad) {
        return voluntarioHabilidadRepository.create(voluntarioHabilidad);
    }

    public String updateVoluntarioHabilidad(VoluntarioHabilidad voluntarioHabilidad, Long idVoluntarioHabilidad) {
        return voluntarioHabilidadRepository.update(voluntarioHabilidad, idVoluntarioHabilidad);
    }

    public List<VoluntarioHabilidad> getAllVoluntarioHabilidades() {
        return voluntarioHabilidadRepository.getAll();
    }

    public void deleteVoluntarioHabilidad(Long idVoluntarioHabilidad) {
        voluntarioHabilidadRepository.delete(idVoluntarioHabilidad);
    }

    public List<VoluntarioHabilidad> getHabilidades(Long id) {
        return voluntarioHabilidadRepository.getHabilidades(id);
    }
}
