package com.spring.basic.servlet.web.frontcontroller.v2.controller;

import com.spring.basic.servlet.domain.Member;
import com.spring.basic.servlet.repository.MemberRepositoryImpl;
import com.spring.basic.servlet.web.frontcontroller.MyViewResolver;
import com.spring.basic.servlet.web.frontcontroller.v1.ControllerV1;
import com.spring.basic.servlet.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class MemberListController implements ControllerV2 {

    private MemberRepositoryImpl repository = MemberRepositoryImpl.getInstance();

    @Override
    public MyViewResolver process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Member> memberList
                = repository.getList();

        request.setAttribute("mList", memberList);

        return new MyViewResolver("/WEB-INF/views/member/members.jsp");
    }
}











