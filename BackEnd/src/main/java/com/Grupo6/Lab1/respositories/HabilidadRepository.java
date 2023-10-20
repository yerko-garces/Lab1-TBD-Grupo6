package com.Grupo6.Lab1.respositories;

import com.Grupo6.Lab1.models.Habilidad;

import java.util.List;

public interface HabilidadRepository {
    public Habilidad crear(Habilidad habilidad);

    public List<Habilidad> getAll();

    public String update(Habilidad habilidad, Long idHabilidad);

    public void delete(Long idHabilidad);

    public List<Habilidad> obtenerHabilidadesdelVoluntario(Long idVoluntario);

    Habilidad getHabilidad(Long idHabilidad);
}
