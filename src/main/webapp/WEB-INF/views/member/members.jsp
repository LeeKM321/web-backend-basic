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
        <th>비고</th>
      </tr>

      <c:forEach var="mem" items="${mList}">
        <tr>
            <td>${mem.id}</td>
            <td>${mem.userName}</td>
            <td>${mem.age}</td>
            <td>
                <button data-id="${mem.id}">삭제</button>
            </td>
        </tr>
      </c:forEach>

    </table>

    <script>
        const $table = document.querySelector('table');
        $table.addEventListener('click', (e) => {
            if (!e.target.matches('tbody button')) return;

            if (confirm('정말 삭제하시겠습니까?')) {
                const delTarget = e.target.dataset.id;
                location.href='/front-controller/v3/member/delete?id=' + delTarget;
            }
        });
    </script>


  </body>
</html>









