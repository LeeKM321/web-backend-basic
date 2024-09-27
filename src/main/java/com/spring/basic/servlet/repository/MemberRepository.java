package com.spring.basic.servlet.repository;

import com.spring.basic.servlet.domain.Member;

import java.util.List;

// 추상화된 역할을 명세 (기능은 구현체가 알아서 구현할 것.)
public interface MemberRepository {

    void save(Member member);

    List<Member> getList();

    void delete(String id);

}
