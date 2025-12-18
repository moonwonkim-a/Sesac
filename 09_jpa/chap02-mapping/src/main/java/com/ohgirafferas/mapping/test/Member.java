package com.ohgirafferas.mapping.test;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "entityDetail")
@Table(name = "tbl_detail")
public class Member {

    @Id
    @Column(name = "member_Num")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberNum;

    @Column(name = "id")
    private String id;

    @Column(name = "password")
    private String pwd;

    @Column(name = "email")
    private String email;

    @Column(name = "adress")
    private String adress;

    @Column(name = "member_enum")
    @Enumerated(EnumType.ORDINAL)
    private MemberEnum memberEnumenum;

    @Column(name = "enroll_Date")
    private Date enrollDate;

    protected Member() {}

    public Member(int memberNum, String id, String pwd, String email, String adress, MemberEnum memberEnumenum, Date enrollDate) {
        this.memberNum = memberNum;
        this.id = id;
        this.pwd = pwd;
        this.email = email;
        this.adress = adress;
        this.memberEnumenum = memberEnumenum;
        this.enrollDate = enrollDate;
    }

    public int getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(int memberNum) {
        this.memberNum = memberNum;
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

    public MemberEnum getMemberEnumenum() {
        return memberEnumenum;
    }

    public void setMemberEnumenum(MemberEnum memberEnumenum) {
        this.memberEnumenum = memberEnumenum;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberNum=" + memberNum +
                ", id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", email='" + email + '\'' +
                ", adress='" + adress + '\'' +
                ", memberEnumenum=" + memberEnumenum +
                ", enrollDate=" + enrollDate +
                '}';
    }
}
