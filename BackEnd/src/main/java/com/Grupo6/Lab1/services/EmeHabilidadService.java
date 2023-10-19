package com.Grupo6.Lab1.services;

import com.Grupo6.Lab1.models.EmeHabilidad;
import com.Grupo6.Lab1.respositories.EmeHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmeHabilidadService {

    @Autowired
    private EmeHabilidadRepository emeHabilidadRepository;

    public EmeHabilidad crearEmeHabilidad(EmeHabilidad emeHabilidad){return emeHabilidadRepository.crear(emeHabilidad);}

    public String actualizarEmeHabilidad(EmeHabilidad emeHabilidad, Long idEmeHabilidad){return emeHabilidadRepository.update(emeHabilidad, idEmeHabilidad);}

    public List<EmeHabilidad> verEmeHabilidad(){return emeHabilidadRepository.getAll();}

    public void borrarEmeHabilidad(Long idEmeHabilidad){emeHabilidadRepository.delete(idEmeHabilidad);}

}
