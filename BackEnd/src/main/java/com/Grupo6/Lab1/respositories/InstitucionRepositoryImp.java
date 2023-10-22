package com.Grupo6.Lab1.respositories;

import com.Grupo6.Lab1.models.Institucion;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class InstitucionRepositoryImp implements InstitucionRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public Institucion crear(Institucion institucion) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO public.Institucion(nombreInstitucion, correoInstitucion, contraseniaInstitucion) " +
                    "VALUES (:nombreInstitucion, :correoInstitucion, :contraseniaInstitucion)";
            conn.createQuery(sql, true)
                    .addParameter("nombreInstitucion", institucion.getNombreInstitucion())
                    .addParameter("correoInstitucion", institucion.getCorreoInstitucion())
                    .addParameter("contraseniaInstitucion", institucion.getContraseniaInstitucion())
                    .executeUpdate();
            return institucion;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Institucion> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Institucion ORDER BY idInstitucion ASC")
                    .executeAndFetch(Institucion.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Institucion institucion, Long idInstitucion) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "UPDATE institucion SET nombreInstitucion=:nombreInstitucion, correoInstitucion=:correoInstitucion, contraseniaInstitucion=:contraseniaInstitucion WHERE idInstitucion=:idInstitucion";
            conn.createQuery(updateSql)
                    .addParameter("idInstitucion", idInstitucion)
                    .addParameter("nombreInstitucion", institucion.getNombreInstitucion())
                    .addParameter("correoInstitucion", institucion.getCorreoInstitucion())
                    .addParameter("contraseniaInstitucion", institucion.getContraseniaInstitucion())
                    .executeUpdate();
            return "Institucion actualizada";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "La actualización falló";
        }
    }

    @Override
    public void delete(Long idInstitucion) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM institucion WHERE idInstitucion = :idInstitucion")
                    .addParameter("idInstitucion", idInstitucion)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Institucion getInstitucionByEmail(String correoInstitucion) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM institucion WHERE correoInstitucion = :correoInstitucion")
                    .addParameter("correoInstitucion", correoInstitucion)
                    .executeAndFetchFirst(Institucion.class);
        }
    }

    @Override
    public void registrarInstitucion(Institucion institucion) {
        String contra = BCrypt.hashpw(institucion.getContraseniaInstitucion(), BCrypt.gensalt());
        try(Connection conn = sql2o.open()){
            conn.createQuery("INSERT INTO institucion (correoInstitucion, nombreInstitucion, contraseniaInstitucion) VALUES (:correoInstitucion, :nombreInstitucion, :password)")
                    .addParameter("nombreInstitucion", institucion.getNombreInstitucion())
                    .addParameter("correoInstitucion", institucion.getCorreoInstitucion())
                    .addParameter("password", contra)
                    .executeUpdate();
        }
    }
}