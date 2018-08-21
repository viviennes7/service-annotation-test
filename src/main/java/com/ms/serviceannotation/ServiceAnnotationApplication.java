package com.ms.serviceannotation;

import com.ms.serviceannotation.member.Member;
import com.ms.serviceannotation.member.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ServiceAnnotationApplication implements CommandLineRunner {
	private final MemberService memberService;

	public ServiceAnnotationApplication(MemberService memberService) {
		this.memberService = memberService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceAnnotationApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Member member = new Member(null, "민수", 26);
		Member minsoo = this.memberService.createMember(member);
		log.info("Member 생성 ::: {}", minsoo);
	}
}
