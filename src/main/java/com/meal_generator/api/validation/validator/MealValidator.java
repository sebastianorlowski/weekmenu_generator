package com.meal_generator.api.validation.validator;

import com.meal_generator.api.dto.MealDto;
import com.meal_generator.api.validation.exception.MealException;
import com.meal_generator.repository.MealRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import static com.meal_generator.api.validation.MealDtoValidationMessage.MEAL_NAME_EXISTS_ERROR;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class MealValidator {

    private MealRepository mealRepository;

    public void validateCreateMeal(MealDto mealDto) {
        if (mealRepository.existsMealByName(mealDto.getName())) {
            throw new MealException(MEAL_NAME_EXISTS_ERROR, mealDto.getName());
        }
    }

    public void validateUpdateMeal(String mealName, MealDto mealDto) {
        if (!StringUtils.equalsIgnoreCase(mealName, mealDto.getName()) &&
                mealRepository.existsMealByName(mealDto.getName())) {
            throw new MealException(MEAL_NAME_EXISTS_ERROR, mealDto.getName());
        }
    }
}
