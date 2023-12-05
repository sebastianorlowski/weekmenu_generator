package com.meal_generator.service.mapper;

import com.meal_generator.api.dto.MealDto;
import com.meal_generator.repository.model.Meal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class MealMapperTest {

    @InjectMocks
    private MealMapper mapper = Mappers.getMapper(MealMapper.class);

    @Test
    void test() {
        Meal meal = mock(Meal.class);

        MealDto result = mapper.asMealDto(meal);

        assertThat(result).isNotNull();
    }

}