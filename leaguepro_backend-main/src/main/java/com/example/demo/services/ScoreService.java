package com.example.demo.services;

import com.example.demo.model.Score;
import com.example.demo.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    public Optional<Score> getScoreById(Long id) {
        return scoreRepository.findById(id);
    }

    public Score createScore(Score score) {
        return scoreRepository.save(score);
    }

    public Score updateScore(Long id, Score scoreDetails) {
        Score score = scoreRepository.findById(id).orElseThrow();
        score.setTeamAScore(scoreDetails.getTeamAScore());
        score.setTeamBScore(scoreDetails.getTeamBScore());
        score.setMatch(scoreDetails.getMatch());
        return scoreRepository.save(score);
    }

    public void deleteScore(Long id) {
        scoreRepository.deleteById(id);
    }
}
