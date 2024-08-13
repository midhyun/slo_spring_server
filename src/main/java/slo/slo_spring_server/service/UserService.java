package slo.slo_spring_server.service;

import jakarta.servlet.http.HttpServletResponse;
import slo.slo_spring_server.domain.user.User;
import slo.slo_spring_server.dto.UserDTO;

import java.util.List;


public interface UserService {
    void createUser(UserDTO.Request dto);
    void updateUser(UserDTO.Request dto);
    void deleteUser(Long id);
    List<User> getAllUsers();
    String refreshToken(String token);
}
