package com.spring.basic.servlet.web.frontcontroller.v1.controller;

import com.spring.basic.servlet.web.frontcontroller.v1.ControllerV1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberFormController implements ControllerV1 {

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/member/join-form.jsp";
        RequestDispatcher dp = request.getRequestDispatcher(viewPath);
        dp.forward(request, response);
    }

}











