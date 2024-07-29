package slo.slo_spring_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import slo.slo_spring_server.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}