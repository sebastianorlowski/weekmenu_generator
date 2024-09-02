package com.meal_generator.repository.model;

import com.meal_generator.repository.model.common.AuditableEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "recipes")
@Getter
@Setter
public class Recipe extends AuditableEntity {

    @Column(length = 100)
    private String name;

    @Column
    private Integer days;

    @Column(length = 1000)
    private String instruction;

    @Column(name = "estimated_time")
    private Integer estimatedTime;

    @OneToMany(mappedBy = "recipe")
    private List<Ingredient> ingredients;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(name, recipe.name) && Objects.equals(days, recipe.days) && Objects.equals(instruction, recipe.instruction) && Objects.equals(estimatedTime, recipe.estimatedTime) && Objects.equals(ingredients, recipe.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, days, instruction, estimatedTime, ingredients);
    }
}
