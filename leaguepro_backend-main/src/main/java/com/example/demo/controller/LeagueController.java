package com.example.demo.controller;


import com.example.demo.model.League;
import com.example.demo.services.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/leagues")
@CrossOrigin(origins = "*")
public class LeagueController {

    @Autowired
    private LeagueService leagueService;

    @GetMapping
    public List<League> getAllLeagues() {
        return leagueService.getAllLeagues();
    }

    @GetMapping("/{id}")
    public Optional<League> getLeagueById(@PathVariable Long id) {
        return leagueService.getLeagueById(id);
    }

    @PostMapping
    public League createLeague(@RequestBody League league) {
        return leagueService.createLeague(league);
    }

    @PutMapping("/{id}")
    public League updateLeague(@PathVariable Long id, @RequestBody League league) {
        return leagueService.updateLeague(id, league);
    }

    @DeleteMapping("/{id}")
    public void deleteLeague(@PathVariable Long id) {
        leagueService.deleteLeague(id);
    }
}
