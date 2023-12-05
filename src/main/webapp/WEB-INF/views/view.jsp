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
</head>
<body>
<h1>물품 상세 정보</h1>
<table>
    <tr>
        <td class="sub">사진</td>
        <td>${view.photoURL}</td>
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
        <td class="sub">가격</td>
        <td>${view.price}</td>
    </tr>
    <tr>
        <td class="sub">내용</td>
        <td>${view.content}</td>
    </tr>
    <tr>
        <td class="sub">구매방법</td>
        <td>${view.howPurchase}</td>
    </tr>
    <tr>
        <td class="sub">올린날짜</td>
        <td>${view.createTime}</td>
    </tr>
    <tr>
        <td class="sub">조회수</td>
        <td>${view.viewCnt}</td>
    </tr>
</table>
<input type="button" value="끌어올리기" />
<input type="button" value="뒤로가기" onclick="history.back()"/>
</body>
</html>
