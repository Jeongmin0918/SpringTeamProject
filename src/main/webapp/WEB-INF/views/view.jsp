<%--
  Created by IntelliJ IDEA.
  User: yjy67
  Date: 2023-12-02
  Time: 오전 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align:center;
        }
        .sub {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: center;
            background-color: #006bb3;
            color: white;
        }
    </style>
</head>
<body>
<h1>자유게시판 상세 정보</h1>
<table>
    <tr>
        <td class="sub">번호</td>
        <td>${view.seq}</td>
    </tr>
    <tr>
        <td class="sub">제목</td>
        <td>${view.title}</td>
    </tr>
    <tr>
        <td class="sub">글쓴이</td>
        <td>${view.writer}</td>
    </tr>
    <tr>
        <td class="sub">내용</td>
        <td>${view.content}</td>
    </tr>
    <tr>
        <td class="sub">수정일자</td>
        <td>${view.regdate}</td>
    </tr>
</table>
<input type="button" value="뒤로가기" onclick="history.back()"/>
</body>
</html>
