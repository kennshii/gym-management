package com.kennshi.gym_management_rest.repositories;

import com.kennshi.gym_management_rest.domain.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}
