package com.kennshi.gym_management.service;

import com.kennshi.gym_management.api.v1.mapper.ClientMapper;
import com.kennshi.gym_management.api.v1.model.ClientDto;
import com.kennshi.gym_management.domain.Client;
import com.kennshi.gym_management.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public List<ClientDto> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::toClientDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto getClientById(Long id) {
        return clientRepository.findById(id)
                .map(clientMapper::toClientDto)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public ClientDto createNewClient(ClientDto clientDTO) {

        Client clientToSave = clientMapper.toClient(clientDTO);

        clientRepository.save(clientToSave);

        return clientMapper.toClientDto(clientToSave);
    }

    @Override
    public ClientDto updateClient(ClientDto clientDTO) {
        return Optional.of(clientDTO)
                .map(clientMapper::toClient)
                .map(clientRepository::save)
                .map(clientMapper::toClientDto)
                .orElseThrow(() -> new IllegalArgumentException("Unable to update client"));
    }

    @Override
    public ClientDto patchClient(Long id, ClientDto clientDTO) {

        Client client = clientRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        if (clientDTO.getName() != null) {
            client.setName(clientDTO.getName());
        }
        if (clientDTO.getEmail() != null) {
            client.setEmail(clientDTO.getEmail());
        }
        if (clientDTO.getBirthday() != null) {
            client.setBirthday(clientDTO.getBirthday());
        }
        if (clientDTO.getPhone() != null) {
            client.setPhone(clientDTO.getPhone());
        }

        clientRepository.save(client);

        return clientMapper.toClientDto(client);
    }

    @Override
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }


}
