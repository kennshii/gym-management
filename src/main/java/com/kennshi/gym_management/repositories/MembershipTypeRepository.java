package com.kennshi.gym_management.repositories;

import com.kennshi.gym_management.domain.MembershipType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipTypeRepository extends JpaRepository<MembershipType, Long> {
}
