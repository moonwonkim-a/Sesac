package com.ohgiraffers.section03.filterstream.dto;

import java.io.Serializable;

/* 객체를 입출력 하기 위해 반드시 직렬화 처리를 해야 한다.
* 직렬화 대상 클래스에 Serializable 인터페이스만 구현하면 데이터를 직렬화 처리한다. */
public class MemberDTO implements Serializable {

    private String id;
    /* transient : 특정 필드를 직렬화에서 제외하기 위한 키워드 */
    private /*transient*/ String pwd;
    private String name;
    private int age;
    private double point;

    public MemberDTO() {
    }

    public MemberDTO(String id, String pwd, String name, int age, double point) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.age = age;
        this.point = point;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", point=" + point +
                '}';
    }
}
