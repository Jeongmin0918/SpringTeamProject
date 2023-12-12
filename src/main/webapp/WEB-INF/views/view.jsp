<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>물품 조회</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light" style="justify-content: space-between;">
        <img src="${pageContext.request.contextPath}/img/carrot.png" alt="당근마켓 로고" style="height: 30px; width: auto; margin-right: 20px">
        <a class="navbar-brand" href="#">당근마켓</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/market/list">홈 <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#" onclick="showAlert()">게시판</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#" onclick="showAlert()">내 프로필</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">로그아웃</a>
                </li>
            </ul>
        </div>
    </nav>
</header>
<main>
    <div class="container mt-3">
        <h1>물품 조회</h1>
        <form modelAttribute="u" method="POST" action="../editok">
            <input type="hidden" name="id" value="${u.market.id}" />
            <table class="table">
                <tr>
                    <td>사진:</td>
                    <td>${u.market.photoURL}</td>
                </tr>
                <tr>
                    <td>제목:</td>
                    <td>${u.market.title}</td>
                </tr>
                <tr>
                    <td>글쓴이:</td>
                    <td>${u.user.email}</td>
                </tr>
                <tr>
                    <td>가격:</td>
                    <td>
                        <div class="input-group">
                            ${u.market.price}
                            <div class="input-group-append">
                                <span class="input-group-text">원</span>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>내용:</td>
                    <td>${u.market.content}</td>
                </tr>
                <tr>
                    <td>구매방법(택배/직거래):</td>
                    <td>${u.market.howPurchase}</td>
                </tr>
            </table>
            <input type="button" value="뒤로가기" onclick="window.location.href='${pageContext.request.contextPath}/market/list'"/>
        </form>
    </div>
</main>
<script>
    function showAlert() {
        alert("준비중입니다!");
    }
</script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
