package com.meal_generator.api.validation.validator;

import com.meal_generator.api.dto.MealDto;
import com.meal_generator.api.validation.exception.MealException;
import com.meal_generator.repository.MealRepository;
import com.meal_generator.repository.model.Meal;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

import static com.meal_generator.api.validation.MealDtoValidationMessage.*;

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

    public void validateCreateDailyMealSchedule(String name, List<String> mealNames, List<Meal> mealList) {
        List<String> notExistingMealNames = mealNames.stream()
                .filter(mealName -> mealList.stream()
                        .noneMatch(meal -> meal.getName().equals(mealName)))
                .toList();
        if (CollectionUtils.isEmpty(notExistingMealNames)) {
            return;
        }
        throw new MealException(MEAL_NAMES_NOT_EXISTS_ERROR, notExistingMealNames.toArray(new String[0]));
    }

//    private void validateMealScheduleName(String name) {
//        if (mealRepository.existsMealByName(name)) {
//            throw
//        }
//
//    }

//    public void validateMealRecipe(List<Meal> mealList) {
//        mealList.forEach(meal -> );
//    }
}
