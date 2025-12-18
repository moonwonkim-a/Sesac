package com.ohgiraffers.jwtsecurity.user.service;

import com.ohgiraffers.jwtsecurity.auth.model.dto.SignupDTO;
import com.ohgiraffers.jwtsecurity.common.UserRole;
import com.ohgiraffers.jwtsecurity.user.entity.User;
import com.ohgiraffers.jwtsecurity.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Transactional
    public User signup(SignupDTO signupDTO) {
        // 1. User 엔티티 생성 (DTO -> Entity 변환)
        User user = new User();
        user.setUserId(signupDTO.getUserId());
        user.setUserName(signupDTO.getUserName());
        user.setUserEmail(signupDTO.getUserEmail());

        // 2. 비밀번호 암호화
        user.setUserPass(bCryptPasswordEncoder.encode(signupDTO.getUserPass()));

        // 3. 권한 설정 로직 수정
        // 요청에 role이 있으면 그걸 쓰고, 없으면 기본값 USER로 설정
        if (signupDTO.getRole() != null && !signupDTO.getRole().isEmpty()) {
            // String("ADMIN") -> Enum(UserRole.ADMIN)으로 변환
            try {
                user.setRole(UserRole.valueOf(signupDTO.getRole()));
            } catch (IllegalArgumentException e) {
                // 이상한 권한(SUPER_MAN 등)이 들어오면 그냥 USER로 설정
                user.setRole(UserRole.USER);
            }
        } else {
            user.setRole(UserRole.USER);
        }

        // 4. 저장 및 반환
        return userRepository.save(user);
    }

    public Optional<User> findUser(String id){
        Optional<User> user = userRepository.findByUserId(id);

        /*
        * 별도의 검증 로직 작성
        * */

        return user;
    }
}
