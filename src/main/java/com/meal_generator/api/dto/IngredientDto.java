package com.meal_generator.api.dto;

import lombok.Data;

@Data
public class IngredientDto {

    private String name;
    private int count;
    private int weight;
}
