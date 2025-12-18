package com.ohgirafferas.mapping.test;

import java.util.Date;

public class MemberDTO {

    private int memberNume;
    private String id;
    private String pwd;
    private String email;
    private String adress;
    private MemberEnum enume;
    private Date enrollDate;

    public MemberDTO() {
    }

    public MemberDTO(int memberNume, String id, String pwd, String email, String adress, MemberEnum enume, Date enrollDate) {
        this.memberNume = memberNume;
        this.id = id;
        this.pwd = pwd;
        this.email = email;
        this.adress = adress;
        this.enume = enume;
        this.enrollDate = enrollDate;
    }

    public int getMemberNume() {
        return memberNume;
    }

    public void setMemberNume(int memberNume) {
        this.memberNume = memberNume;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public MemberEnum getEnume() {
        return enume;
    }

    public void setEnume(MemberEnum enume) {
        this.enume = enume;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberNume=" + memberNume +
                ", id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", email='" + email + '\'' +
                ", adress='" + adress + '\'' +
                ", enume=" + enume +
                ", enrollDate=" + enrollDate +
                '}';
    }
}
