package com.kennshi.gym_management_rest.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class MembershipType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal price;
    private Integer maxVisits;

    @OneToMany(mappedBy = "membershipType", cascade = CascadeType.ALL)
    private Set<Membership> memberships = new HashSet<>();

    // getters and setters
}
