<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.spring.basic.servlet.domain.Member" %>

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
        <li> ${requestScope.member.userName}님 환영합니다!</li>
        <li>id: ${member.id}</li>
        <li>나이: ${member.age}</li>
    </ul>

    <br>
    <a href="/front-controller/v4/members">전체 회원 목록 보기</a>

</body>
</html>







