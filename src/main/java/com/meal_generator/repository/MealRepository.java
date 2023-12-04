package com.meal_generator.repository;

import com.meal_generator.repository.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {
}
