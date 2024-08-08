package slo.slo_spring_server.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import slo.slo_spring_server.domain.user.Users;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
//    Security
    Optional<Users> findByUsername(String username);
//    Oauth
    Optional<Users> findByEmail(String email);
//    user GET
    Users findByNickname(String nickname);

//    duplicate validation
    boolean existsByUsername(String username);
    boolean existsByNickname(String nickname);
    boolean existsByEmail(String email);
}