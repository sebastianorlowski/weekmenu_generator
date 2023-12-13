package com.meal_generator.repository.model.common;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@MappedSuperclass
@Data
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "external_id", unique = true)
    private String externalId;

    @PrePersist
    private void prePersist() {
        if (this.externalId == null) {
            this.externalId = String.valueOf(UUID.randomUUID());
        }
    }
}
