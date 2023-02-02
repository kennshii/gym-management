package com.kennshi.gym_management.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    private String phone;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set<Membership> memberships;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set<Visit> visits;

    // getters and setters
}
