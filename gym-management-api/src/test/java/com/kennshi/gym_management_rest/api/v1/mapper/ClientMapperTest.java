package com.kennshi.gym_management_rest.api.v1.mapper;

import com.kennshi.gym_management_rest.api.v1.model.ClientDto;
import com.kennshi.gym_management_rest.domain.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class ClientMapperTest {

    ClientMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = ClientMapper.INSTANCE;
    }

    @Test
    void toClientDto() {
        //given
        Client client = new Client();
        client.setName("Busuioc Eduard");
        client.setEmail("anymail@gmail.com");
        client.setBirthday(LocalDate.of(2004, 1, 30));
        client.setPhone("123456789");

        //when
        ClientDto clientDto = mapper.toClientDto(client);

        assertThat(clientDto).isNotNull();
        assertThat(clientDto.getName()).isEqualTo(client.getName());
        assertThat(clientDto.getEmail()).isEqualTo(client.getEmail());
        assertThat(clientDto.getBirthday()).isEqualTo(client.getBirthday());
        assertThat(clientDto.getPhone()).isEqualTo(client.getPhone());
    }

    @Test
    void toClient() {
        //given
        ClientDto clientDto = new ClientDto();
        clientDto.setName("name");
        clientDto.setEmail("mail");
        clientDto.setBirthday(LocalDate.of(2004, 1, 30));
        clientDto.setPhone("123456789");

        //when
        Client client = mapper.toClient(clientDto);

        //then
        assertThat(client).isNotNull();
        assertThat(client.getName()).isEqualTo(clientDto.getName());
        assertThat(client.getEmail()).isEqualTo(clientDto.getEmail());
        assertThat(client.getBirthday()).isEqualTo(clientDto.getBirthday());
        assertThat(client.getPhone()).isEqualTo(clientDto.getPhone());

    }
}