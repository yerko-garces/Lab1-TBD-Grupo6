package com.Grupo6.Lab1.respositories;

import com.Grupo6.Lab1.models.VoluntarioHabilidad;
import java.util.List;

public interface VoluntarioHabilidadRepository {
    VoluntarioHabilidad create(VoluntarioHabilidad voluntarioHabilidad);

    List<VoluntarioHabilidad> getAll();

    String update(VoluntarioHabilidad voluntarioHabilidad, Long idVoluntarioHabilidad);

    void delete(Long idVoluntarioHabilidad);

    void delete(Long idVoluntario, Long idHabilidad);

    List<VoluntarioHabilidad> getHabilidades(Long id);
}
