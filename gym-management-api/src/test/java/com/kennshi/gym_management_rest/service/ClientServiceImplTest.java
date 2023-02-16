package com.kennshi.gym_management_rest.service;

import com.kennshi.gym_management_rest.api.v1.mapper.ClientMapper;
import com.kennshi.gym_management_rest.api.v1.model.ClientDto;
import com.kennshi.gym_management_rest.domain.Client;
import com.kennshi.gym_management_rest.repositories.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class ClientServiceImplTest {

    @Mock
    ClientRepository clientRepository;

    ClientMapper clientMapper = ClientMapper.INSTANCE;

    ClientService clientService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        clientService = new ClientServiceImpl(clientRepository, clientMapper);
    }

    @Test
    void getAllClients() {

        //given
        Client client = new Client();
        client.setName("Busuioc Eduard");
        client.setEmail("anymail@gmail.com");
        client.setBirthday(LocalDate.of(2004, 1, 30));
        client.setPhone("123456789");

        Client client1 = new Client();
        client1.setName("Busuioc Eduard");
        client1.setEmail("anymail@gmail.com");
        client1.setBirthday(LocalDate.of(2004, 1, 30));
        client1.setPhone("123456789");

        Client client2 = new Client();
        client2.setName("Busuioc Eduard");
        client2.setEmail("anymail@gmail.com");
        client2.setBirthday(LocalDate.of(2004, 1, 30));
        client2.setPhone("123456789");

        when(clientRepository.findAll()).thenReturn(Arrays.asList(client, client1, client2));

        //when
        List<ClientDto> clientDtoList = clientService.getAllClients();

        //then
        assertEquals(3, clientDtoList.size());
    }

    @Test
    void getClientById() {

        //given
        Client client = new Client();
        client.setId(1L);
        client.setName("test");
        client.setEmail("anymail@gmail.com");
        client.setBirthday(LocalDate.of(2004, 1, 30));
        client.setPhone("123456789");

        when(clientRepository.findById(anyLong())).thenReturn(Optional.of(client));

        //when
        ClientDto clientDto = clientService.getClientById(1L);

        //then
        assertEquals(client.getName(), clientDto.getName());
    }

    @Test
    void createNewClient() {

        //given
        ClientDto clientDto = new ClientDto();
        clientDto.setName("name");
        clientDto.setEmail("mail");
        clientDto.setBirthday(LocalDate.of(2004, 1, 30));
        clientDto.setPhone("123456789");

        Client savedClient = clientMapper.toClient(clientDto);

        when(clientRepository.save(any(Client.class))).thenReturn(savedClient);

        //when
        ClientDto savedDto = clientService.createNewClient(clientDto);

        //then
        assertEquals(savedDto.getName(), savedClient.getName());
    }

    @Test
    void updateClient() {
    }

    @Test
    void patchClient() {
    }

    @Test
    void deleteById() {
    }
}