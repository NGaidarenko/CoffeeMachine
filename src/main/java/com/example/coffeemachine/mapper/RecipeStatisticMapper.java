package com.example.coffeemachine.mapper;

import com.example.coffeemachine.dto.RecipeStatisticDto;
import com.example.coffeemachine.entity.RecipeStatistics;
import org.springframework.stereotype.Component;

@Component
public class RecipeStatisticMapper {

    public RecipeStatisticDto toDto(RecipeStatistics statistics) {
        return new RecipeStatisticDto(
                statistics.getId(),
                statistics.getRecipe(),
                statistics.getOrderCount()
        );
    }
}
