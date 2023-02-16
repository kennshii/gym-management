package com.kennshi.gym_management_rest.service;

import com.kennshi.gym_management_rest.api.v1.mapper.ClientMapper;
import com.kennshi.gym_management_rest.api.v1.model.ClientDto;
import com.kennshi.gym_management_rest.domain.Client;
import com.kennshi.gym_management_rest.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public ClientDto createNewClient(ClientDto clientDTO) {

        Client clientToSave = clientMapper.toClient(clientDTO);

        clientRepository.save(clientToSave);

        return clientMapper.toClientDto(clientToSave);
    }

    @Override
    public ClientDto updateClient(Long clientId, ClientDto clientDTO) {

        Client client = clientRepository.findById(clientId)
                .orElseThrow(ResourceNotFoundException::new);

        Client clientToUpdate = clientMapper.toClient(clientDTO);

        if(clientToUpdate.getId().equals(client.getId())) {
            clientRepository.save(clientToUpdate);
        } else {
            throw new RuntimeException();
        }

        return clientMapper.toClientDto(clientToUpdate);
    }

    @Override
    public ClientDto patchClient(Long id, ClientDto clientDTO) {

        Client client = clientRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);

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
