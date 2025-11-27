package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int teamAScore;
    private int teamBScore;

    @OneToOne
    private Match match;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTeamAScore() {
		return teamAScore;
	}

	public void setTeamAScore(int teamAScore) {
		this.teamAScore = teamAScore;
	}

	public int getTeamBScore() {
		return teamBScore;
	}

	public void setTeamBScore(int teamBScore) {
		this.teamBScore = teamBScore;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

    // Getters and Setters
    
}
