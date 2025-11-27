package com.example.demo.controller;

import com.example.demo.model.Series;
import com.example.demo.services.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/series")
@CrossOrigin(origins = "*")
public class SeriesController {
    @Autowired
    private SeriesService seriesService;

    @GetMapping
    public List<Series> getAllSeries() {
        return seriesService.getAllSeries();
    }

    @GetMapping("/{id}")
    public Optional<Series> getSeriesById(@PathVariable Long id) {
        return seriesService.getSeriesById(id);
    }

    @PostMapping
    public Series createSeries(@RequestBody Series series) {
        return seriesService.createSeries(series);
    }

    @PutMapping("/{id}")
    public Series updateSeries(@PathVariable Long id, @RequestBody Series series) {
        return seriesService.updateSeries(id, series);
    }

    @DeleteMapping("/{id}")
    public void deleteSeries(@PathVariable Long id) {
        seriesService.deleteSeries(id);
    }
}
