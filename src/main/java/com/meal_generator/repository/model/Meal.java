package com.meal_generator.repository.model;

import com.meal_generator.repository.model.common.BaseEntity;
import com.meal_generator.repository.model.enums.MealType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.OffsetDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "meals")
@Data
public class Meal extends BaseEntity {

    @Column
    private String name;

    @Column(name = "meal_type")
    @Enumerated(EnumType.STRING)
    private MealType mealType;

    @Column
    private int days;

    @OneToMany(mappedBy = "meal")
    private List<Ingredient> ingredients;

    @ManyToMany(mappedBy = "dailyMeals")
    private List<Daily> dailyList;
}
