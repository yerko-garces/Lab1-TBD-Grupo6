package com.Grupo6.Lab1.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.Grupo6.Lab1.models.Ranking;
import com.Grupo6.Lab1.services.RankingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class RankingController {

    @Autowired
    private RankingService rankingService;

    @PostMapping("/crearRanking")
    public Ranking crearRanking(@RequestBody Ranking ranking) {
        return rankingService.createRanking(ranking);
    }

    @PutMapping("/actualizarRanking/{id}")
    public String actualizarRanking(@RequestBody Ranking ranking, @PathVariable Long id) {
        return rankingService.updateRanking(ranking, id);
    }

    @GetMapping("/verRanking")
    public List<Ranking> mostrarRankings() {
        return rankingService.getAllRankings();
    }

    @DeleteMapping("/borrarRanking/{id}")
    public void borrarRanking(@PathVariable Long id) {
        rankingService.deleteRanking(id);
    }
}
