package com.kennshi.gym_management_rest.repositories;

import com.kennshi.gym_management_rest.domain.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<Membership, Long> {
}
