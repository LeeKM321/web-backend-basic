package com.spring.basic.servlet.web.frontcontroller.v3.controller;

import com.spring.basic.servlet.domain.Member;
import com.spring.basic.servlet.repository.MemberRepositoryImpl;
import com.spring.basic.servlet.web.frontcontroller.ModelView;
import com.spring.basic.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberDeleteController implements ControllerV3 {

    MemberRepositoryImpl repository = MemberRepositoryImpl.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        String delTarget = paramMap.get("id");
        repository.delete(delTarget);

        return new ModelView("redirect:/front-controller/v3/members");
    }


}












