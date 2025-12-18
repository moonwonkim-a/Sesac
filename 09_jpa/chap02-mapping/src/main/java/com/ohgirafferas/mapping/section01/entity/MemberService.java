package com.ohgirafferas.mapping.section01.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Transactional  // 자동으로 메소드가 작동되면 트랜젝션이 시작되고 commit 된다.
    public void registMember(MemberRegistDTO newMember){

        Member member = new Member(
                newMember.getMemberId(),
                newMember.getMemberPwd(),
                newMember.getMemberName(),
                newMember.getPhone(),
                newMember.getAddress(),
                newMember.getEnrollDate(),
                newMember.getMemberRole(),
                newMember.getStatus()
        );

        memberRepository.save(member);
    }
    @Transactional
    public String registMemberAndFindName(MemberRegistDTO newMember){

        registMember(newMember);

        return memberRepository.findNameById(newMember.getMemberId());
    }
}
