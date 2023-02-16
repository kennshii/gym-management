package com.kennshi.gym_management_rest.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "membership_type_id")
    private MembershipType membershipType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    public Membership(Client client, MembershipType membershipType) {
        this.client = client;
        this.membershipType = membershipType;

        if(membershipType.getName().equals("12 MONTHS")) {
            startDate = LocalDate.now();
            endDate = LocalDate.now().plusMonths(12);
        }

        if(membershipType.getName().equals("3 MONTHS")) {
            startDate = LocalDate.now();
            endDate = LocalDate.now().plusMonths(3);
        }

        if(membershipType.getName().equals("1 MONTH")) {
            startDate = LocalDate.now();
            endDate = LocalDate.now().plusMonths(1);
        }

        if(membershipType.getName().equals("12 VISITS")) {
            startDate = LocalDate.now();
            endDate = LocalDate.now().plusMonths(1);
        }
    }

    // End date: 20
    // freeze: endDate + 7(o saptamana) | 20 + 7 = 27
    // currentDate 25
    // Dupa ce se scoate freezu

}
