package com.kennshi.gym_management.repositories;

import com.kennshi.gym_management.domain.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<Membership, Long> {
}
