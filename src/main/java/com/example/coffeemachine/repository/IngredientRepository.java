package com.example.coffeemachine.repository;

import com.example.coffeemachine.entity.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {
    Boolean existsByName(String name);
}
