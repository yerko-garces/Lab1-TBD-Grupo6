package com.Grupo6.Lab1.respositories;

import com.Grupo6.Lab1.models.Emergencia;
import com.Grupo6.Lab1.models.EstadoTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EstadoTareaRepositoryImp implements  EstadoTareaRepository{

    @Autowired
    private Sql2o sql2o;

    public EstadoTarea crear(EstadoTarea estadoTarea) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO EstadoTarea(idEstadoTarea, estadoTarea) VALUES (:idEstadoTarea, :estadoTarea)";
            conn.createQuery(sql, true)
                    .addParameter("idEstadoTarea", estadoTarea.getIdEstadoTarea())
                    .addParameter("estadoTarea", estadoTarea.getEstadoTarea())
                    .executeUpdate();
            return estadoTarea;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<EstadoTarea> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM EstadoTarea ORDER BY idEstadoTarea ASC")
                    .executeAndFetch(EstadoTarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String update(EstadoTarea estadoTarea, Long idEstadoTarea) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "UPDATE EstadoTarea SET estadoTarea = :estadoTarea WHERE idEstadoTarea = :idEstadoTarea";
            conn.createQuery(updateSql)
                    .addParameter("idEstadoTarea", idEstadoTarea)
                    .addParameter("estadoTarea", estadoTarea.getEstadoTarea())
                    .executeUpdate();
            return "Se actualizó EstadoTarea";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo";
        }
    }

    public void delete(Long idEstadoTarea) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM EstadoTarea WHERE idEstadoTarea = :idEstadoTarea")
                    .addParameter("idEstadoTarea", idEstadoTarea)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
