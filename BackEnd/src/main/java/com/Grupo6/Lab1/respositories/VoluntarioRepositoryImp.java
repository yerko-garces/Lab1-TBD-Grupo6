package com.Grupo6.Lab1.respositories;

import com.Grupo6.Lab1.models.Voluntario;
import org.mindrot.jbcrypt.BCrypt;
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
        String contra = BCrypt.hashpw(voluntario.getContraseniaVoluntario(), BCrypt.gensalt());

        try(Connection conn = sql2o.open()){
            conn.createQuery("INSERT INTO voluntario (email, rut, nombre_completo, rol_id, password) VALUES (:email, :rut, :nombre_completo, :rol_id, :password)")
                    .addParameter("rut", voluntario.getRutVoluntario())
                    .addParameter("nombre_completo", voluntario.getNombreCompletoVoluntario())
                    .addParameter("email", voluntario.getEmailVoluntario())
                    .addParameter("password", contra)
                    .addParameter("rol_id",1)
                    .executeUpdate();
        }
    }
}