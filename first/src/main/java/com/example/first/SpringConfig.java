package com.example.first;


import com.example.first.repository.JpaMemberRepository;
import com.example.first.repository.MemberRepository;
import com.example.first.repository.MemoryMemberRepository;
import com.example.first.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;


//자바 코드로 직접 스프링 빈 등록
//컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔 사용
//정형화되지 않거나 상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로 등록
@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

//    private EntityManager em;

//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public JpaMemberRepository memberRepository() {
//        return new JpaMemberRepository(em);
//    }
}
