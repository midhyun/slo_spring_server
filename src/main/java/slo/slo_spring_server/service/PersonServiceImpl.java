package slo.slo_spring_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import slo.slo_spring_server.domain.user.User;
import slo.slo_spring_server.repository.PersonRepository;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public User createPerson(User user) {
        return personRepository.save(user);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public List<User> getAllPersons() {
        return personRepository.findAll();
    }
}
