package com.example.demo.services;

import com.example.demo.model.LiveScore;
import com.example.demo.repository.LiveScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LiveScoreService {
    @Autowired
    private LiveScoreRepository liveScoreRepository;

    public LiveScore getLiveScoreByMatchId(Long matchId) {
        return liveScoreRepository.findByMatchId(matchId);
    }

    public LiveScore updateLiveScore(LiveScore liveScore) {
        return liveScoreRepository.save(liveScore);
    }

    public LiveScore createLiveScore(LiveScore score) {
        return liveScoreRepository.save(score);
    }
}
