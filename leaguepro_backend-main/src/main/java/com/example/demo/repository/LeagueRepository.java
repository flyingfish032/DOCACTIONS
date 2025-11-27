package com.example.demo.repository;

import com.example.demo.model.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueRepository extends JpaRepository<League, Long> {
    // Add custom queries here if needed
}
