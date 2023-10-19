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
}
