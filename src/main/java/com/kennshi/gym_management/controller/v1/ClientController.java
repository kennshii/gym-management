package com.kennshi.gym_management.controller.v1;

import com.kennshi.gym_management.api.v1.model.ClientDto;
import com.kennshi.gym_management.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(ClientController.BASE_URL)
public class ClientController {

    public static final String BASE_URL = "/api/v1/clients";
    private final ClientService clientService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClientDto> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientDto getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDto createNewClient(@RequestBody ClientDto clientDto) {
        return clientService.createNewClient(clientDto);
    }

    @PutMapping("/{clientId}")
    @ResponseStatus(HttpStatus.OK)
    public ClientDto updateClient(@PathVariable Long clientId,@RequestBody ClientDto clientDto) {
        return clientService.updateClient(clientId, clientDto);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientDto patchClient(@PathVariable Long id ,@RequestBody ClientDto clientDto) {
        return clientService.patchClient(id, clientDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteClient(@PathVariable Long id){
        clientService.deleteById(id);
    }
}
