package com.example.coffeemachine.dto;

import com.example.coffeemachine.entity.RecipeEntity;

import java.time.LocalDateTime;

public record OrderDto (
        Long id,
        RecipeEntity recipe,
        LocalDateTime date
){
}
