package com.example.demo.repository;

import com.example.demo.model.LiveScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LiveScoreRepository extends JpaRepository<LiveScore, Long> {
    LiveScore findByMatchId(Long matchId);
}
