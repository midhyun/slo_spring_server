package slo.slo_spring_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import slo.slo_spring_server.domain.user.User;
import slo.slo_spring_server.service.UserService;

@Controller()
@RequestMapping("/user")
public class UserController {

    private final UserService personService;

    @Autowired
    public UserController(UserService personService) {
        this.personService = personService;
    }

}
