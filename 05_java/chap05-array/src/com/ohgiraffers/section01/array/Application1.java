package com.ohgiraffers.section01.array;

public class Application1 {
    public static void main(String[] args) {

        /*
        * 배열이란?
        * 동일한 자료형의 묶음(연속된 메모리 공간에 값을 저장하고 사용하기 위한 용도)이다.
        * 배열은 heap 영역에 new 연산자를 이용하여 할당한다.
        * */

        // 1. 배열을 사용하지 않았을 때
        int score1 = 80;
        int score2 = 90;
        int score3 = 75;
        int score4 = 95;
        int score5 = 100;

        int sumOfScores = score1 + score2 + score3 + score4 + score5;
        double avgOfScores = sumOfScores / 5.0;

        System.out.println("합계" + sumOfScores);
        System.out.println("평균" + avgOfScores);

        // 2. 배열을 사용하는 경우

        /* 배열의 선언 및 할당 */
        int[] scores = new int[5];   // 5개의 int를 담을 수 있는 배열 생성

        /* 배열의 각 공간(인덱스)에 값을 대입 */
        scores[0] = 80;
        scores[1] = 90;
        scores[2] = 70;
        scores[3] = 95;
        scores[4] = 100;

        /* 반복문을 이용한 연속 처리 */
        int sum2 = 0;
        for(int i = 0; i < scores.length; i++) {    // scores.length : 배열의 길이(크기)
            sum2 += scores[i];
        }

        double avg2 = sum2 / (double) scores.length;

        System.out.println("합계" + sum2);
        System.out.println("평균" + avg2);
    }
}
