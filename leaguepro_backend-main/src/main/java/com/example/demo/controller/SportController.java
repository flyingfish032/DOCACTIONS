package com.example.demo.controller;

import com.example.demo.model.Sport;
import com.example.demo.services.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sports")
@CrossOrigin(origins = "*")
public class SportController {
    @Autowired
    private SportService sportService;

    @GetMapping
    public List<Sport> getAllSports() {
        return sportService.getAllSports();
    }

    @GetMapping("/{id}")
    public Optional<Sport> getSportById(@PathVariable Long id) {
        return sportService.getSportById(id);
    }

    @PostMapping
    public Sport createSport(@RequestBody Sport sport) {
        return sportService.createSport(sport);
    }

    @PutMapping("/{id}")
    public Sport updateSport(@PathVariable Long id, @RequestBody Sport sport) {
        return sportService.updateSport(id, sport);
    }

    @DeleteMapping("/{id}")
    public void deleteSport(@PathVariable Long id) {
        sportService.deleteSport(id);
    }
}
