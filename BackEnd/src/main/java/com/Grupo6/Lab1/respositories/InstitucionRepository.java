package com.Grupo6.Lab1.respositories;


import com.Grupo6.Lab1.models.Institucion;

import java.util.List;

public interface InstitucionRepository {

    public Institucion crear(Institucion institucion);

    public List<Institucion> getAll();

    public String update(Institucion institucion, Long idInstitucion);

    public void delete(Long idInstitucion);

    Institucion getInstitucionByEmail(String correo);
    public void registrarInstitucion(Institucion institucion);
}
