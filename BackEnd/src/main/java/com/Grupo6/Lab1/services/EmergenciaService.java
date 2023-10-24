package com.Grupo6.Lab1.services;

import com.Grupo6.Lab1.models.EmeHabilidad;

import com.Grupo6.Lab1.models.Emergencia;
import com.Grupo6.Lab1.respositories.EmergenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmergenciaService {

    @Autowired
    private EmergenciaRepository emergenciaRepository;

    public Emergencia crearEmergencia(Emergencia emergencia){return emergenciaRepository.crear(emergencia);}

    public String actualizarEmergencia(Emergencia emergencia, Long idEmeHabilidad){return emergenciaRepository.update(emergencia, idEmeHabilidad);}

    public List<Emergencia> verEmergencia(){return emergenciaRepository.getAll();}

    public void borrarEmergencia(Long idEmeHabilidad){
        emergenciaRepository.delete(idEmeHabilidad);}

    public List<String> obtenerPrerequisitos(Long id){
        List<String> prerequisitos = emergenciaRepository.obtenerPrerequisitos(id);
        return prerequisitos;
    }

    public List<Emergencia> verEmergenciasDisponibles(Long id){
        System.out.println("id: "+id);
        List<Emergencia> emergencias = emergenciaRepository.verEmergenciasDisponibles(id);

        System.out.println(emergencias.get(0).getNombreEmergencia());
        return emergencias;
    }


}
