package com.ohgiraffers.springdatajpa.menu.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "menu")
@Table(name = "tbl_menu")
@Getter
// JPA 스펙상 기본생성자는 필수이지만 아무나 빈 객체를 만들 수 없도록 엑세스 레벨 설정(access = AccessLevel.접근제한자)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuCode;
    private String menuName;
    private int menuPrice;
    @ManyToOne
    @JoinColumn(name = "categoryCode")
    private Category category;
    private String orderableStatus;

    public void modify(String menuName, int menuPrice, Category category, String orderableStatus){
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.category = category;
        this.orderableStatus = orderableStatus;
    }

    public void modifyMenuPrice(int menuPrice){
        this.menuPrice = menuPrice;
    }

    public void modifyMenuName(String menuName){
        this.menuName = menuName;
    }
}
