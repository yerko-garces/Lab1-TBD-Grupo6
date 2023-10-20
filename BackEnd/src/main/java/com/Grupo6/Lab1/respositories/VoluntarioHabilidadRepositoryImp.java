package com.Grupo6.Lab1.respositories;

import com.Grupo6.Lab1.models.VoluntarioHabilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class VoluntarioHabilidadRepositoryImp implements VoluntarioHabilidadRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public VoluntarioHabilidad create(VoluntarioHabilidad voluntarioHabilidad) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO public.VoluntarioHabilidad(idVoluntario, idHabilidad) " +
                    "VALUES (:idVoluntario, :idHabilidad)";
            conn.createQuery(sql, true)
                    .addParameter("idVoluntario", voluntarioHabilidad.getIdVoluntario())
                    .addParameter("idHabilidad", voluntarioHabilidad.getIdHabilidad())
                    .executeUpdate();
            return voluntarioHabilidad;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<VoluntarioHabilidad> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM VoluntarioHabilidad ORDER BY idVoluntarioHabilidad ASC")
                    .executeAndFetch(VoluntarioHabilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(VoluntarioHabilidad voluntarioHabilidad, Long idVoluntarioHabilidad) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "UPDATE VoluntarioHabilidad SET idVoluntario=:idVoluntario, idHabilidad=:idHabilidad WHERE idVoluntarioHabilidad=:idVoluntarioHabilidad";
            conn.createQuery(updateSql)
                    .addParameter("idVoluntarioHabilidad", idVoluntarioHabilidad)
                    .addParameter("idVoluntario", voluntarioHabilidad.getIdVoluntario())
                    .addParameter("idHabilidad", voluntarioHabilidad.getIdHabilidad())
                    .executeUpdate();
            return "VoluntarioHabilidad actualizada";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "La actualización falló";
        }
    }

    @Override
    public void delete(Long idVoluntarioHabilidad) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM VoluntarioHabilidad WHERE idVoluntarioHabilidad = :idVoluntarioHabilidad")
                    .addParameter("idVoluntarioHabilidad", idVoluntarioHabilidad)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Long idVoluntario, Long idHabilidad) {
        try{
            Connection conn = sql2o.open();
            conn.createQuery("DELETE FROM VoluntarioHabilidad WHERE idVoluntario = :idVoluntario AND idHabilidad = :idHabilidad")
                    .addParameter("idVoluntario", idVoluntario)
                    .addParameter("idHabilidad", idHabilidad)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<VoluntarioHabilidad> getHabilidades(Long id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM VoluntarioHabilidad WHERE idVoluntario = :id")
                    .addParameter("id", id)
                    .executeAndFetch(VoluntarioHabilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
