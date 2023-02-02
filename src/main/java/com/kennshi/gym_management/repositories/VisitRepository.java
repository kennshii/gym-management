package com.kennshi.gym_management.repositories;

import com.kennshi.gym_management.domain.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}
