package com.spring.basic.servlet.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet/member/form")
public class MemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request,
                           HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter w = response.getWriter();

        w.write("<!DOCTYPE html>\n" +
                "<html lang=\"ko\">\n" +
                "  <head>\n" +
                "    <meta charset=\"UTF-8\" />\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
                "    <title>회원가입 form</title>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <form action=\"/servlet/member/join\" method=\"post\">\n" +
                "      아이디: <input type=\"text\" name=\"id\" /> <br />\n" +
                "      비밀번호: <input type=\"password\" name=\"pw\" /> <br />\n" +
                "      이름: <input type=\"text\" name=\"username\" /> <br />\n" +
                "      나이: <input type=\"text\" name=\"age\" /> <br />\n" +
                "      <button type=\"submit\">회원가입</button>\n" +
                "    </form>\n" +
                "  </body>\n" +
                "</html>\n");

    }
}











