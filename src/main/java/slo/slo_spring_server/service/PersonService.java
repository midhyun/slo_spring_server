package slo.slo_spring_server.service;

import slo.slo_spring_server.domain.Person;

import java.util.List;


public interface PersonService {
    Person createPerson(Person person);
    void deletePerson(Long id);
    List<Person> getAllPersons();
}
