package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import com.example.demo.model.Jobs;

@Repository

public interface JobsRepository extends JpaRepository<Jobs, Long> {

}
