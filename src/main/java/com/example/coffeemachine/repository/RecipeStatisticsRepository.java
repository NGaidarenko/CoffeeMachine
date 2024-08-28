package com.example.coffeemachine.repository;

import com.example.coffeemachine.entity.RecipeStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeStatisticsRepository extends JpaRepository<RecipeStatistics, Long> {
}
