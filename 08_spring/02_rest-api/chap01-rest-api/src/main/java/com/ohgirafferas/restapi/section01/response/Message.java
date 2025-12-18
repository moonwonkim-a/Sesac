package com.ohgirafferas.restapi.section01.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor // 모든 매개변수있는 생성자 어노테이션
@NoArgsConstructor  // 기본 생성자
public class Message {

    private int httpStatusCode;
    private String message;

}
