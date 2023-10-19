package com.Grupo6.Lab1.respositories;

import com.Grupo6.Lab1.models.EmeHabilidad;
import java.util.List;

public interface EmeHabilidadRepository {

    public EmeHabilidad crear(EmeHabilidad emeHabilidad);

    public List<EmeHabilidad> getAll();

    public String update(EmeHabilidad emeHabilidad, Long idEmeHabilidad);

    public void delete(Long idEmeHabilidad);
}
