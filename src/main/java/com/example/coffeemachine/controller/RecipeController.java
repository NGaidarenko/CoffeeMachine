package com.example.coffeemachine.controller;

import com.example.coffeemachine.entity.RecipeEntity;
import com.example.coffeemachine.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public ResponseEntity<List<RecipeEntity>> getAllRecipes() {

        return new ResponseEntity<>(recipeService.getAllEntity(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeEntity> getRecipeById(@PathVariable Long id) {
        return new ResponseEntity<> (recipeService.getEntityById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RecipeEntity> addRecipe(@RequestBody RecipeEntity recipe) {
        RecipeEntity recipeEntity = recipeService.createRecipe(recipe);

        return new ResponseEntity<>(recipeEntity, HttpStatus.CREATED);
    }

    @PutMapping("/{recipeId}")
    public ResponseEntity<RecipeEntity> updateRecipe(@PathVariable Long recipeId, @RequestBody RecipeEntity recipe) {
        RecipeEntity recipeEntity = recipeService.updateRecipe(recipeId, recipe);

        return new ResponseEntity<>(recipeEntity, HttpStatus.OK);
    }
}
