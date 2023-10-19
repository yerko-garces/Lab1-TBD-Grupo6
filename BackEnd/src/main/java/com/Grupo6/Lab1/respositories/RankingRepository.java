package com.Grupo6.Lab1.respositories;

import com.Grupo6.Lab1.models.Ranking;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface RankingRepository {

    public Ranking create(Ranking ranking);

    public List<Ranking> getAll();

    public String update(Ranking ranking, Long idRanking);

    public void delete(Long idRanking);
}
