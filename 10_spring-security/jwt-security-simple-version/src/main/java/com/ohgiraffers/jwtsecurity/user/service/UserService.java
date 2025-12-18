package com.ohgiraffers.jwtsecurity.user.service;

import com.ohgiraffers.jwtsecurity.auth.model.dto.LoginDTO;
import com.ohgiraffers.jwtsecurity.auth.model.dto.SignupDTO;
import com.ohgiraffers.jwtsecurity.auth.model.dto.TokenDTO;
import com.ohgiraffers.jwtsecurity.common.UserRole;
import com.ohgiraffers.jwtsecurity.common.utils.TokenUtils;
import com.ohgiraffers.jwtsecurity.user.entity.User;
import com.ohgiraffers.jwtsecurity.user.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 회원가입
    @Transactional
    public User signup(SignupDTO signupDTO) {
        User user = new User();
        user.setUserId(signupDTO.getUserId());
        user.setUserName(signupDTO.getUserName());
        user.setUserEmail(signupDTO.getUserEmail());
        user.setUserPass(passwordEncoder.encode(signupDTO.getUserPass()));

        // 권한 설정 로직
        if (signupDTO.getRole() != null && !signupDTO.getRole().isEmpty()) {
            try {
                user.setRole(UserRole.valueOf(signupDTO.getRole()));
            } catch (IllegalArgumentException e) {
                user.setRole(UserRole.USER);
            }
        } else {
            user.setRole(UserRole.USER);
        }

        user.setState("Y");
        return userRepository.save(user);
    }

    // 로그인
    public TokenDTO login(LoginDTO loginDTO) {

        // 1. 아이디 조회
        User user = userRepository.findByUserId(loginDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 아이디 입니다."));

        // 2. 비밀번호 검증
        if (!passwordEncoder.matches(loginDTO.getUserPass(), user.getUserPass())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        // 3. 토큰 발급
        String token = TokenUtils.generateJwtToken(user);

        // 토큰 만료시간 계산
        Long expireTime = System.currentTimeMillis() + TokenUtils.getTokenValidateTime();

        // 문자열을 DTO에 담아서 반환 ("Bearer" 타입 명시)
        return new TokenDTO("Bearer", token, expireTime);
    }
}