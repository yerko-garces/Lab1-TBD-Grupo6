package com.Grupo6.Lab1.respositories;

import com.Grupo6.Lab1.models.Emergencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmergenciaRepositoryImp implements EmergenciaRepository {

    @Autowired
    private Sql2o sql2o;

    public Emergencia crear(Emergencia emergencia) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO public.Emergencia(nombreEmergencia, idInstitucion) " +
                    "VALUES (:nombreEmergencia, :idInstitucion)";
            conn.createQuery(sql, true)
                    .addParameter("nombreEmergencia", emergencia.getNombreEmergencia())
                    .addParameter("idInstitucion", emergencia.getIdInstitucion())
                    .executeUpdate();
            return emergencia;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Emergencia> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Emergencia ORDER BY idEmergencia ASC")
                    .executeAndFetch(Emergencia.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String update(Emergencia emergencia, Long idEmergencia) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "UPDATE Emergencia SET nombreEmergencia=:nombreEmergencia, idInstitucion=:idInstitucion WHERE idEmergencia=:idEmergencia";
            conn.createQuery(updateSql)
                    .addParameter("idEmergencia", idEmergencia)
                    .addParameter("nombreEmergencia", emergencia.getNombreEmergencia())
                    .addParameter("idInstitucion", emergencia.getIdInstitucion())
                    .executeUpdate();
            return "Se actualizó Emergencia";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo";
        }
    }

    public void delete(Long idEmergencia) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM Emergencia WHERE idEmergencia = :idEmergencia")
                    .addParameter("idEmergencia", idEmergencia)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
