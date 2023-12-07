<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <title>당근마켓 게시판</title>
</head>
<body>

<div class="container mt-3">
  <div class="row">

    <c:forEach items="${list}" var="u">
      <div class="col-md-3 mb-3">
        <div class="card">
          <img class="card-img-top" src="item1.jpg" alt="물품1">
          <div class="card-body">
            <h5 class="card-title">${u.title}</h5>
            <p class="card-text">${u.writer}</p>
            <p class="card-text">${u.viewCnt}</p>
          </div>
        </div>
      </div>
    </c:forEach>
  </div>
</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
