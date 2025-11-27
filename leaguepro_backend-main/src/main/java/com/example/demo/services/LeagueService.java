package com.example.demo.services;

import com.example.demo.model.League;
import com.example.demo.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeagueService {

    @Autowired
    private LeagueRepository leagueRepository;

    public List<League> getAllLeagues() {
        return leagueRepository.findAll();
    }

    public Optional<League> getLeagueById(Long id) {
        return leagueRepository.findById(id);
    }

    public League createLeague(League league) {
        return leagueRepository.save(league);
    }

    public League updateLeague(Long id, League leagueDetails) {
        League league = leagueRepository.findById(id).orElseThrow();
        league.setName(leagueDetails.getName());
        league.setLocation(leagueDetails.getLocation());
        league.setStartDate(leagueDetails.getStartDate());
        league.setEndDate(leagueDetails.getEndDate());
        return leagueRepository.save(league);
    }

    public void deleteLeague(Long id) {
        leagueRepository.deleteById(id);
    }
}
