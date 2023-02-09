package com.kennshi.gym_management.controller.v1;

import com.kennshi.gym_management.api.v1.model.ClientDto;
import com.kennshi.gym_management.service.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static com.kennshi.gym_management.controller.v1.AbstractRestControllerTest.asJsonString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClientController.class)
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService clientService;

    @Test
    void getAllClients() throws Exception {
        ClientDto client1 = ClientDto.builder()
                .id(1L)
                .name("SCAM")
                .email("apohui@mail.ru")
                .build();

        ClientDto client2 = ClientDto.builder()
                .id(2L)
                .name("SCAM2")
                .email("apohui@mail.ru")
                .build();

        List<ClientDto> clients = Arrays.asList(client1, client2);

        when(clientService.getAllClients()).thenReturn(clients);

        mockMvc.perform(get(ClientController.BASE_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void getClientById() throws Exception {
        //given
        ClientDto client1 = ClientDto.builder()
                .id(1L)
                .name("SCAM")
                .email("apohui@mail.ru")
                .build();


        when(clientService.getClientById(anyLong())).thenReturn(client1);

        //when/then
        mockMvc.perform(get(ClientController.BASE_URL + "/1")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", equalTo(Integer.valueOf(client1.getId().toString()))))
                .andExpect(jsonPath("$.name", equalTo(client1.getName())))
                .andExpect(jsonPath("$.email", equalTo(client1.getEmail())));
    }

    @Test
    void createNewClient() throws Exception {
        //given
        ClientDto clientDto = ClientDto.builder()
                .name("John Doe")
                .email("johndoe@example.com")
                .build();

        ClientDto savedClientDto = ClientDto.builder()
                .id(1L)
                .name(clientDto.getName())
                .email(clientDto.getEmail())
                .build();

        when(clientService.createNewClient(any(ClientDto.class))).thenReturn(savedClientDto);

        //when/then
        mockMvc.perform(post(ClientController.BASE_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(clientDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", equalTo(savedClientDto.getName())))
                .andExpect(jsonPath("$.email", equalTo(savedClientDto.getEmail())))
                .andExpect(jsonPath("$.id", equalTo(savedClientDto.getId().intValue())));
    }

    @Test
    void updateClient() throws Exception {
        //given
        ClientDto clientDto = ClientDto.builder()
                .name("John Doe")
                .email("johndoe@example.com")
                .build();

        ClientDto savedClientDto = ClientDto.builder()
                .id(1L)
                .name(clientDto.getName())
                .email(clientDto.getEmail())
                .build();

        when(clientService.updateClient(anyLong(), any(ClientDto.class))).thenReturn(savedClientDto);

        //when/then
        mockMvc.perform(put(ClientController.BASE_URL + "/1")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(clientDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo(savedClientDto.getName())))
                .andExpect(jsonPath("$.email", equalTo(savedClientDto.getEmail())))
                .andExpect(jsonPath("$.id", equalTo(savedClientDto.getId().intValue())));

    }

    @Test
    void patchClient() throws Exception {
        //given
        ClientDto clientDto = ClientDto.builder()
                .name("John Doe")
                .email("johndoe@example.com")
                .build();

        ClientDto savedClientDto = ClientDto.builder()
                .id(1L)
                .name(clientDto.getName())
                .email(clientDto.getEmail())
                .build();

        when(clientService.patchClient(anyLong(), any(ClientDto.class))).thenReturn(savedClientDto);

        //when/then
        mockMvc.perform(patch(ClientController.BASE_URL + "/1")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(clientDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo(savedClientDto.getName())))
                .andExpect(jsonPath("$.email", equalTo(savedClientDto.getEmail())))
                .andExpect(jsonPath("$.id", equalTo(savedClientDto.getId().intValue())))
                .andExpect(jsonPath("$.birthday", equalTo(savedClientDto.getBirthday())));
    }

    @Test
    void deleteClient() throws Exception {

        mockMvc.perform(delete(ClientController.BASE_URL + "/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(clientService, times(1)).deleteById(anyLong());
    }
}