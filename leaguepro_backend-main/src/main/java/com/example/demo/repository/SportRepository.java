package com.example.demo.repository;

import com.example.demo.model.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportRepository extends JpaRepository<Sport, Long> {
}
