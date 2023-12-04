package com.meal_generator.repository.model;

import com.meal_generator.repository.model.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "schedules")
public class Schedule extends BaseEntity {

    @Column(name = "valid_from")
    private OffsetDateTime validFrom;

    @Column(name = "valid_to")
    private OffsetDateTime validTo;

    @OneToMany(mappedBy = "schedule")
    private List<Daily> dailyList;
}
