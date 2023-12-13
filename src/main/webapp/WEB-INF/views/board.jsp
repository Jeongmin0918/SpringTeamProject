<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>당근마켓 게시판</title>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/board_style.css">
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
  <div id="addBtn" class="container mt-3">
    <a href="${pageContext.request.contextPath}/market/add" class="btn btn-success">새로운 물품 추가</a>
  </div>
  <div class="container mt-3 board-container">
    <div class="row">
      <c:forEach items="${list}" var="u">
        <div class="col-md-3 mb-3">
          <div class="card">
            <img class="card-img-top" src="${pageContext.request.contextPath}/img/carrot.png" alt="${u.market.title}">
            <div class="card-body">
              <h5 class="card-title">${u.market.title}</h5>
              <p class="card-text">${u.user.email}</p>
              <p class="card-text">${u.market.createTime} ${u.market.exposeTime}</p>
              <p class="card-text">조회수: ${u.market.viewCnt}</p>
              <a href="editform/${u.market.id}" class="btn btn-primary">글 수정</a>
              <a href="view/${u.market.id}" class="btn btn-primary">글 조회</a>
              <a href="javascript:delete_ok('${u.market.id}')" class="btn btn-danger">글 삭제</a>
            </div>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>
</main>
<footer>

</footer>
<script>
  function showAlert() {
    alert("준비중입니다!");
  }

  function delete_ok(id){
    var a = confirm("정말로 삭제하겠습니까?");
    if(a) location.href='deleteok/' + id;
  }

</script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
