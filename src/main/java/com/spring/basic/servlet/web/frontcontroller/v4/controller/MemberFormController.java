package com.spring.basic.servlet.web.frontcontroller.v4.controller;

import com.spring.basic.servlet.web.frontcontroller.Model;
import com.spring.basic.servlet.web.frontcontroller.ModelView;
import com.spring.basic.servlet.web.frontcontroller.v3.ControllerV3;
import com.spring.basic.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberFormController implements ControllerV4 {

    @Override
    public String process(Map<String, String> paramMap, Model model) {
        return "member/join-form";
    }
}











