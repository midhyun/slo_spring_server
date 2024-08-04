package slo.slo_spring_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import slo.slo_spring_server.domain.user.User;

@Repository
public interface PersonRepository extends JpaRepository<User, Long> {

}