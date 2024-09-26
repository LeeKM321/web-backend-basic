<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.spring.basic.servlet.domain.Member" %>

<%
        System.out.println("join.jsp의 자바 코드 실행!");
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(id, pw, username, age);
        System.out.println(member);
%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h2>회원 가입 성공!</h2>
    <ul>
        <li><%= member.getUserName() %>님 환영합니다!</li>
        <li>id: <%= member.getId() %></li>
        <li>나이: <%= member.getAge() %></li>
    </ul>
</body>
</html>








