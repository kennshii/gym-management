package com.kennshi.gym_management.controller;

import com.kennshi.gym_management.api.v1.mapper.ClientFullMapper;
import com.kennshi.gym_management.api.v1.model.ClientFullDto;
import com.kennshi.gym_management.repositories.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/clientsFull")
public class ClientFullController {

    private final ClientRepository clientRepository;
    private final ClientFullMapper clientFullMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClientFullDto> getAllClients() {
        return clientRepository.findAll().stream()
                .map(clientFullMapper::toClientFullDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{clientId}")
    @ResponseStatus(HttpStatus.OK)
    public ClientFullDto getClientById(@PathVariable Long clientId) {
        return clientRepository.findById(clientId)
                .map(clientFullMapper::toClientFullDto)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id " + clientId));
    }
}
