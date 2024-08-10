package slo.slo_spring_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/admin")
@RestController
public class AdminController {

    @GetMapping("/")
    public String mainP() {
        return "main Controller";
    }
}
