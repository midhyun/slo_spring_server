package slo.slo_spring_server.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import slo.slo_spring_server.domain.user.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    Security
    User findByUsername(String username);
//    Oauth
    Optional<User> findByEmail(String email);
//    User GET
    User findByNickname(String nickname);

//    duplicate validation
    boolean existsByUsername(String username);
    boolean existsByNickname(String nickname);
    boolean existsByEmail(String email);
}