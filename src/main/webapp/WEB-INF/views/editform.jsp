<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 <%@page import="com.example.market.MarketDAO, com.example.market.MarketVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>

<h1>물품 수정</h1>
<form:form modelAttribute="u" method="POST" action="../editok">
	<form:hidden path="id"/>
<table id="edit">
	<tr><td>사진:</td><td><input type="file" name="photoURL"/></td></tr>
	<tr><td>제목:</td><td><form:input path="title"/></td></tr>
	<tr><td>글쓴이:</td><td><form:input path="writer"/></td></tr>
	<tr><td>가격:</td><td><form:input path="price"/></td><td>원</td></tr>
	<tr><td>내용:</td><td><form:textarea cols="50" rows="5" path="content"></form:textarea></td></tr>
	<tr><td>구매방법(택배/직거래):</td><td><form:input type="text" path="howPurchase"/></td></tr>
</table>
	<input type="submit" value="수정하기"/>
	<input type="button" value="취소하기" onclick="history.back()"/>
</form:form>

</body>
</html>