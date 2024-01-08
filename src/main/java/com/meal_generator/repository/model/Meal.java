package com.meal_generator.repository.model;

import com.meal_generator.repository.model.common.AuditableEntity;
import com.meal_generator.repository.model.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "meals")
@Data
@EqualsAndHashCode(callSuper = true)
public class Meal extends AuditableEntity {

    @Column
    private String name;

    @Column(name = "start_at")
    private OffsetDateTime startAt;

    @ManyToMany
    @JoinTable(
            name = "meal_recipes",
            joinColumns = @JoinColumn(name = "meal_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id"))
    List<Recipe> mealRecipes;
}
