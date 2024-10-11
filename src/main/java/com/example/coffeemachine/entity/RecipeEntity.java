package com.example.coffeemachine.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "recipe", schema = "coffee_machine")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ElementCollection
    @CollectionTable(name = "recipe_ingredients", schema = "coffee_machine", joinColumns = @JoinColumn(name = "recipe_id"))
    @MapKeyColumn(name = "ingredient_id")
    @Column(name = "quantity")
    private Map<Long, Integer> ingredients = new HashMap<>();

}
