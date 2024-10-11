package com.example.coffeemachine.service;

import com.example.coffeemachine.dto.IngredientDto;
import com.example.coffeemachine.entity.IngredientEntity;
import com.example.coffeemachine.mapper.IngredientMapper;
import com.example.coffeemachine.repository.IngredientRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private IngredientMapper ingredientMapper;

    public List<IngredientEntity> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public IngredientEntity addIngredient(IngredientDto ingredient) {
        if (ingredientRepository.existsByName(ingredient.name())) {
            throw new EntityExistsException("Ingredient with name " + ingredient.name() + " already exists");
        }

        return ingredientRepository.save(ingredientMapper.toEntity(ingredient));
    }

    public IngredientEntity updateIngredient(Long id, IngredientDto ingredient) {
        IngredientEntity entity = ingredientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ingredient with id: " + id + " not found"));

        entity.setName(ingredient.name());
        entity.setQuantity(ingredient.quantity());

        return ingredientRepository.save(entity);
    }

    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }
}
