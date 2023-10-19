package com.Grupo6.Lab1.services;



import com.Grupo6.Lab1.models.EstadoTarea;
import com.Grupo6.Lab1.respositories.EstadoTareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoTareaService {

    @Autowired
    private EstadoTareaRepository estadoTarearepository;

    public EstadoTarea crearEstadoTarea(EstadoTarea estadoTarea){return estadoTarearepository.crear(estadoTarea);}

    public String actualizarEstadoTarea(EstadoTarea estadoTarea, Long id){return estadoTarearepository.update(estadoTarea, id);}

    public List<EstadoTarea> verEstadoTarea(){return estadoTarearepository.getAll();}

    public void borrarEstadotarea(Long idEstadoTarea){estadoTarearepository.delete(idEstadoTarea);}
}
