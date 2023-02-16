package com.kennshi.gym_management_rest.api.v1.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.kennshi.gym_management_rest.domain.Membership} entity
 */
@Data
@Builder
public class MembershipDto implements Serializable {
    private Long id;
    private Long clientId;
    private String clientName;
    private String membershipTypeName;
    private LocalDate startDate;
    private LocalDate endDate;
}