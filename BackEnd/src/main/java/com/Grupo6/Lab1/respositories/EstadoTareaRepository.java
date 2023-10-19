package com.Grupo6.Lab1.respositories;

import com.Grupo6.Lab1.models.Emergencia;
import com.Grupo6.Lab1.models.EstadoTarea;

import java.util.List;

public interface EstadoTareaRepository {

    public EstadoTarea crear(EstadoTarea estadoTarea);

    public List<EstadoTarea> getAll();

    public String update(EstadoTarea estadoTarea, Long idEstadoTarea);

    public void delete(Long idEstadoTarea);
}
