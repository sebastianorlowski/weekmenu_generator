package com.meal_generator.api.dto.menu;

import jakarta.annotation.PostConstruct;
import lombok.Data;

import java.util.List;

@Data
public class MenuDto {

    private String id;

    private List<DayMealDto> dayMealDtoList;

    boolean isWeekly;

    @PostConstruct
    public void init() {
        if (isWeekly) {
            for (DayEnum dayEnum : DayEnum.values()) {
                DayMealDto dayMealDto = new DayMealDto();
                dayMealDto.setDayEnum(dayEnum);
                dayMealDtoList.add(dayMealDto);
            }
        } else {
            DayMealDto dayMealDto = new DayMealDto();
            dayMealDto.setDayEnum(null);
            dayMealDtoList.add(dayMealDto);
        }
    }
}
