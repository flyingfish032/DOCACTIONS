package com.example.demo.services;

import com.example.demo.model.Match;
import com.example.demo.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Optional<Match> getMatchById(Long id) {
        return matchRepository.findById(id);
    }

    public Match createMatch(Match match) {
        return matchRepository.save(match);
    }

    public Match updateMatch(Long id, Match matchDetails) {
        Match match = matchRepository.findById(id).orElseThrow();
        match.setTitle(matchDetails.getTitle());
        match.setMatchDate(matchDetails.getMatchDate());
        match.setSeries(matchDetails.getSeries());
        match.setTeamA(matchDetails.getTeamA());
        match.setTeamB(matchDetails.getTeamB());
        match.setVenue(matchDetails.getVenue());
        match.setStatus(matchDetails.getStatus());
        match.setResult(matchDetails.getResult());
        return matchRepository.save(match);
    }

    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }
}
