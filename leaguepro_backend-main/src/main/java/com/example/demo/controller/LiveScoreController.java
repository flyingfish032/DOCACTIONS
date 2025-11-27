package com.example.demo.controller;

import com.example.demo.model.LiveScore;
import com.example.demo.services.LiveScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/livescore")
@CrossOrigin(origins = "*")
public class LiveScoreController {
    @Autowired
    private LiveScoreService liveScoreService;

    @GetMapping("/match/{matchId}")
    public LiveScore getLiveScoreByMatchId(@PathVariable Long matchId) {
        return liveScoreService.getLiveScoreByMatchId(matchId);
    }

    @PostMapping
    public LiveScore createLiveScore(@RequestBody LiveScore score) {
        return liveScoreService.createLiveScore(score);
    }

    @PutMapping("/{id}")
    public LiveScore updateLiveScore(@PathVariable Long id, @RequestBody LiveScore score) {
        score.setId(id);
        return liveScoreService.updateLiveScore(score);
    }
}
