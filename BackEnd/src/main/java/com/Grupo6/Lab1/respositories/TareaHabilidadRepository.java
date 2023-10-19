package com.Grupo6.Lab1.respositories;

import com.Grupo6.Lab1.models.TareaHabilidad;

import java.util.List;

public interface TareaHabilidadRepository {
    public TareaHabilidad create(TareaHabilidad tareaHabilidad);

    public List<TareaHabilidad> getAll();

    public String update(TareaHabilidad tareaHabilidad, Long idTareaHabilidad);

    public void delete(Long idTareaHabilidad);
}
