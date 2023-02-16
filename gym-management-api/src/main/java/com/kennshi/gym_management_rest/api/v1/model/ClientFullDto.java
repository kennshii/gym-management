package com.kennshi.gym_management_rest.api.v1.model;

import com.kennshi.gym_management_rest.domain.Client;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * A DTO for the {@link Client} entity
 */
@Data
@Builder
public class ClientFullDto implements Serializable {
    private Long id;
    private String name;
    private String email;
    private LocalDate birthday;
    private String phone;
    private Set<MembershipDto> memberships;
    private Set<VisitDto> visits;
}