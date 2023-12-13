package com.meal_generator.repository.model;

import com.meal_generator.repository.model.common.BaseEntity;
import com.meal_generator.repository.model.enums.RecipeType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Table(name = "recipes")
@Data
@EqualsAndHashCode(callSuper = true)
public class Recipe extends BaseEntity {

    @Column
    private String name;

    @Column(name = "recipe_type")
    @Enumerated(EnumType.STRING)
    private RecipeType recipeType;

    @Column
    private Integer days;

    @Column(length = 10000)
    private String instruction;

    @Column(name = "estimated_time")
    private Integer estimatedTime;

    @OneToMany(mappedBy = "recipe")
    private List<Ingredient> ingredients;

    @ManyToMany(mappedBy = "dailyRecipes")
    private List<Daily> dailyList;
}
