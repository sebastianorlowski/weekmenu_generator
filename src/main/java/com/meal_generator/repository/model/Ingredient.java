package com.meal_generator.repository.model;

import com.meal_generator.repository.model.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "ingredients")
@Data
@EqualsAndHashCode(callSuper = true)
public class Ingredient extends BaseEntity {

    private String name;

    private Integer worth;

    @Column(name = "is_countable")
    private Boolean isCountable;

    @Column(name = "is_divisible")
    private Boolean isDivisible;

    @Column(name = "extra_info")
    private String extraInfo;

    @ManyToOne
    @JoinColumn(name = "meal_id", nullable = false)
    private Recipe recipe;
}
