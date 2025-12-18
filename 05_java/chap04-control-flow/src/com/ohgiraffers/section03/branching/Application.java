package com.ohgiraffers.section03.branching;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
//        app.simpleBreak();
//        app.nestedBreak();
//        app.simpleContinue();
//        app.nestedContinue();
        app.handleNestedBreak();
    }

    public void simpleBreak() {

        int sum = 0;
        int i = 1;

        while(true) {
            sum += i;
            System.out.println(i + "를 더했다. 현재 합계 : " + sum);

            // 만약 i가 10이 되면 이라는 탈출 조건을 만든다.
            if (i == 10) {
                System.out.println("i가 10이 되어 break로 반복문을 탈출한다!");
                break;  // 가장 가까운 반복문을 즉시 중단하고 탈출한다.
            }
            i++;    // break 조건이 아니면 i를 1증가시키고 다시 반복
        }
        System.out.println("최종 합은 " + sum + "입니다.");
    }

    // break는 자신을 감싸고 있는 '가장 가까운' 반복문 하나만 탈출한다.
    public void nestedBreak() {
        for(int dan = 2; dan < 10; dan++) {
            System.out.println("---" + dan + "단 시작 ---");
            for (int su = 1; su < 10; su++) {
                if(su > 5) {
                    break;  // 안쪽 for문을 탈출하라는 신호
                }
                System.out.println(dan + " * " + su + " = " + dan * su);
            }
        }
    }

    public void simpleContinue() {
        System.out.println("1부터 100사이의 4와 5의 공배수(20의 배수)만 출력합니다.");

         for(int i = 1; i <= 100; i++) {
             // 4의 배수이면서 동시에 5의 배수가 아니라면
             if(!(i % 4 == 0 && i % 5 == 0)) {
                 continue;  // 이번 반복 회차를 건너뛰고 증감식으로 이동한다.
             }
             System.out.println(i);
         }
    }

    public void nestedContinue() {
        // 구구단을 출력하되, 각 단에서 '홀수' 곱만 출력하는 continue 예제
        for(int dan = 2; dan < 10; dan++) {
            System.out.println("---" + dan + "단 시작 ---");
            for (int su = 1; su < 10; su++) {
                // 만약 곱하는 수(su)가 짝수라면,
                if(su % 2 == 0) {
                    continue;   // 이번 회차(su)는 건너뛰고, 바로 다음 숫자인 su++로 이동한다.
                }
                System.out.println(dan + " * " + su + " = " + dan * su);
            }
        }
    }

    public void handleNestedBreak() {
        // 코드의 흐름을 예측하기 어려워 거의 사용하지 않는 '안티 패턴'이다.
        ohgiraffers:    // 바깥쪽 for문에 이름표를 붙임
        for(int dan = 2; dan < 10; dan++) {
            for(int su = 1; su < 10; su++) {
                if(dan == 3 && su == 5) {
                    break ohgiraffers;  // 이름표가 붙은 반복문 전체를 탈출
                }
                System.out.println(dan + " * " + su + " = " + dan * su);
            }
            System.out.println();
        }

        System.out.println("Flag 변수 사용");

        // 코드가 순차적으로 흘러가서 직관적이고 안정적이다.
        boolean isBreak = false;    // 탈출 신호를 보낼 Flag 변수(깃발)

        for(int dan = 2; dan < 10; dan++) {
            for(int su = 1; su < 10; su++) {
                if(dan == 3 && su == 5) {
                    isBreak = true; // 탈출 신호를 보냄
                    break ;  // 우선 가장 가까운 반복문 탈출
                }
                System.out.println(dan + " * " + su + " = " + dan * su);
            }
            // 안쪽 반복문이 끝난 직후, Flag 변수를 확인한다.
            if (isBreak) {
                break;  // 탈출신호가 있다면 바깥쪽 반복문도 탈출한다.
            }
            System.out.println();
        }
    }

}
