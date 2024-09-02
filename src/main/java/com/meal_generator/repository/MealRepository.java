package com.meal_generator.repository;

import com.meal_generator.repository.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

    Optional<Meal> findMealByExternalId(String externalId);

    boolean existsMealByName(String name);

    List<Meal> findAllByNameIn(List<String> names);
}
