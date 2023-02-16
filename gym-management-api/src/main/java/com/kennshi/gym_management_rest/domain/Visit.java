package com.kennshi.gym_management_rest.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private LocalTime startTime;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Visit(Client client) {
        this.client = client;
        date = LocalDate.now();
        startTime = LocalTime.now();
    }
}
