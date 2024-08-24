package slo.slo_spring_server.repository;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import slo.slo_spring_server.domain.user.Gender;
import slo.slo_spring_server.domain.user.Status;
import slo.slo_spring_server.domain.user.User;
import slo.slo_spring_server.dto.UserDTO;
import slo.slo_spring_server.repository.user.UserRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DataJpaTest
@RequiredArgsConstructor
@AutoConfigureMockMvc
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("유저생성")
    void 유저생성() {
        // given
        UserDTO.Request user1 = UserDTO.Request.builder()
                .username("test")
                .password("test")
                .nickname("test")
                .email("test@test.com")
                .gender(Gender.MALE)
                .weight(60)
                .height(170)
                .age(20)
                .build();
        UserDTO.Request user2 = UserDTO.Request.builder()
                .username("test2")
                .password("test")
                .nickname("test2")
                .email("test2@test.com")
                .gender(Gender.MALE)
                .weight(60)
                .height(170)
                .age(20)
                .build();


        // when
        User result1 = userRepository.save(user1.toEntity());
        User result2 = userRepository.save(user2.toEntity());

        // then
        Assertions.assertThat(result1.getUsername()).isEqualTo(user1.getUsername());
        Assertions.assertThat(result2.getUsername()).isEqualTo(user2.getUsername());
    }

    @Test
    void 유저중복체크() {
        // given
        UserDTO.Request user1 = UserDTO.Request.builder()
                .username("test")
                .password("test")
                .nickname("test")
                .email("test@test.com")
                .gender(Gender.MALE)
                .weight(60)
                .height(170)
                .age(20)
                .build();

        //when
        User result1 = userRepository.save(user1.toEntity());
        boolean isExist = userRepository.existsByUsername("test");

        Assertions.assertThat(isExist).isTrue();
    }

    @Test
    void Enum타입_테스트() {
        Gender gender = Gender.MALE;
        Status status = Status.ACT;

        System.out.println(gender);
        System.out.println(status);
    }
}