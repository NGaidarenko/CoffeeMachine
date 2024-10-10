package com.example.coffeemachine.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "statistics", schema = "coffee_machine")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "recipe_id", nullable = false, unique = true)
    private RecipeEntity recipe;

    @Column(name = "order_count", nullable = false)
    private Integer orderCount = 0;
}
