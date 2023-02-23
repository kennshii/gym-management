package com.kennshi.gym_management_web.controllers.admin;

import com.kennshi.gym_management_rest.api.v1.model.ClientFullDto;
import com.kennshi.gym_management_rest.api.v1.model.MembershipDto;
import com.kennshi.gym_management_rest.controller.v1.ClientFullController;
import com.kennshi.gym_management_rest.service.ClientService;
import com.kennshi.gym_management_rest.service.MembershipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clients")
public class FrontMembershipController {

    private final ClientFullController clientFullController;
    private final MembershipService membershipService;
    private final ClientService clientService;

    public FrontMembershipController(ClientFullController clientFullController, MembershipService membershipService, ClientService clientService) {
        this.clientFullController = clientFullController;
        this.membershipService = membershipService;
        this.clientService = clientService;
    }


    @GetMapping("{id}/memberships")
    public String getMembershipInfo(@PathVariable Long id, Model model) {

        ClientFullDto clientDto = clientFullController.getClientById(id);

        model.addAttribute("clients", clientDto);

        return "/admin/clients/membership/membership_info";
    }

    @GetMapping("{clientId}/memberships/{membershipId}/edit")
    public String editMembership(@PathVariable Long clientId,
                                 @PathVariable Long membershipId,
                                 Model model) {

        model.addAttribute("client", clientService.getClientById(clientId));
        model.addAttribute("membership", membershipService.getMembershipById(membershipId));

        return "/admin/clients/membership/membership_edit";
    }

    @PostMapping("{clientId}/memberships/{membershipId}/save")
    public String saveMembership(@ModelAttribute MembershipDto membershipDto,
                                 @PathVariable Long clientId,
                                 @PathVariable Long membershipId,
                                 Model model) {

        membershipService.updateMembership(clientId, membershipId, membershipDto);

        return "redirect:/clients/{clientId}/memberships";
    }

    @GetMapping("{clientId}/memberships/{membershipId}/delete")
    public String deleteMembership(@PathVariable Long clientId, @PathVariable Long membershipId) {

        membershipService.deleteById(membershipId);

        return "redirect:/clients/{clientId}/memberships";
    }

}
