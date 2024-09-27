package com.spring.basic.servlet.web.frontcontroller.v4.controller;

import com.spring.basic.servlet.domain.Member;
import com.spring.basic.servlet.repository.MemberRepositoryImpl;
import com.spring.basic.servlet.web.frontcontroller.Model;
import com.spring.basic.servlet.web.frontcontroller.ModelView;
import com.spring.basic.servlet.web.frontcontroller.v3.ControllerV3;
import com.spring.basic.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.List;
import java.util.Map;

public class MemberListController implements ControllerV4 {

    private MemberRepositoryImpl repository = MemberRepositoryImpl.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Model model) {

        List<Member> memberList
                = repository.getList();

        model.addAttribute("mList", memberList);
        return "member/members";

    }
}











