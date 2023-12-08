<%@ page import="java.io.File" %>
<%@ page import="org.springframework.web.multipart.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>당근 물품 추가</h1>
<form action="addok" method="post" enctype="multipart/form-data">
    <table id="edit">
        <tr><td>사진:</td><td><input type="file" name="photoURL"/></td></tr>
        <tr><td>제목:</td><td><input type="text" name="title"/></td></tr>
        <tr><td>가격:</td><td><input type="text" name="price"/></td><td>원</td></tr>
        <tr><td>내용:</td><td><textarea cols="50" rows="5" name="content"></textarea></td></tr>
        <tr><td>구매방법(택배/직거래):</td><td><input type="text" name="howPurchase"/></td></tr>
    </table>
    <button type="button" onclick="location.href='list'">목록보기</button>
    <button type="submit">등록하기</button>
</form>

</body>
</html>