package slo.slo_spring_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import slo.slo_spring_server.domain.user.User;
import slo.slo_spring_server.dto.UserDTO;
import slo.slo_spring_server.repository.user.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder encoder;

    @Override
    @Transactional
    public void createUser(UserDTO.Request dto) {
        dto.setPassword(encoder.encode(dto.getPassword()));
        userRepository.save(dto.toEntity());
    }

    @Override
    @Transactional
    public void updateUser(UserDTO.Request dto) {
        User user = userRepository.findById(dto.getId()).orElseThrow(() -> new IllegalArgumentException("해당 회원이 존재하지 않습니다."));

        String encPassword = encoder.encode(dto.getPassword());
        user.modifyInfo(encPassword, dto.getNickname(), dto.getWeight(), dto.getHeight(), dto.getAge());
    }

//    회원가입 유효성 검사 에러 핸들링
    @Transactional(readOnly = true)
    public Map<String, String> validatedHandling(Errors errors) {
        Map<String, String> validatorResult = new HashMap<>();

//        검사 실패 목록 리턴
        for (FieldError error : errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }

        return validatorResult;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
