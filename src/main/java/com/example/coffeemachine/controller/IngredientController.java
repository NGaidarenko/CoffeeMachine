package com.example.coffeemachine.controller;

import com.example.coffeemachine.dto.IngredientDto;
import com.example.coffeemachine.entity.IngredientEntity;
import com.example.coffeemachine.mapper.IngredientMapper;
import com.example.coffeemachine.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private IngredientMapper ingredientMapper;

    @GetMapping
    public ResponseEntity<List<IngredientDto>> getAllIngredients() {
        List<IngredientEntity> ingredients = ingredientService.getAllIngredients();

        return new ResponseEntity<>(ingredients
                .stream()
                .map(ingredientMapper::toDto)
                .toList(),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<IngredientDto> addIngredient(@RequestBody IngredientDto ingredient) {
        IngredientEntity updatedIngredients =  ingredientService.addIngredient(ingredient);

        return new ResponseEntity<>(ingredientMapper.toDto(updatedIngredients), HttpStatus.CREATED);
    }

    @PutMapping("/{ingredientId}")
    public ResponseEntity<IngredientDto> updateIngredient(@PathVariable Long ingredientId, @RequestBody IngredientDto ingredient) {
        IngredientEntity updatedIngredients = ingredientService.updateIngredient(ingredientId, ingredient);

        return new ResponseEntity<>(ingredientMapper.toDto(updatedIngredients), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable Long id) {
        ingredientService.deleteIngredient(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
