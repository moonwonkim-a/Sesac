package com.ohgiraffers.section02;

import com.ohgiraffers.common.Account;
import com.ohgiraffers.common.MemberDTO;
import com.ohgiraffers.common.PersonalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean
    public Account accountGenerator(){
        return new PersonalAccount(20,"110-222-999999");
    }

    @Bean
    public MemberDTO memberGenerator(){
        /* 생성자 주입 방법 */
//        return new MemberDTO(1,"별",accountGenerator());

        /* setter 주입 방법 */
        MemberDTO member = new MemberDTO();
        member.setSequence(1);
        member.setName("우주");
        member.setPersonalAccount(accountGenerator());

        return member;
    }
}
