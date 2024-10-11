package com.example.coffeemachine.service;

import com.example.coffeemachine.entity.RecipeEntity;
import com.example.coffeemachine.entity.RecipeStatistics;
import com.example.coffeemachine.repository.RecipeRepository;
import com.example.coffeemachine.repository.RecipeStatisticsRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeStatisticsRepository statisticsRepository;

    public List<RecipeEntity> getAllEntity() {
        return recipeRepository.findAll();
    }

    public RecipeEntity getEntityById(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Recipe with id: " + id + " not found"));
    }

    public RecipeEntity createRecipe(RecipeEntity recipeEntity) {
        if (recipeRepository.existsByName(recipeEntity.getName())) {
            throw new EntityExistsException("Recipe with name: " + recipeEntity.getName() + " already exists");
        }

        RecipeEntity newRecipeEntity = recipeRepository.save(recipeEntity);

        if (!statisticsRepository.existsByRecipeId(newRecipeEntity.getId())) {
            statisticsRepository.save(new RecipeStatistics(
                    newRecipeEntity.getId(),
                    newRecipeEntity,
                    0
            ));
        }

        return newRecipeEntity;
    }

    public RecipeEntity updateRecipe(Long id, RecipeEntity recipeEntity) {
        RecipeEntity recipe = getEntityById(id);

        recipe.setName(recipeEntity.getName());
        recipe.setIngredients(recipeEntity.getIngredients());

        return recipeRepository.save(recipe);
    }
}
