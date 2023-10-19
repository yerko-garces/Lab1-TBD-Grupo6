package com.Grupo6.Lab1.respositories;

import com.Grupo6.Lab1.models.TareaHabilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TareaHabilidadRepositoryImp implements TareaHabilidadRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public TareaHabilidad create(TareaHabilidad tareaHabilidad) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO public.TareaHabilidad(idTarea, idHabilidad) " +
                    "VALUES (:idTarea, :idHabilidad)";
            conn.createQuery(sql, true)
                    .addParameter("idTarea", tareaHabilidad.getIdTarea())
                    .addParameter("idHabilidad", tareaHabilidad.getIdHabilidad())
                    .executeUpdate();
            return tareaHabilidad;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<TareaHabilidad> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM TareaHabilidad ORDER BY idTareaHabilidad ASC")
                    .executeAndFetch(TareaHabilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(TareaHabilidad tareaHabilidad, Long idTareaHabilidad) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "UPDATE TareaHabilidad SET idTarea=:idTarea, idHabilidad=:idHabilidad WHERE idTareaHabilidad=:idTareaHabilidad";
            conn.createQuery(updateSql)
                    .addParameter("idTareaHabilidad", idTareaHabilidad)
                    .addParameter("idTarea", tareaHabilidad.getIdTarea())
                    .addParameter("idHabilidad", tareaHabilidad.getIdHabilidad())
                    .executeUpdate();
            return "TareaHabilidad actualizada";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "La actualización falló";
        }
    }

    @Override
    public void delete(Long idTareaHabilidad) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM TareaHabilidad WHERE idTareaHabilidad = :idTareaHabilidad")
                    .addParameter("idTareaHabilidad", idTareaHabilidad)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
