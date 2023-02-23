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

    public MembershipType(String name) {
        this.name = name;

        if(name.equals("12 MONTHS")) {
            setPrice(BigDecimal.valueOf(2999L));
            setMaxVisits(-1);
        }

        if(name.equals("3 MONTHS")) {
            setPrice(BigDecimal.valueOf(999L));
            setMaxVisits(-1);
        }

        if(name.equals("1 MONTH")) {
            setPrice(BigDecimal.valueOf(450L));
            setMaxVisits(-1);
        }

        if(name.equals("12 VISITS")) {
            setPrice(BigDecimal.valueOf(350L));
            setMaxVisits(12);
        }
    }
}
