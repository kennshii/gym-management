package com.kennshi.gym_management_rest.api.v1.model;

import com.kennshi.gym_management_rest.domain.Visit;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A DTO for the {@link Visit} entity
 */
@Data
@Builder
public class VisitDto implements Serializable {
    private Long id;
    private LocalDate date;
    private LocalTime startTime;
}