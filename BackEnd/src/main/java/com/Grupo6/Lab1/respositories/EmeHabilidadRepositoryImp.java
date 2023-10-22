package com.Grupo6.Lab1.respositories;

import com.Grupo6.Lab1.models.EmeHabilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmeHabilidadRepositoryImp implements EmeHabilidadRepository {

    @Autowired
    private Sql2o sql2o;
    @Override
    public EmeHabilidad crear(EmeHabilidad emeHabilidad) {
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO public.EmeHabilidad(idEmergencia, idHabilidad)" +
                    "VALUES (:idEmergencia, :idHabilidad)";
            conn.createQuery(sql, true)
                    .addParameter("idEmergencia", emeHabilidad.getIdEmergencia())
                    .addParameter("idHabilidad", emeHabilidad.getIdHabilidad())
                    .executeUpdate();
            return emeHabilidad;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<EmeHabilidad> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM EmeHabilidad ORDER BY idEmeHabilidad ASC")
                    .executeAndFetch(EmeHabilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(EmeHabilidad emeHabilidad, Long idEmeHabilidad) {
        try(Connection conn = sql2o.open()){
            String updateSql = "UPDATE EmeHabilidad SET idEmergencia=:idEmergencia, idHabilidad=:idHabilidad WHERE idEmeHabilidad=:idEmeHabilidad";
            conn.createQuery(updateSql)
                    .addParameter("idEmehabilidad", idEmeHabilidad)
                    .addParameter("idEmergencia", emeHabilidad.getIdEmergencia())
                    .addParameter("idHabilidad", emeHabilidad.getIdHabilidad())
                    .executeUpdate();
            return "Se actualizó EmeHabilidad";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo";
        }
    }


    @Override
    public void delete(Long idEmeHabilidad) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM EmeHabilidad WHERE idEmeHabilidad =:idEmeHabilidad")
                    .addParameter("idEmeHabilidad",idEmeHabilidad)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
