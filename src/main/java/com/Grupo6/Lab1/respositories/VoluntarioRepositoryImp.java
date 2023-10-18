package com.Grupo6.Lab1.respositories;

import com.Grupo6.Lab1.models.Voluntario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
@Repository
public class VoluntarioRepositoryImp implements VoluntarioRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Voluntario> getVoluntarios() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM voluntario")
                    .executeAndFetch(Voluntario.class);
        }
    }

    @Override
    public Voluntario getVoluntarioByEmail(String email) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM voluntario WHERE email = :email")
                    .addParameter("email", email)
                    .executeAndFetchFirst(Voluntario.class);
        }
    }

    @Override
    public void registrar(Voluntario voluntario) {
        String contra = voluntario.getPassword();

        try(Connection conn = sql2o.open()){
            conn.createQuery("INSERT INTO voluntario (rut, nombre, apellido, email, password) VALUES (:rut, :nombre, :apellido, :email, :password)")
                    .addParameter("rut", voluntario.getRut())
                    .addParameter("nombre", voluntario.getNombre_completo())
                    .addParameter("email", voluntario.getEmail())
                    .addParameter("password", voluntario.getPassword())
                    .executeUpdate();
        }
    }
}
