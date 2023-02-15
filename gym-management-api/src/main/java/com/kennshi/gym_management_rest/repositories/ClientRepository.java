package com.kennshi.gym_management_rest.repositories;

import com.kennshi.gym_management_rest.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
