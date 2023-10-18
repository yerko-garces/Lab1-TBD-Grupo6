package com.Grupo6.Lab1.respositories;


import com.Grupo6.Lab1.models.EntidadEj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EntidadEjRepositoryImp implements EntidadEjRepository{

    @Autowired
    private Sql2o sql2o;

//hay que implementar cada uno de los metodos
    @Override
    public EntidadEj crear(EntidadEj entidad) {
        return null;
    }

    @Override
    public String update(EntidadEj entidad, String id) {
        return null;
    }

    @Override
    public List<EntidadEj> getAll() {
        return null;
    }

    @Override
    public List<EntidadEj> show(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
