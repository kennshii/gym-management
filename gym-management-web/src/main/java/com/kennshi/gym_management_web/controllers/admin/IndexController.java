package com.kennshi.gym_management_web.controllers.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/menu")
public class IndexController {

    @GetMapping
    public String getDashboard() {
        return "admin/index";
    }
}
