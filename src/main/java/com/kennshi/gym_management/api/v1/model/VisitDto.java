package com.kennshi.gym_management.api.v1.model;

import com.kennshi.gym_management.domain.Visit;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A DTO for the {@link Visit} entity
 */
@Data
public class VisitDto implements Serializable {
    private final Long id;
    private final LocalDate date;
    private final LocalTime startTime;
}