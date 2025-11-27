package com.example.demo.controller;

import com.example.demo.model.Score;
import com.example.demo.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/scores")
@CrossOrigin(origins = "*")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping
    public List<Score> getAllScores() {
        return scoreService.getAllScores();
    }

    @GetMapping("/{id}")
    public Optional<Score> getScoreById(@PathVariable Long id) {
        return scoreService.getScoreById(id);
    }

    @PostMapping
    public Score createScore(@RequestBody Score score) {
        return scoreService.createScore(score);
    }

    @PutMapping("/{id}")
    public Score updateScore(@PathVariable Long id, @RequestBody Score score) {
        return scoreService.updateScore(id, score);
    }

    @DeleteMapping("/{id}")
    public void deleteScore(@PathVariable Long id) {
        scoreService.deleteScore(id);
    }
}
