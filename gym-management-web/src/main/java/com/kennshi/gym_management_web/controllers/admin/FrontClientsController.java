package com.kennshi.gym_management_web.controllers.admin;

import com.kennshi.gym_management_rest.api.v1.model.ClientDto;
import com.kennshi.gym_management_rest.api.v1.model.ClientFullDto;
import com.kennshi.gym_management_rest.controller.v1.ClientFullController;
import com.kennshi.gym_management_rest.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FrontClientsController {

    private final ClientFullController clientFullController;
    private final ClientService clientService;

    public FrontClientsController(ClientFullController clientFullController, ClientService clientService) {
        this.clientFullController = clientFullController;
        this.clientService = clientService;
    }


    @RequestMapping("/menu/clients")
    public String getAllClients(Model model) {

        List<ClientFullDto> clients = clientFullController.getAllClients();

        model.addAttribute("clients", clients);

        return "admin/clients/clients_list";
    }

    @GetMapping("/clients/{id}")
    public String getInfo(@PathVariable Long id, Model model) {

        ClientFullDto clientDto = clientFullController.getClientById(id);

        model.addAttribute("client", clientDto);

        return "admin/clients/client_info";
    }

    @GetMapping("/clients/{id}/edit")
    public String editClient(@PathVariable Long id, Model model) {

        model.addAttribute("client", clientService.getClientById(id));

        return "/admin/clients/client_edit";
    }

    @PostMapping("/clients/{id}/save")
    public String saveOrUpdate(@ModelAttribute ClientDto toSave, @PathVariable Long id, Model model) {

        clientService.updateClient(id, toSave);

        return "redirect:/clients/{id}";
    }

    @GetMapping("/clients/{id}/delete")
    public String deleteClient(@PathVariable Long id) {

        clientService.deleteById(id);

        return "redirect:/menu/clients";
    }
}
