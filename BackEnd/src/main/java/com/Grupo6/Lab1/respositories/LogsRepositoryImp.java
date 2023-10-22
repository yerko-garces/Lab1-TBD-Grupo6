package com.Grupo6.Lab1.respositories;

import com.Grupo6.Lab1.models.Institucion;
import com.Grupo6.Lab1.models.Logs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class LogsRepositoryImp implements LogsRepository{

    @Autowired
    private Sql2o sql2o;


    @Override
    public List<Logs> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Logs ORDER BY id ASC")
                    .executeAndFetch(Logs.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Integer getReportes(Long idVoluntario){
        try(Connection conn = sql2o.open()) {
            return conn.createQuery(
                    "SELECT count(v.idvoluntario) " +
                    "FROM voluntario AS v " +
                    "INNER JOIN logs AS l " +
                    "ON l.idusuario = v.idvoluntario " +
                    "WHERE v.idvoluntario = :id_voluntario")
                    .addParameter("id_voluntario", idVoluntario)
                    .executeScalar(Integer.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
