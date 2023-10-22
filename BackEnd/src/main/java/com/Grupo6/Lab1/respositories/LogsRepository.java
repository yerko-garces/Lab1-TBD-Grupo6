package com.Grupo6.Lab1.respositories;

import com.Grupo6.Lab1.models.Institucion;
import com.Grupo6.Lab1.models.Logs;

import java.util.List;

public interface LogsRepository {

    public List<Logs> getAll();
    public Integer getReportes(Long idVoluntario);
}
