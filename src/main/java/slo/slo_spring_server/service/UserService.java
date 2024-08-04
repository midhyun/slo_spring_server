package slo.slo_spring_server.service;

import slo.slo_spring_server.domain.user.User;

import java.util.List;


public interface UserService {
    User createUser(User user);
    void deleteUser(Long id);
    List<User> getAllUsers();
}
