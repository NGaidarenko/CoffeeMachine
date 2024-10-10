package com.example.coffeemachine.mapper;

import com.example.coffeemachine.dto.IngredientDto;
import com.example.coffeemachine.entity.IngredientEntity;
import org.springframework.stereotype.Component;

@Component
public class IngredientMapper {
    public IngredientDto toDto (IngredientEntity entity) {
        return new IngredientDto(
                entity.getId(),
                entity.getName(),
                entity.getQuantity()
        );
    }

    public IngredientEntity toEntity (IngredientDto dto) {
        return new IngredientEntity(
                dto.id(),
                dto.name(),
                dto.quantity()
        );
    }
}
