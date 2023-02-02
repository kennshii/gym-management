package com.kennshi.gym_management.api.v1.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.kennshi.gym_management.domain.Client} entity
 */
@Data
public class ClientDto implements Serializable {
    private final Long id;
    private final String name;
    private final String email;
    private final LocalDate birthday;
    private final String phone;
}