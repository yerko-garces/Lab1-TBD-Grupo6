package com.Grupo6.Lab1.services;

import com.Grupo6.Lab1.models.Tarea;
import com.Grupo6.Lab1.respositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {
    @Autowired
    private TareaRepository tareaRepository;

    public Tarea createTarea(Tarea tarea) {
        return tareaRepository.create(tarea);
    }

    public String updateTarea(Tarea tarea, Long idTarea) {
        return tareaRepository.update(tarea, idTarea);
    }

    public List<Tarea> getAllTareas() {
        return tareaRepository.getAll();
    }

    public void deleteTarea(Long idTarea) {
        tareaRepository.delete(idTarea);
    }
}
