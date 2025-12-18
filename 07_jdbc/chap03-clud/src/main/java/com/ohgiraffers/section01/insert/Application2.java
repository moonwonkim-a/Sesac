package com.ohgiraffers.section01.insert;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {

        /* 1. 메뉴의 이름, 가격, 카테고리 코드, 판매 여부를 입력 받기(Scanner 이용) */
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴의 이름을 입력하세요 : ");
        String menuName = sc.nextLine();
        System.out.print("메뉴의 가격을 입력하세요 : ");
        int menuPrice = sc.nextInt();
        System.out.print("메뉴의 카테고리 코드를 입력하세요 : ");
        int categoryCode = sc.nextInt();
        System.out.print("메뉴의 판매 여부를 입력하세요 : ");
        sc.nextLine();
        String orderableStatus = sc.nextLine();
        /* 2. MenuDTO 객체를 생성하여 입력받은 값으로 setting */
        MenuDTO menu = new MenuDTO();

        menu.setMenuName(menuName);
        menu.setMenuPrice(menuPrice);
        menu.setCategoryCode(categoryCode);
        menu.setOrderableStatus(orderableStatus);

        /* 3. InsertController의 insertMenu() 메소드 호출 */
        InsertController insertController = new InsertController();

        int result = insertController.insertMenu(menu);
        System.out.println(result);
        /* 4. insert 결과에 따라 성공이면 '메뉴 등록 성공' 출력, 실패이면 '메뉴 등록 실패' 출력 */
    }
}
