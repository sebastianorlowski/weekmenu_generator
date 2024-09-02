package com.meal_generator.api.validation.validator;

import com.meal_generator.api.dto.MealDto;
import com.meal_generator.api.mother.MealDtoMother;
import com.meal_generator.api.validation.exception.MealException;
import com.meal_generator.repository.MealRepository;
import com.meal_generator.repository.model.Meal;
import com.meal_generator.repository.mother.MealMother;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

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
    void shouldSuccessfullyWhenCreateMeal() {
        MealDto meal = MealDtoMother.complete().build();
        when(mealRepository.existsMealByName(MealDtoMother.NAME))
                .thenReturn(false);

        assertDoesNotThrow(() -> mealValidator.validateCreateMeal(meal));
    }
    @Test
    void shouldThrowExceptionIfMealNameAlreadyExistsWhenCreateMeal() {
        MealDto meal = MealDtoMother.complete().build();
        when(mealRepository.existsMealByName(MealDtoMother.NAME))
                .thenReturn(true);

        MealException mealException = assertThrows(MealException.class, () -> mealValidator.validateCreateMeal(meal));

        assertThat(mealException.getMessage()).isEqualTo("Meal with name dinner already exists.");
    }

    @Test
    void shouldSuccessfullyWhenUpdateMeal() {
        MealDto meal = MealDtoMother.complete().build();
        when(mealRepository.existsMealByName(MealDtoMother.NAME))
                .thenReturn(false);

        assertDoesNotThrow(() -> mealValidator.validateUpdateMeal("anyMealName", meal));
    }

    @Test
    void shouldThrowExceptionIfMealNameAlreadyExistsWhenUpdateMeal() {
        MealDto meal = MealDtoMother.complete().build();
        when(mealRepository.existsMealByName(MealDtoMother.NAME))
                .thenReturn(true);

        MealException mealException = assertThrows(MealException.class, () ->
                mealValidator.validateUpdateMeal("breakfast", meal));

        assertThat(mealException.getMessage()).isEqualTo("Meal with name dinner already exists.");
    }

    @Test
    void shouldSuccessfullyWhenCreateDailyMealSchedule() {
        final String scheduleName = "diet";
        List<String> mealNames = List.of(MealMother.NAME);
        List<Meal> mealList = List.of(MealMother.complete().build());

        assertDoesNotThrow(() -> mealValidator.validateCreateDailyMealSchedule(scheduleName, mealNames, mealList));
    }

    @Test
    void shouldThrowExceptionIfMealNameDoesNotExist() {
        final String scheduleName = "diet";
        final String mealName = "breakfast";
        List<String> mealNames = List.of(mealName);
        List<Meal> mealList = List.of(MealMother.complete().build());

        MealException mealException = assertThrows(MealException.class, () ->
                mealValidator.validateCreateDailyMealSchedule(scheduleName, mealNames, mealList));

        assertThat(mealException.getMessage()).isEqualTo("Meal with names [%s] does not exist.".formatted(mealName));
    }
}