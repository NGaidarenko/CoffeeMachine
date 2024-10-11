package com.example.coffeemachine.service;

import com.example.coffeemachine.entity.IngredientEntity;
import com.example.coffeemachine.entity.OrderEntity;
import com.example.coffeemachine.entity.RecipeEntity;
import com.example.coffeemachine.entity.RecipeStatistics;
import com.example.coffeemachine.repository.IngredientRepository;
import com.example.coffeemachine.repository.OrderRepository;
import com.example.coffeemachine.repository.RecipeRepository;
import com.example.coffeemachine.repository.RecipeStatisticsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private RecipeStatisticsRepository statisticsRepository;

    @Transactional(rollbackFor = Exception.class)
    public OrderEntity createOrder(Long recipeId) {
        RecipeEntity recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new EntityNotFoundException("Recipe with id: " + recipeId + " not found"));

        updateIngredientQuantities(recipe);

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setRecipe(recipe);
        orderEntity.setDate(LocalDateTime.now());

        updateRecipeStatistics(recipe);

        return orderRepository.save(orderEntity);
    }

    private void updateIngredientQuantities(RecipeEntity recipe) {
        recipe.getIngredients().forEach((ingredientId, quantity) -> {
            IngredientEntity tempIngredient = ingredientRepository.findById(ingredientId)
                    .orElseThrow(() -> new EntityNotFoundException("Ingredient with id: " + ingredientId + " not found"));

            if (tempIngredient.getQuantity() < quantity) {
                throw new IllegalArgumentException("Ingredient with id: " + ingredientId + " is too small");
            }
            tempIngredient.setQuantity(tempIngredient.getQuantity() - quantity);
            ingredientRepository.save(tempIngredient);
        });
    }

    private void updateRecipeStatistics(RecipeEntity recipe) {
        RecipeStatistics recipeStatistics = statisticsRepository.findByRecipeId(recipe.getId())
                .orElseThrow(() -> new EntityNotFoundException("Recipe with id: " + recipe.getId() + " not found"));
        recipeStatistics.setRecipe(recipe);
        recipeStatistics.setOrderCount(recipeStatistics.getOrderCount() + 1);

        statisticsRepository.save(recipeStatistics);
    }

    public List<RecipeStatistics> getStatistics() {
        return statisticsRepository.findAll();
    }

    public List<RecipeStatistics> getMostPopularRecipe() {
        return statisticsRepository.findPopularRecipe();
    }
}
