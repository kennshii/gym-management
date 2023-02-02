package com.kennshi.gym_management.repositories;

import com.kennshi.gym_management.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
