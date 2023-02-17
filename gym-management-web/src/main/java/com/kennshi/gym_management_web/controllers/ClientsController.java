package com.kennshi.gym_management_web.controllers;

import com.kennshi.gym_management_rest.api.v1.model.ClientFullDto;
import com.kennshi.gym_management_rest.controller.v1.ClientFullController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/clients")
@Controller
public class ClientsController {

    private final ClientFullController clientFullController;

    public ClientsController(ClientFullController clientFullController) {
        this.clientFullController = clientFullController;
    }

    @RequestMapping("/hi")
    public String getAllClients(Model model) {

        List<ClientFullDto> clients = clientFullController.getAllClients();

        model.addAttribute("clients", clients);

        return "index";
    }
}
