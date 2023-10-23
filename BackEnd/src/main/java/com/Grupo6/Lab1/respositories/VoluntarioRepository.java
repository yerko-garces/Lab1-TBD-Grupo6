package com.Grupo6.Lab1.respositories;

import com.Grupo6.Lab1.models.Voluntario;

import java.util.List;

public interface VoluntarioRepository {

    public List<Voluntario> getVoluntarios();

    Voluntario getVoluntarioByEmail(String email);

    Voluntario registrar(Voluntario voluntario);

    void actualizar(Long id, Voluntario voluntario);
}
