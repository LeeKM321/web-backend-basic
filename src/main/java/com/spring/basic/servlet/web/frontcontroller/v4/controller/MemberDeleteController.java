package com.spring.basic.servlet.web.frontcontroller.v4.controller;

import com.spring.basic.servlet.repository.MemberRepositoryImpl;
import com.spring.basic.servlet.web.frontcontroller.Model;
import com.spring.basic.servlet.web.frontcontroller.ModelView;
import com.spring.basic.servlet.web.frontcontroller.v3.ControllerV3;
import com.spring.basic.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberDeleteController implements ControllerV4 {

    MemberRepositoryImpl repository = MemberRepositoryImpl.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Model model) {
        String delTarget = paramMap.get("id");
        repository.delete(delTarget);

        return "redirect:/front-controller/v3/members";
    }


}












