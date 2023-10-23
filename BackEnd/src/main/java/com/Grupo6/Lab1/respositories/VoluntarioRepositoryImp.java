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
            return conn.createQuery("SELECT * FROM voluntario WHERE emailvoluntario = :emailvoluntario")
                    .addParameter("emailvoluntario", email)
                    .executeAndFetchFirst(Voluntario.class);
        }
    }

    @Override
    public Voluntario registrar(Voluntario voluntario) {
        String contra = BCrypt.hashpw(voluntario.getContraseniaVoluntario(), BCrypt.gensalt());

        try(Connection conn = sql2o.open()){
            conn.createQuery("INSERT INTO voluntario (emailVoluntario, rutVoluntario, nombreCompletoVoluntario, contraseniaVoluntario) VALUES (:email, :rut, :nombre_completo, :password)")
                    .addParameter("rut", voluntario.getRutVoluntario())
                    .addParameter("nombre_completo", voluntario.getNombreCompletoVoluntario())
                    .addParameter("email", voluntario.getEmailVoluntario())
                    .addParameter("password", contra)
                    .executeUpdate();
            voluntario.setContraseniaVoluntario(contra);
            return voluntario;
        }
    }

    @Override
    public void actualizar(Long id, Voluntario voluntario) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("UPDATE voluntario SET emailVoluntario = :email, rutVoluntario = :rut, nombreCompletoVoluntario = :nombre_completo, contraseniaVoluntario = :password WHERE idVoluntario = :id")
                    .addParameter("rut", voluntario.getRutVoluntario())
                    .addParameter("nombre_completo", voluntario.getNombreCompletoVoluntario())
                    .addParameter("email", voluntario.getEmailVoluntario())
                    .addParameter("password", voluntario.getContraseniaVoluntario())
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }
}
