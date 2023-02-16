package com.kennshi.gym_management_rest.repositories;

import com.kennshi.gym_management_rest.domain.MembershipType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipTypeRepository extends JpaRepository<MembershipType, Long> {
}
