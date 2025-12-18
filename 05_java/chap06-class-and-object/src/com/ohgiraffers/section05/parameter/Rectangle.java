package com.ohgiraffers.section05.parameter;

public class Rectangle {

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void printInfo() {
        System.out.println("사각형의 너비는 " + this.width + "이고, 높이는 " + this.height + "입니다.");
    }
}
