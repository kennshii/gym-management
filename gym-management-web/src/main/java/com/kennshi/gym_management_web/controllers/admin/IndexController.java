package com.kennshi.gym_management_web.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class IndexController {

    @GetMapping
    public String getDashboard() {
        return "admin/index";
    }
}
