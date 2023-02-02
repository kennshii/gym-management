package com.kennshi.gym_management.api.v1.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link com.kennshi.gym_management.domain.MembershipType} entity
 */
@Data
public class MembershipTypeDto implements Serializable {
    private final Long id;
    private final String name;
    private final BigDecimal price;
    private final Integer maxVisits;
}