package slo.slo_spring_server.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import slo.slo_spring_server.dto.UserDTO;
import slo.slo_spring_server.jwt.JwtUtil;
import slo.slo_spring_server.service.UserService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/join")
    public String joinProcess(@Valid @RequestBody UserDTO.Request userDTO) {
        userService.createUser(userDTO);

        return "ok";
    }

    @PostMapping("/reissue")
    public ResponseEntity<?> reissueProcess(HttpServletRequest request, HttpServletResponse response) {
        String refresh = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("refresh")) {
                refresh = cookie.getValue();
            }
        }

        if (refresh == null) {

            return new ResponseEntity<>("refresh token null", HttpStatus.BAD_REQUEST);
        }

        String newAccessToken = userService.refreshToken(refresh);

        response.setHeader("acceess", newAccessToken);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
