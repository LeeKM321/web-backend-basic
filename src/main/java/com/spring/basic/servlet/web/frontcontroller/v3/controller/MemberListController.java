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
import java.util.List;
import java.util.Map;

public class MemberListController implements ControllerV3 {

    private MemberRepositoryImpl repository = MemberRepositoryImpl.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {

        List<Member> memberList
                = repository.getList();

        ModelView mv = new ModelView("member/members");
        mv.addAttribute("mList", memberList);
        return mv;

    }
}











