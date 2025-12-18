package com.ohgirafferas.restapi.section03.valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice   // 프로젝트 전체의 예외를 관리하는 클래스
public class ExceptionController {

    // UserNotFoundException이 발생하면, 이 메소드가 가로채서 처리함
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserException(UserNotFoundException e) {

        String code = "ERROR_CODE_0000";
        String description = "회원 정보 조회 실패";
        String detail = e.getMessage(); // 예외에 담긴 메세지 사용

        return new ResponseEntity<>(new ErrorResponse(code,description,detail), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodValidException(MethodArgumentNotValidException e){
        String code = "";
        String description = "";
        // getDefaultMessage() : DTO에 적어둔 message가 담겨있다.
        String detail = e.getBindingResult().getFieldError().getDefaultMessage();
        // getCode() : NotNull, NotBlank 등 규칙 이름(?)
        String bindResultCode = e.getBindingResult().getFieldError().getCode();

        switch (bindResultCode){
            case "NotNull" :
                code = "ERROR_CODE_0001";
                description = "필수 값이 누락되었습니다.";
                break;
            case "NotBlank" :
                code = "ERROR_CODE_0002";
                description = "필수 값이 공백입니다.";
                break;
            case "Size" :
                code = "ERROR_CODE_0003";
                description = "글자 수를 확인하세요";
                break;
        }
        return new ResponseEntity<>(new ErrorResponse(code, description, detail), HttpStatus.BAD_REQUEST);
    }

}
