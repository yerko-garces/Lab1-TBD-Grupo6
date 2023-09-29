package com.Grupo6.Lab1.respositories;


import com.Grupo6.Lab1.models.EntidadEj;

import java.util.List;

public interface EntidadEjRepository {

    public EntidadEj crear(EntidadEj entidad);

    public String update(EntidadEj entidad, String id);

    public List<EntidadEj> getAll();

    public List<EntidadEj> show(String id);

    public void delete(String id);
}
