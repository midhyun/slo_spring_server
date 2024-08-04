package slo.slo_spring_server.service;

import slo.slo_spring_server.domain.user.User;

import java.util.List;


public interface PersonService {
    User createPerson(User user);
    void deletePerson(Long id);
    List<User> getAllPersons();
}
