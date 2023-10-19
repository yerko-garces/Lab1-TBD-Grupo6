package com.Grupo6.Lab1.respositories;


import com.Grupo6.Lab1.models.Ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;


@Repository
public class RankingRepositoryImp implements RankingRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public Ranking create(Ranking ranking) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO public.Ranking(nombreRanking, idVoluntario, idTarea) " +
                    "VALUES (:nombreRanking, :idVoluntario, :idTarea)";
            conn.createQuery(sql, true)
                    .addParameter("nombreRanking", ranking.getNombreRanking())
                    .addParameter("idVoluntario", ranking.getIdVoluntario())
                    .addParameter("idTarea", ranking.getIdTarea())
                    .executeUpdate();
            return ranking;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Ranking> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM Ranking ORDER BY idRanking ASC")
                    .executeAndFetch(Ranking.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String update(Ranking ranking, Long idRanking) {
        try (Connection conn = sql2o.open()) {
            String updateSql = "UPDATE Ranking SET nombreRanking=:nombreRanking, idVoluntario=:idVoluntario, idTarea=:idTarea WHERE idRanking=:idRanking";
            conn.createQuery(updateSql)
                    .addParameter("idRanking", idRanking)
                    .addParameter("nombreRanking", ranking.getNombreRanking())
                    .addParameter("idVoluntario", ranking.getIdVoluntario())
                    .addParameter("idTarea", ranking.getIdTarea())
                    .executeUpdate();
            return "Ranking updated";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Update failed";
        }
    }

    @Override
    public void delete(Long idRanking) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM Ranking WHERE idRanking = :idRanking")
                    .addParameter("idRanking", idRanking)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
