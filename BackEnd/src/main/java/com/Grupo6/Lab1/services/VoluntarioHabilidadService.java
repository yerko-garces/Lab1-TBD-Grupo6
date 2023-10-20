package com.Grupo6.Lab1.services;

import com.Grupo6.Lab1.models.Habilidad;
import com.Grupo6.Lab1.models.VoluntarioHabilidad;
import com.Grupo6.Lab1.respositories.VoluntarioHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoluntarioHabilidadService {
    @Autowired
    private VoluntarioHabilidadRepository voluntarioHabilidadRepository;
    @Autowired
    private HabilidadService habilidadService;


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

    public List<Habilidad> getHabilidadesVoluntario(Long id) {
        ArrayList<VoluntarioHabilidad> lista = (ArrayList<VoluntarioHabilidad>) voluntarioHabilidadRepository.getHabilidades(id);
        ArrayList<Habilidad> listaHabilidades = new ArrayList<Habilidad>();
        for (VoluntarioHabilidad voluntarioHabilidad : lista) {
            listaHabilidades.add(habilidadService.getHabilidad(voluntarioHabilidad.getIdHabilidad()));
        }
        return listaHabilidades;
    }



    public boolean actualizar2(Long usuario, List<Habilidad> listaOriginal, List<Habilidad> listaNueva) {
        System.out.println("listaNueva");
        System.out.println(listaNueva);
        System.out.println("listaOriginal");
        System.out.println(listaOriginal);
        // Eliminar habilidades que están en listaOriginal pero no en listaNueva
        for (Habilidad habilidad : listaOriginal) {
            if (!listaNueva.contains(habilidad)) {
                System.out.println("se elimina");
                voluntarioHabilidadRepository.delete(usuario, habilidad.getId_habilidad());
            }
        }

        for (Habilidad habilidad : listaNueva) {
            System.out.println("ciclo actual= "+habilidad.getId_habilidad());
            if (!listaOriginal.contains(habilidad)) {
                System.out.println("se agrego"+habilidad.getId_habilidad());
                voluntarioHabilidadRepository.create(new VoluntarioHabilidad(usuario, habilidad.getId_habilidad()));
            }
        }

        return true;
    }

}
