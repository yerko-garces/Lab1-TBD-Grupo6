package com.Grupo6.Lab1.respositories;

import com.Grupo6.Lab1.models.Voluntario;

import java.util.List;

public interface VoluntarioRepository {

    public List<Voluntario> getVoluntarios();

    Voluntario getVoluntarioByEmail(String email);

    void registrar(Voluntario voluntario);
}
