package com.kennshi.gym_management_web.controllers.admin;

import com.kennshi.gym_management_rest.api.v1.model.VisitDto;
import com.kennshi.gym_management_rest.controller.v1.ClientFullController;
import com.kennshi.gym_management_rest.controller.v1.VisitController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/clients")
public class FrontVisitController {

    private final ClientFullController clientFullController;
    private final VisitController visitController;

    @GetMapping("/{clientId}/visits")
    public String getVisitInfo(@PathVariable Long clientId, Model model) {

        model.addAttribute("client", clientFullController.getClientById(clientId));

        return "admin/clients/visits/visit_info";
    }

    @GetMapping("{clientId}/visits/{visitId}/edit")
    public String editVisit(@ModelAttribute VisitDto visitDto,
                            @PathVariable Long clientId,
                            @PathVariable Long visitId,
                            Model model) {

        model.addAttribute("client", clientFullController.getClientById(clientId));
        model.addAttribute("visit", visitController.getVisitById(visitId));

        return "/admin/clients/visits/visit_edit";
    }

    @PostMapping("{clientId}/visits/{visitId}/save")
    public String saveVisit(@ModelAttribute VisitDto visitDto,
                            @PathVariable Long clientId,
                            @PathVariable Long visitId) {

        visitController.updateVisit(clientId, visitId, visitDto);

        return "redirect:/clients/{clientId}/visits";
    }

    @GetMapping("{clientId}/visits/{visitId}/delete")
    public String deleteVisit(@PathVariable Long visitId) {

        visitController.deleteVisitById(visitId);

        return "redirect:/clients/{clientId}/visits";
    }


}
