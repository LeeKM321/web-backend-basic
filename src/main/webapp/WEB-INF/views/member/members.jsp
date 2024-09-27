<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>

    <style>
      table {
        border-collapse: collapse;
      }
    </style>
  </head>
  <body>
    <table border="1">
      <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>나이</th>
      </tr>

      <c:forEach var="mem" items="${mList}">
        <tr>
            <td>${mem.id}</td>
            <td>${mem.userName}</td>
            <td>${mem.age}</td>
        </tr>
      </c:forEach>

    </table>
  </body>
</html>









