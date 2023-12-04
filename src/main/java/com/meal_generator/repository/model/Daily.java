package com.meal_generator.repository.model;

import com.meal_generator.repository.model.common.BaseEntity;
import com.meal_generator.repository.model.enums.Day;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "daily")
@Data
public class Daily extends BaseEntity {

    @Column(name = "day")
    @Enumerated(EnumType.STRING)
    private Day day;

    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    @ManyToMany
    @JoinTable(
            name = "daily_meals",
            joinColumns = @JoinColumn(name = "daily_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id"))
    private List<Meal> dailyMeals;
}
