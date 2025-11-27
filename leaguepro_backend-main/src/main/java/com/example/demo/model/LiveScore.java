package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class LiveScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int scoreTeamA;
    private int scoreTeamB;
    private String currentStatus; // e.g. 45', Half Time, 3rd Set etc.

    @OneToOne
    private Match match;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getScoreTeamA() {
		return scoreTeamA;
	}

	public void setScoreTeamA(int scoreTeamA) {
		this.scoreTeamA = scoreTeamA;
	}

	public int getScoreTeamB() {
		return scoreTeamB;
	}

	public void setScoreTeamB(int scoreTeamB) {
		this.scoreTeamB = scoreTeamB;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

    // Getters and Setters
}
