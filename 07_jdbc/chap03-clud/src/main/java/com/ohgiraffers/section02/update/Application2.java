package com.ohgiraffers.section02.update;

import com.ohgiraffers.model.dto.MenuDTO;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("변경할 메뉴 번호 : ");
        int menuCode = sc.nextInt();
        System.out.print("변경할 메뉴 명 : ");
        sc.nextLine();
        String menuName = sc.nextLine();
        System.out.print("변경할 메뉴 가격 : ");
        int menuPrice = sc.nextInt();

        MenuDTO changedMenu = new MenuDTO();

        changedMenu.setMenuCode(menuCode);
        changedMenu.setMenuName(menuName);
        changedMenu.setMenuPrice(menuPrice);

        UpdateController updateController = new UpdateController();

        int result = updateController.updateMenu(changedMenu);
        System.out.println(result);
    }
}
