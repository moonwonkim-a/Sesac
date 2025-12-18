package com.ohgiraffers.jwtsecurity.user.controller;

import com.ohgiraffers.jwtsecurity.auth.model.dto.LoginDTO;
import com.ohgiraffers.jwtsecurity.auth.model.dto.SignupDTO;
import com.ohgiraffers.jwtsecurity.auth.model.dto.TokenDTO;
import com.ohgiraffers.jwtsecurity.common.AuthConstants;
import com.ohgiraffers.jwtsecurity.user.entity.User;
import com.ohgiraffers.jwtsecurity.user.repository.UserRepository;
import com.ohgiraffers.jwtsecurity.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

        Map<String, Object> responseMap = new HashMap<>();
        if (Objects.isNull(registeredUser)) {
            responseMap.put("message", "회원 가입 실패");
            return ResponseEntity.badRequest().body(responseMap);
        } else {
            responseMap.put("message", "회원 가입 성공!");
            responseMap.put("user", registeredUser);
            return ResponseEntity.ok(responseMap);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {

        try {
            TokenDTO tokenDTO = userService.login(loginDTO);

            return ResponseEntity.ok(tokenDTO);

        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
}