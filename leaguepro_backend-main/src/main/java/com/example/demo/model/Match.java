package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "`match_details`")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Date matchDate;

    @ManyToOne
    @JoinColumn(name = "series_id")
    private Series series;

    @ManyToOne
    @JoinColumn(name = "team_a_id")
    private Team teamA;

    @ManyToOne
    @JoinColumn(name = "team_b_id")
    private Team teamB;

    private String venue;
    private String status; // Scheduled, Live, Completed

    private String result;

    @OneToOne(mappedBy = "match", cascade = CascadeType.ALL)
    private LiveScore liveScore;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}

	public Series getSeries() {
		return series;
	}

	public void setSeries(Series series) {
		this.series = series;
	}

	public Team getTeamA() {
		return teamA;
	}

	public void setTeamA(Team teamA) {
		this.teamA = teamA;
	}

	public Team getTeamB() {
		return teamB;
	}

	public void setTeamB(Team teamB) {
		this.teamB = teamB;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public LiveScore getLiveScore() {
		return liveScore;
	}

	public void setLiveScore(LiveScore liveScore) {
		this.liveScore = liveScore;
	}

    // Getters and Setters
}
