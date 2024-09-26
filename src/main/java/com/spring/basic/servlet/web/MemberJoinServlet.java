package com.spring.basic.servlet.web;

import com.spring.basic.servlet.domain.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet/member/join")
public class MemberJoinServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request,
                           HttpServletResponse response) throws ServletException, IOException {

        System.out.println("MemberJoinServlet의 service 호출!");
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(id, pw, username, age);
        System.out.println(member);

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter w = response.getWriter();

        w.write("<!DOCTYPE html>\n" +
                "<html lang=\"ko\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Document</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h2>회원 가입 성공!</h2>\n" +
                "    <ul>\n" +
                "        <li>" + member.getUserName() + "님 환영합니다!</li>\n" +
                "        <li>id: " + member.getId() + "</li>\n" +
                "        <li>나이: " + member.getAge() + "세</li>\n" +
                "    </ul>\n" +
                "</body>\n" +
                "</html>");


    }
}











