package com.Grupo6.Lab1.respositories;
import com.Grupo6.Lab1.models.Emergencia;

import java.util.List;

public interface EmergenciaRepository {
    public Emergencia crear(Emergencia emergencia);

    public List<Emergencia> getAll();

    public String update(Emergencia emergencia, Long idEmergencia);

    public void delete(Long idEmergencia);

    public  List<String> obtenerPrerequisitos(Long idEmergencia);

    public List<Emergencia> verEmergenciasDisponibles (Long idVoluntario);
}
