package com.ms.serviceannotation.member;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(Member member) {
        return this.memberRepository.save(member);
    }

    @Transactional
    public Member updateAge(Long id, int age) {
        Member member = this.memberRepository.findOne(id);
        member.setAge(age);
        this.memberRepository.save(member);

        if (1 == 1)
            throw new RuntimeException();

        return member;
    }
}
