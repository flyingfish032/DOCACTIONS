package com.example.demo.services;

import com.example.demo.model.Sport;
import com.example.demo.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SportService {
    @Autowired
    private SportRepository sportRepository;

    public List<Sport> getAllSports() {
        return sportRepository.findAll();
    }

    public Optional<Sport> getSportById(Long id) {
        return sportRepository.findById(id);
    }

    public Sport createSport(Sport sport) {
        return sportRepository.save(sport);
    }

    public Sport updateSport(Long id, Sport sportDetails) {
        Sport sport = sportRepository.findById(id).orElseThrow();
        sport.setName(sportDetails.getName());
        return sportRepository.save(sport);
    }

    public void deleteSport(Long id) {
        sportRepository.deleteById(id);
    }
}
