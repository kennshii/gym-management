package com.kennshi.gym_management_web.controllers.admin;

import com.kennshi.gym_management_rest.service.MembershipTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/menu")
public class FrontMembershipTypeController {

    private final MembershipTypeService membershipTypeService;

    @GetMapping("/memberships")
    public String getMembershipTypes(Model model) {

        model.addAttribute("plans", membershipTypeService.getAllMemberships());

        return "/admin/membership_types";
    }
}
