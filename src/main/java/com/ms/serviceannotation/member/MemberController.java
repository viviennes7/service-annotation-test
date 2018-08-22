package com.ms.serviceannotation.member;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@ResponseBody
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    public MemberController(MemberService memberService, MemberRepository memberRepository) {
        this.memberService = memberService;
        this.memberRepository = memberRepository;
    }

    /*
     * 굳이 생성안해도 ServiceAnnotationApplication에서 Member 생성해줍니다
     * */
    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return this.memberService.createMember(member);
    }

    @PutMapping("/{id}/age/{age}")
    public Member updateAge(@PathVariable Long id, @PathVariable int age) {
        return this.memberService.updateAge(id, age);
    }

    @GetMapping("/{id}")
    public Member getMember(@PathVariable Long id) {
        return this.memberRepository.findOne(id);
    }
}
