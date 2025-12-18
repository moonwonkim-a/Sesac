package com.ohgiraffers.section03.dto;

import javax.swing.*;

public class MemberDTO {

    private int number;
    private String name;
    private int age;
    private char gender;
    private double height;
    private double weight;
    private boolean isActivated;

    public void setNumber(int number) {
        this.number = number;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }
    public void setActivated(boolean isActivated) {
        this.isActivated = isActivated;
    }
    public int getNumber() {
        return number;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public char getGender() {
        return gender;
    }
    public double getHeight() {
        return height;
    }
    public double getWeight() {
        return weight;
    }
    // boolean 타입의 Getter는 'is'로 시작하는 것이 관례이다.
    public boolean isActivated() {
        return isActivated;
    }
}
