package com.ohgiraffers.springdatajpa.menu.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 요청용 DTO
@Getter
@Setter
@ToString
@NoArgsConstructor
public class MenuRequestDTO {

    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderableStatus;
}
