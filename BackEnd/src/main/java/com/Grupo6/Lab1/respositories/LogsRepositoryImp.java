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
}
