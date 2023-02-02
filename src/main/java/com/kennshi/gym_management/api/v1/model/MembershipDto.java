package com.kennshi.gym_management.api.v1.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.kennshi.gym_management.domain.Membership} entity
 */
@Data
public class MembershipDto implements Serializable {
    private final Long id;
    private final LocalDate startDate;
    private final LocalDate endDate;
}