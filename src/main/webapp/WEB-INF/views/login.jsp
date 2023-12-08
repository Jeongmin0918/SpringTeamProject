<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>당근마켓 로그인</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login_style.css">
  <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
</head>
<body>
<div class="login-container">
  <h1>당근마켓 로그인</h1>
  <form action="#" method="post">
    <div class="form-group">
      <label for="email">이메일:</label>
      <input type="email" id="email" name="email" required>
    </div>
    <div class="form-group">
      <label for="password">비밀번호:</label>
      <input type="password" id="password" name="password" required>
    </div>
    <button id="login" type="submit">로그인</button>
    <p><a href="${pageContext.request.contextPath}/users/signup">회원가입</a></p>
  </form>
</div>
</body>

<script>
    $(document).ready(function(){
    $("#login").on('click', function(e){
      e.preventDefault(); // 폼 전송 막기
      var email = $("#email").val();
      var password = $("#password").val();
      $.ajax({
        url: "${pageContext.request.contextPath}/users/loginOK",
        type: "POST",
        data: {email: email, password: password},
        success: function(response) {
          if(response === "login succeed") {
            // 로그인 성공 시 홈 페이지로 리다이렉트
            window.location.href = "${pageContext.request.contextPath}/market/list";
          } else {
            alert('로그인에 실패했습니다.');
          }
        },
        error: function(xhr, status, error) {
          console.log(error);
        }
      });
    })
  });
</script>
</html>
