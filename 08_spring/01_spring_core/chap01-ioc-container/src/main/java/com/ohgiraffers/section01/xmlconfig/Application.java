package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        // 1. XML 설계도를 읽어서 IoC 컨테이너(스프링 컨테이너)를 생성한다.
        ApplicationContext context = new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml"); // resources 하위부터 입력

        // 2. 컨테이너에게 'member' 라는 이름으로 등록한 bean을 달라고 요청
        // bean의 id를 이용해서 가져오는 방법
//        MemberDTO member = (MemberDTO)context.getBean("member");

        // bean의 클래스 메타 정보를 전달하여 가져오는 방법
//        MemberDTO member = context.getBean(MemberDTO.class);

        // 두가지 다 전달해서 가져오는 방법
        MemberDTO member = context.getBean("member", MemberDTO.class);

        System.out.println(member);

    }
}
