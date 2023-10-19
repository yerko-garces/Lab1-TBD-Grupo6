package com.Grupo6.Lab1.respositories;

import com.Grupo6.Lab1.models.Institucion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class InstitucionRepositoryImp implements InstitucionRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public Institucion crear(Institucion institucion) {
        return null;
    }

    @Override
    public List<Institucion> getAll() {
        return null;
    }

    @Override
    public String update(Institucion institucion, Long idInstitucion) {
        return null;
    }

    @Override
    public void delete(Long idInstitucion) {

    }
}
