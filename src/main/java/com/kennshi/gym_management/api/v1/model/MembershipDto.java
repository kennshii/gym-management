package com.kennshi.gym_management.api.v1.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.kennshi.gym_management.domain.Membership} entity
 */
@Data
@Builder
public class MembershipDto implements Serializable {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
}