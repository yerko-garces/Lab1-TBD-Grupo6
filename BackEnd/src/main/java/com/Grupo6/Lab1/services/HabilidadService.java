package com.Grupo6.Lab1.services;

import com.Grupo6.Lab1.models.Habilidad;
import com.Grupo6.Lab1.respositories.HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabilidadService {

    @Autowired
    public HabilidadRepository habilidadRepository;

    public Habilidad crearHabilidad(Habilidad habilidad){return habilidadRepository.crear(habilidad);}

    public String actualizarHabilidad(Habilidad habilidad, Long id){return habilidadRepository.update(habilidad, id);}

    public List<Habilidad> verHabilidad(){return habilidadRepository.getAll();}

    public void borrarHabilidad(Long idEstadoTarea){habilidadRepository.delete(idEstadoTarea);}

    public List<Habilidad> obtenerHabilidades(Long idVoluntario) {
        return habilidadRepository.obtenerHabilidadesdelVoluntario(idVoluntario);
    }


    public Habilidad getHabilidad(Long idHabilidad) {
        return habilidadRepository.getHabilidad(idHabilidad);
    }
}
