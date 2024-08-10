package slo.slo_spring_server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import slo.slo_spring_server.dto.UserDTO;
import slo.slo_spring_server.service.UserService;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public String joinProcess(UserDTO.Request userDTO) {
        userService.createUser(userDTO);

        return "ok";
    }

}
