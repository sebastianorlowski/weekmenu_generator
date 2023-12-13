package com.meal_generator.repository.model;

import com.meal_generator.repository.model.common.BaseEntity;
import com.meal_generator.repository.model.enums.Day;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "daily")
@Data
public class Daily extends BaseEntity {

    @Column(name = "days")
    @Enumerated(EnumType.STRING)
    private Day day;

    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    @ManyToMany
    @JoinTable(
            name = "daily_recipes",
            joinColumns = @JoinColumn(name = "daily_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id"))
    private List<Recipe> dailyRecipes;
}
