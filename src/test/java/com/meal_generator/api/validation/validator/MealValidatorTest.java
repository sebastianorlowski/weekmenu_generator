package com.meal_generator.api.validation.validator;

import com.meal_generator.api.dto.MealDto;
import com.meal_generator.api.mother.MealDtoMother;
import com.meal_generator.api.validation.exception.MealException;
import com.meal_generator.repository.MealRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MealValidatorTest {

    @Mock
    private MealRepository mealRepository;

    @InjectMocks
    private MealValidator mealValidator;

    @Test
    void shouldThrowExceptionIfMealNameAlreadyExistsWhenCreate() {
        MealDto meal = MealDtoMother.complete().build();
        when(mealRepository.existsMealByName(MealDtoMother.NAME))
                .thenReturn(true);

        MealException mealException = assertThrows(MealException.class, () -> mealValidator.validateCreateMeal(meal));

        assertThat(mealException.getMessage()).isEqualTo("Meal with name dinner already exists.");
    }

    @Test
    void shouldThrowExceptionIfMealNameAlreadyExistsWhenUpdate() {
        MealDto meal = MealDtoMother.complete().build();
        when(mealRepository.existsMealByName(MealDtoMother.NAME))
                .thenReturn(true);

        MealException mealException = assertThrows(MealException.class, () ->
                mealValidator.validateUpdateMeal("breakfast", meal));

        assertThat(mealException.getMessage()).isEqualTo("Meal with name dinner already exists.");
    }
}