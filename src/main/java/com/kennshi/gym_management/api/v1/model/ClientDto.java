package com.kennshi.gym_management.api.v1.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.kennshi.gym_management.domain.Client} entity
 */
@Data
public class ClientDto implements Serializable {
    private Long id;
    private String name;
    private String email;
    private LocalDate birthday;
    private String phone;
    //todo - add path or url of entity
}