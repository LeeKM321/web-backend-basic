package com.spring.basic.servlet.web.frontcontroller.v3.controller;

import com.spring.basic.servlet.domain.Member;
import com.spring.basic.servlet.repository.MemberRepositoryImpl;
import com.spring.basic.servlet.web.frontcontroller.ModelView;
import com.spring.basic.servlet.web.frontcontroller.MyViewResolver;
import com.spring.basic.servlet.web.frontcontroller.v2.ControllerV2;
import com.spring.basic.servlet.web.frontcontroller.v3.ControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class MemberJoinController implements ControllerV3 {

    private MemberRepositoryImpl repository = MemberRepositoryImpl.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap)  {

        String id = paramMap.get("id");
        String pw = paramMap.get("pw");
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(id, pw, username, age);
        repository.save(member);

        ModelView mv = new ModelView("member/join-result");
        mv.addAttribute("member", member);
        return mv;

//        return new MyViewResolver("/WEB-INF/views/member/join-result.jsp");
    }


}














