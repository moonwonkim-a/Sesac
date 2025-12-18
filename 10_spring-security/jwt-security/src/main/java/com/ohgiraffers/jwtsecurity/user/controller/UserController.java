package com.ohgiraffers.jwtsecurity.user.controller;

import com.ohgiraffers.jwtsecurity.auth.model.dto.SignupDTO;
import com.ohgiraffers.jwtsecurity.user.entity.User;
import com.ohgiraffers.jwtsecurity.user.repository.UserRepository;
import com.ohgiraffers.jwtsecurity.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupDTO signupDTO) {

        User registeredUser = userService.signup(signupDTO);

        // 응답 데이터 생성
        Map<String, Object> responseMap = new HashMap<>();

        if (Objects.isNull(registeredUser)) {
            responseMap.put("message", "회원 가입 실패");
            return ResponseEntity.badRequest().body(responseMap); // 400 Error
        } else {
            responseMap.put("message", "회원 가입 성공!");
            responseMap.put("user", registeredUser); // 필요하다면 가입된 정보 리턴
            return ResponseEntity.ok(responseMap); // 200 OK
        }
    }
}
