package com.ohgiraffers.section01.array;

import javax.script.ScriptContext;
import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {

        /* 5명의 자바 점수를 정수로 입력받아 합계와 평균을 실수로 구하는 프로그램을 만들어보자 */

        // 1. 5명의 자바 점수를 저장할 배열을 할당한다.
        int[] scores = new int[5];

        // 2. 키보드로 점수를 입력받는다.
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < scores.length; i++){
            System.out.print((i+1) + "번 째 학생의 자바 점수를 입력해 주세요 : ");
            scores[i] = sc.nextInt();
        }

        // 3. 합계와 평균을 계산한다.
        double sum = 0.0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }

        double avg = sum / scores.length;

        // 4. 합계와 평균 출력하기
        System.out.println("합계 : " + sum);
        System.out.println("평균 : " + avg);
    }
}
