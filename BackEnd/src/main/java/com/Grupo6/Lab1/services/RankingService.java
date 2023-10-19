package com.Grupo6.Lab1.services;

import com.Grupo6.Lab1.models.Ranking;
import com.Grupo6.Lab1.respositories.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RankingService {

    @Autowired
    private RankingRepository rankingRepository;

    public Ranking createRanking(Ranking ranking) {
        return rankingRepository.create(ranking);
    }

    public String updateRanking(Ranking ranking, Long idRanking) {
        return rankingRepository.update(ranking, idRanking);
    }

    public List<Ranking> getAllRankings() {
        return rankingRepository.getAll();
    }

    public void deleteRanking(Long idRanking) {
        rankingRepository.delete(idRanking);
    }

}
