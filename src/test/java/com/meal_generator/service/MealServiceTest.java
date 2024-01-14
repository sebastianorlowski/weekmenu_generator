package com.meal_generator.service;

import com.meal_generator.service.mapper.MealMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

class MealServiceTest {

    @Mock
    private MealMapper mealMapper;
    @InjectMocks
    private MealService mealService;

    @Test
    void test() {

    }
}