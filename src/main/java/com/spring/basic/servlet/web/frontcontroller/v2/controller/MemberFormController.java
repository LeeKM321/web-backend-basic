package com.spring.basic.servlet.web.frontcontroller.v2.controller;

import com.spring.basic.servlet.web.frontcontroller.MyViewResolver;
import com.spring.basic.servlet.web.frontcontroller.v1.ControllerV1;
import com.spring.basic.servlet.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberFormController implements ControllerV2 {

    @Override
    public MyViewResolver process(HttpServletRequest request,
                        HttpServletResponse response) throws ServletException, IOException {
        return new MyViewResolver("/WEB-INF/views/member/join-form.jsp");
    }

}











