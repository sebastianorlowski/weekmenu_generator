package com.meal_generator.repository.model;

import com.meal_generator.repository.model.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ingredients")
@Data
public class Ingredient extends BaseEntity {

    private String name;

    private int count;

    private int weight;

    @ManyToOne
    @JoinColumn(name = "meal_id", nullable = false)
    private Meal meal;
}
