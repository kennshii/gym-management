package com.kennshi.gym_management_rest.api.v1.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link com.kennshi.gym_management_rest.domain.MembershipType} entity
 */
@Data
@Builder
public class MembershipTypeDto implements Serializable {
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer maxVisits;
}