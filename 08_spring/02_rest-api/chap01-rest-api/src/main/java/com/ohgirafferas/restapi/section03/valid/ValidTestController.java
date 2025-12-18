package com.ohgirafferas.restapi.section03.valid;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/valid")
public class ValidTestController {

    @GetMapping("/users/{userNo}")
    public ResponseEntity<Void> findUserByNo() throws UserNotFoundException {
        boolean check = true;
        if(check) {
            throw new UserNotFoundException("회원 정보를 찾을 수 없습니다.");
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/users")
    // @Valid : user 객체가 들어오면, DTO에 정의된 유효성 규칙에 맞는지 검사
    public ResponseEntity<Void> registUser(@Valid @RequestBody UserDTO user){

        return ResponseEntity
                .created(URI.create("/valid/users/1"))
                .build();
    }

}
