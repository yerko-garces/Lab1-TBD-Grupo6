package com.Grupo6.Lab1.respositories;

import com.Grupo6.Lab1.models.Tarea;

import java.util.List;

public interface TareaRepository {
    public Tarea create(Tarea tarea);

    public List<Tarea> getAll();

    public String update(Tarea tarea, Long idTarea);

    public void delete(Long idTarea);
}
