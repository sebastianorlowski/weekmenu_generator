package com.meal_generator.service;

import com.meal_generator.api.dto.MealDto;
import com.meal_generator.api.mother.MealDtoMother;
import com.meal_generator.api.validation.exception.MealNotFoundException;
import com.meal_generator.api.validation.validator.MealValidator;
import com.meal_generator.repository.MealRepository;
import com.meal_generator.repository.model.Meal;
import com.meal_generator.repository.mother.MealMother;
import com.meal_generator.service.mapper.MealMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.meal_generator.api.validation.MealDtoValidationMessage.MEAL_NOT_FOUND_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class MealServiceTest {

    @Mock
    private MealMapper mealMapper;
    @Mock
    private RecipeService recipeService;
    @Mock
    private MealRepository mealRepository;
    @Mock
    private MealValidator mealValidator;
    @InjectMocks
    private MealService mealService;

    @Test
    void shouldFindMealByExternalId() {
        Meal meal = MealMother.complete().build();
        when(mealRepository.findMealByExternalId(MealMother.EXTERNAL_ID))
                .thenReturn(Optional.of(meal));

        Optional<Meal> result = mealService.findMealByExternalId(MealMother.EXTERNAL_ID);

        assertThat(result).hasValue(meal);
    }

    @Test
    void shouldGetMealByExternalId() {
        Meal meal = MealMother.complete().build();
        when(mealRepository.findMealByExternalId(MealMother.EXTERNAL_ID))
                .thenReturn(Optional.of(meal));

        Meal result = mealService.getMealByExternalId(MealMother.EXTERNAL_ID);

        assertThat(result).isEqualTo(meal);
    }

    @Test
    void shouldNotFindMealByExternalId() {
        when(mealRepository.findMealByExternalId(MealMother.EXTERNAL_ID))
                .thenReturn(Optional.empty());

        Optional<Meal> result = mealService.findMealByExternalId(MealMother.EXTERNAL_ID);

        assertThat(result).isEmpty();
    }

    @Test
    void shouldThrowExceptionWhenMealNotFoundByExternalId() {
        when(mealRepository.findMealByExternalId(MealMother.EXTERNAL_ID))
                .thenReturn(Optional.empty());

        MealNotFoundException exception = assertThrows(MealNotFoundException.class, () ->
                mealService.getMealByExternalId(MealMother.EXTERNAL_ID));

        assertThat(exception.getMessage()).isEqualTo(String.format(MEAL_NOT_FOUND_ERROR, MealMother.EXTERNAL_ID));
    }

    @Test
    void shouldCreateMeal() {
        MealDto mealDto = MealDtoMother.complete().build();
        Meal meal = MealMother.complete().build();
        Meal savedMeal = MealMother.complete().build();
        when(mealMapper.asMealEntity(mealDto))
                .thenReturn(meal);
        when(mealRepository.save(meal))
                .thenReturn(savedMeal);
        when(mealMapper.asMealDto(savedMeal))
                .thenReturn(mealDto);

        MealDto result = mealService.createMeal(mealDto);

        assertThat(result).isEqualTo(mealDto);

        verify(mealValidator).validateCreateMeal(mealDto);
    }

    @Test
    void shouldUpdateMeal() {
        final String nameUpdated = "nameUpdated";
        MealDto mealDto = MealDtoMother.complete()
                .withName(nameUpdated)
                .build();
        Meal meal = MealMother.complete().build();
        Meal savedMeal = MealMother.complete().build();
        when(mealRepository.findMealByExternalId(MealDtoMother.EXTERNAL_ID))
                .thenReturn(Optional.of(meal));
        when(mealMapper.asMealEntity(mealDto))
                .thenReturn(meal);
        when(mealRepository.save(meal))
                .thenReturn(savedMeal);
        when(mealMapper.asMealDto(savedMeal))
                .thenReturn(mealDto);

        MealDto result = mealService.updateMeal(MealDtoMother.EXTERNAL_ID, mealDto);

        assertThat(result).isEqualTo(mealDto);

        verify(mealValidator).validateUpdateMeal(MealMother.NAME, mealDto);
    }
}