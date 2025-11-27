package com.example.demo.services;

import com.example.demo.model.Series;
import com.example.demo.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeriesService {
    @Autowired
    private SeriesRepository seriesRepository;

    public List<Series> getAllSeries() {
        return seriesRepository.findAll();
    }

    public Optional<Series> getSeriesById(Long id) {
        return seriesRepository.findById(id);
    }

    public Series createSeries(Series series) {
        return seriesRepository.save(series);
    }

    public Series updateSeries(Long id, Series seriesDetails) {
        Series series = seriesRepository.findById(id).orElseThrow();
        series.setName(seriesDetails.getName());
        series.setStartDate(seriesDetails.getStartDate());
        series.setEndDate(seriesDetails.getEndDate());
        series.setSport(seriesDetails.getSport());
        return seriesRepository.save(series);
    }

    public void deleteSeries(Long id) {
        seriesRepository.deleteById(id);
    }
}
