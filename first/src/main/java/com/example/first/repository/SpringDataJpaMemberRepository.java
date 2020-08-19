package com.example.first.repository;

import com.example.first.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//인터페이스가 implements => extends
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //JPOL select m from Member m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
