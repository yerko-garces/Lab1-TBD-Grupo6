package com.Grupo6.Lab1.respositories;

import com.Grupo6.Lab1.models.Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class HabilidadRepositoryImp implements  HabilidadRepository{

    @Autowired
    private Sql2o sql2o;


    public Habilidad crear(Habilidad habilidad) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Habilidad(nombreHabilidad) VALUES (:nombreHabilidad)";
            conn.createQuery(sql, true)
                    .addParameter("nombreHabilidad", habilidad.getNombreHabilidad())
                    .executeUpdate();
            return habilidad;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Habilidad> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Habilidad ORDER BY idHabilidad ASC")
                    .executeAndFetch(Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String update(Habilidad habilidad, Long idHabilidad) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "UPDATE Habilidad SET nombreHabilidad = :nombreHabilidad WHERE idHabilidad = :idHabilidad";
            conn.createQuery(updateSql)
                    .addParameter("nombreHabilidad", habilidad.getNombreHabilidad())
                    .executeUpdate();
            return "Se actualizó la Habilidad";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo";
        }
    }

    public void delete(Long idHabilidad) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM Habilidad WHERE idHabilidad = :idHabilidad")
                    .addParameter("idHabilidad", idHabilidad)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Habilidad> obtenerHabilidadesdelVoluntario(Long idVoluntario) {
        try(Connection conn = sql2o.open()){
            String sql="SELECT Em.idEmergencia, Em.nombreEmergencia, Ta.idTarea, Ta.nombreTarea, Ha.nombreHabilidad AS habilidades" +
                    "FROM Voluntario AS V" +
                    "JOIN VoluntarioHabilidad AS VH ON V.idVoluntario = VH.idVoluntario" +
                    "JOIN Habilidad Ha ON VH.idHabilidad = Ha.idHabilidad" +
                    "JOIN EmeHabilidad Eh ON Ha.idHabilidad = Eh.idHabilidad" +
                    "JOIN Emergencia Em ON Eh.idEmergencia = Em.idEmergencia" +
                    "JOIN Tarea Ta ON Em.idEmergencia = Ta.idEmergencia" +
                    "WHERE V.idVoluntario = :idVoluntario";
            return conn.createQuery(sql)
                    .addParameter("idVoluntario", idVoluntario)
                    .executeAndFetch(Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Habilidad getHabilidad(Long idHabilidad) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Habilidad WHERE idHabilidad = :idHabilidad")
                    .addParameter("idHabilidad", idHabilidad)
                    .executeAndFetchFirst(Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
