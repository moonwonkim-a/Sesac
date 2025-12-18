package com.ohgiraffers.section01.conditional;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Application app = new Application();

//        app.testSimpleIf();
//        app.testNestedIf();
//        app.testSimpleIfElse();
//        app.testGradeCalculation();
        app.testSimpleSwitch();
    }


    // 1. if문
    public void testSimpleIf() {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자 한 개를 입력하세요 : ");
        int num = sc.nextInt();

        if (num % 2 == 0) {
            // 위의 조건이 true일 때만 이 블록이 실행된다.
            System.out.println("입력하신 숫자는 짝수입니다.");
        }
        System.out.println("프로그램을 종료합니다.");
    }

    // 2. 중첩 if문과 논리 연산자
    public void testNestedIf() {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 한 개 입력하세요: ");
        int num = sc.nextInt();

        // 첫 번째 조건: 양수인가?
        if( num > 0 ) {
            // 두 번째 조건: 짝수인가?
            if (num % 2 == 0) {
                System.out.println("입력하신" + num + "은(는) 양수이면서 짝수입니다.");
            }
        }
        // 논리 연산자(&&)를 쓰는 것이 훨씬 간결하다.
        if (num > 0 && num % 2 == 0) {
            System.out.println("입력하신 숫자는 양수이면서 짝수입니다.");
        }
    }

    // 3. if-else문
    public void testSimpleIfElse() {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 하나 입력하세요 : ");
        int num = sc.nextInt();

        // 홀수인가?
        if (num % 2 != 0) {
            System.out.println("입력하신 정수는 홀수입니다.");
        } else {
            // if 조건문이 false일 때
            System.out.println("입력하신 정수는 짝수입니다.");
        }
    }

    // 4. if-else-if 문
    public void testGradeCalculation() {

        Scanner sc = new Scanner(System.in);
        System.out.print("학생의 점수를 입력하세요: ");
        int point = sc.nextInt();
        String grade = "";

        // 조건의 순서가 중요하다! 가장 좁은 범위(높은 점수)부터 검사해야 한다.
        if (point >= 90) {
            grade = "A";
            if (point >= 95) { grade += "+"; }
        } else if (point >= 80) {
            grade = "B";
            if (point >= 85) { grade += "+"; }
        } else if (point >= 70) {
            grade = "C";
            if (point >= 75) { grade += "+"; }
        } else if (point >= 60) {
            grade = "D";
            if (point >= 65) { grade += "+"; }
        } else {
            grade = "F";
        }
        System.out.println("점수는 " + point + "이고, 등급은 " + grade + "입니다.");
    }

    // 5. switch문
    public void testSimpleSwitch() {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 정수 입력 : ");
        int first = sc.nextInt();
        System.out.print("두 번째 정수 입력 : ");
        int second = sc.nextInt();
        System.out.print("연산 기호 입력(+, -, *, /, %) :");
//        char op = sc.nextLine().charAt(0);    // 버퍼에 남아있는 개행문자를 만나 읽기 종료되어 에러 발생!
        char op = sc.next().charAt(0); // next()는 버퍼에 남아있는 \n(개행문자)를 무시하고 다음 단어를 읽는다.

        int result = 0;
        switch (op) {
            case '+':
                result = first + second;
                break; // 여기서 멈춰라!
            case '-':
                result = first - second;
                break;
            case '*':
                result = first * second;
                break;
            case '/':
                result = first / second;
                break;
            case '%':
                result = first % second;
                break;
            default:    // 위의 case에 아무것도 해당되지 않을 때
                System.out.println("잘못된 연산 기호를 입력하셨습니다.");
                return; // 메소드 종료
        }
        System.out.println(first + " " + op + " " + second + " = " + result);

    }
}
