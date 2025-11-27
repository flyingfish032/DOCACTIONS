package com.example.demo.services;

import com.example.demo.model.Team;
import com.example.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Optional<Team> getTeamById(Long id) {
        return teamRepository.findById(id);
    }

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team updateTeam(Long id, Team teamDetails) {
        Team team = teamRepository.findById(id).orElseThrow();
        team.setName(teamDetails.getName());
        team.setSport(teamDetails.getSport());
        return teamRepository.save(team);
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}
