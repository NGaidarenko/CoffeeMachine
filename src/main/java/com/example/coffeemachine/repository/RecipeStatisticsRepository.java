package com.example.coffeemachine.repository;

import com.example.coffeemachine.entity.RecipeStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeStatisticsRepository extends JpaRepository<RecipeStatistics, Long> {
    Boolean existsByRecipeId(Long id);

    Optional<RecipeStatistics> findByRecipeId(Long id);

    @Query("""
    SELECT r FROM RecipeStatistics r WHERE r.orderCount = (SELECT MAX(r.orderCount) FROM RecipeStatistics r)
    """)
    List<RecipeStatistics> findPopularRecipe();
}
