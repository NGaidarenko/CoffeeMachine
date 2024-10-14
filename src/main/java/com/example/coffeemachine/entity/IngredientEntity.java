package com.example.coffeemachine.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cache.annotation.Cacheable;

import java.io.Serializable;

@Entity
@Table(name = "ingredient", schema = "coffee_machine")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Cacheable(value = "ingredientEntity")
public class IngredientEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;
}
