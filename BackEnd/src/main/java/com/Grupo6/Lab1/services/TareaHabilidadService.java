package com.Grupo6.Lab1.services;

import com.Grupo6.Lab1.models.TareaHabilidad;
import com.Grupo6.Lab1.respositories.TareaHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaHabilidadService {
    @Autowired
    private TareaHabilidadRepository tareaHabilidadRepository;

    public TareaHabilidad createTareaHabilidad(TareaHabilidad tareaHabilidad) {
        return tareaHabilidadRepository.create(tareaHabilidad);
    }

    public String updateTareaHabilidad(TareaHabilidad tareaHabilidad, Long idTareaHabilidad) {
        return tareaHabilidadRepository.update(tareaHabilidad, idTareaHabilidad);
    }

    public List<TareaHabilidad> getAllTareaHabilidades() {
        return tareaHabilidadRepository.getAll();
    }

    public void deleteTareaHabilidad(Long idTareaHabilidad) {
        tareaHabilidadRepository.delete(idTareaHabilidad);
    }
}
