package com.ohgirafferas.mapping.test;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    @Transactional
    public void createMember(MemberDTO m) {

        Member member = new Member(
                m.getMemberNume(),
                m.getId(),
                m.getPwd(),
                m.getEmail(),
                m.getAdress(),
                m.getEnume(),
                m.getEnrollDate()
        );

        memberRepository.save(member);
    }

}
