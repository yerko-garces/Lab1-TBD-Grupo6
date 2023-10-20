package com.Grupo6.Lab1.respositories;

import com.Grupo6.Lab1.models.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TareaRepositoryImp implements TareaRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public Tarea create(Tarea tarea) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO public.Tarea(nombreTarea, idEstadoTarea, idEmergencia) " +
                    "VALUES (:nombreTarea, :idEstadoTarea)";
            conn.createQuery(sql, true)
                    .addParameter("nombreTarea", tarea.getNombreTarea())
                    .addParameter("idEstadoTarea", tarea.getIdEstadoTarea())
                    .addParameter("idEmergencia", tarea.getIdEmergencia())
                    .executeUpdate();
            return tarea;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Tarea> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Tarea ORDER BY idTarea ASC")
                    .executeAndFetch(Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Tarea tarea, Long idTarea) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "UPDATE Tarea SET nombreTarea=:nombreTarea, idEstadoTarea=:idEstadoTarea, idEmergencia=:idEmergencia WHERE idTarea=:idTarea";
            conn.createQuery(updateSql)
                    .addParameter("idTarea", idTarea)
                    .addParameter("nombreTarea", tarea.getNombreTarea())
                    .addParameter("idEstadoTarea", tarea.getIdEstadoTarea())
                    .addParameter("idEmergencia", tarea.getIdEmergencia())
                    .executeUpdate();
            return "Tarea actualizada";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "La actualización falló";
        }
    }

    @Override
    public void delete(Long idTarea) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM Tarea WHERE idTarea = :idTarea")
                    .addParameter("idTarea", idTarea)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
