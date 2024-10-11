package com.example.coffeemachine.dto;

import com.example.coffeemachine.entity.RecipeEntity;

public record RecipeStatisticDto (
        Long id,
        RecipeEntity recipe,
        Integer orderCount
) {
}
