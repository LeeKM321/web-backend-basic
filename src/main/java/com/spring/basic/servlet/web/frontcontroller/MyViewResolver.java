package com.spring.basic.servlet.web.frontcontroller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MyViewResolver {

    private String viewPath; // 포워딩 할 뷰 경로
    private String prefix; // 경로에 있는 공통 접두사
    private String suffix; // 경로에 있는 공통 접미사
    private boolean redirect; // 리다이렉트 여부

    // 전달되는 viewName은 공통점이 있음.
    // /WEB-INF/views/는 다 똑같다. 확장자가 .jsp라는 것도 다 똑같다.
    public MyViewResolver(String viewPath) {
        this.prefix = "/WEB-INF/views/";
        this.suffix = ".jsp";

        if (!isRedirect(viewPath)) {
            // 리다이렉트 아님.
            this.viewPath = prefix + viewPath + suffix;
        } else {
            // 리다이렉트 요청임.
            // redirect:front-controller/v3/members
            this.viewPath = viewPath.substring(viewPath.indexOf(":") + 1);
        }
    }

    // 기존의 render는 forward만 함.
    // 이제는 상황에 따라 sendRedirect도 해야 함. -> redirect 필드를 확인.
    public void render(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
       if (!this.redirect) {
           RequestDispatcher dp = request.getRequestDispatcher(viewPath);
           dp.forward(request, response);
       } else {
           response.sendRedirect(viewPath);
       }
    }


    // 전달된 view 요청이 리다이렉트인지 확인
    private boolean isRedirect(String viewName) {
        // redirect 요청은 아마 redirect: 으로 시작할 것이다.
        this.redirect = viewName.startsWith("redirect:");
        return this.redirect;
    }



}













