<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yjy67
  Date: 2023-11-28
  Time: 오후 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
    <script>
        function delete_ok(id){
            var a = confirm("정말로 삭제하겠습니까?");
            if(a) location.href='deleteok/' + id;
        }
    </script>
</head>
<body>
<h1>당근을 심고 파세요!</h1>
<table id="list" width="100%">
    <tr>
        <th>번호</th>
        <th>사진</th>
        <th>제목</th>
        <th>글쓴이</th>
        <th>올린날짜</th>
        <th>조회수</th>
        <th>수정</th>
        <th>삭제</th>
    </tr>
    <c:forEach items="${list}" var="u">
        <tr>
            <td>${u.id}</td>
            <td>${u.photoURL}</td>
            <td>${u.title}</td>
            <td>${u.writer}</td>
            <td>${u.createTime}</td>
            <td>${u.viewCnt}</td>
            <td><a href="editform/${u.id}">글수정</a></td>
            <td><a href="view/${u.id}">글조회</a></td>
        </tr>
    </c:forEach>
</table>
<br/> <a href="add">새로운 물품 추가</a>
</body>
</html>
