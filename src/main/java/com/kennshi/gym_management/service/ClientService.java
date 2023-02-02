package com.kennshi.gym_management.service;

import com.kennshi.gym_management.api.v1.model.ClientDto;

import java.util.List;

public interface ClientService {

    List<ClientDto> getAllClients();

    ClientDto getClientById(Long id);

    ClientDto createNewClient(ClientDto clientDTO);

    ClientDto updateClient(ClientDto clientDTO);

    ClientDto patchClient(Long id, ClientDto clientDto);

    void deleteById(Long id);
}
