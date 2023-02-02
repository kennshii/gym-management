package com.kennshi.gym_management.domain;

import jakarta.persistence.*;
import lombok.*;

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
    private Integer price;
    private Integer maxVisits;

    @OneToMany(mappedBy = "membershipType", cascade = CascadeType.ALL)
    private Set<Membership> memberships;

    // getters and setters
}
