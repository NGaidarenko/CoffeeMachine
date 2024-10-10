package com.example.coffeemachine.repository;

import com.example.coffeemachine.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {
    Boolean existsByName(String name);
}
