package com.kennshi.gym_management.controller.v1;

import com.kennshi.gym_management.api.v1.mapper.ClientFullMapper;
import com.kennshi.gym_management.api.v1.mapper.MembershipMapper;
import com.kennshi.gym_management.api.v1.model.ClientFullDto;
import com.kennshi.gym_management.api.v1.model.MembershipDto;
import com.kennshi.gym_management.domain.Client;
import com.kennshi.gym_management.repositories.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/clientsFull")
public class ClientFullController {

    private final ClientRepository clientRepository;
    private final ClientFullMapper clientFullMapper;
    private final MembershipMapper membershipMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClientFullDto> getAllClients() {
        return clientRepository.findAll().stream()
                .map(this::getClientFullDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{clientId}")
    @ResponseStatus(HttpStatus.OK)
    public ClientFullDto getClientById(@PathVariable Long clientId) {
        return clientRepository.findById(clientId)
                .map(this::getClientFullDto)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id " + clientId));
    }

    private ClientFullDto getClientFullDto(Client client) {
        //manually setting dto fields for membership
        Set<MembershipDto> membershipDtoSet = client.getMemberships()
                .stream()
                .map(membershipMapper::toMembershipDTO).collect(Collectors.toSet());

        //setting it to returnable object
        ClientFullDto clientFullDto = clientFullMapper.toClientFullDto(client);
        clientFullDto.setMemberships(membershipDtoSet);

        return clientFullDto;
    }
}
