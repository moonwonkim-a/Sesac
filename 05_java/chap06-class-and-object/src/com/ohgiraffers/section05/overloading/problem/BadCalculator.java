package com.ohgiraffers.section05.overloading.problem;

public class BadCalculator {

    public int addTwoInts(int num1, int num2) {
        return num1 + num2;
    }

    public double addTwoDoubles(double num1, double num2) {
        return num1 + num2;
    }

    public int addThreeInts(int num1, int num2, int num3) {
        return num1 + num2 + num3;
    }
}
