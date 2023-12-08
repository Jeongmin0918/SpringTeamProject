<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>당근마켓 회원가입</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/signup_style.css">
  <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
</head>
<body>
<div class="login-container">
  <h1>당근마켓 회원가입</h1>
  <form action="${pageContext.request.contextPath}/users/signupOK" method="post">
    <div class="form-group">
      <label for="email">이메일:</label>
      <input type="email" id="email" name="email" required>
      <span id="guide_email"></span>
    </div>
    <div class="form-group">
      <label for="password">비밀번호:</label>
      <input type="password" id="password" name="password" required>
    </div>
    <div class="form-group">
      <label for="confirm-password">비밀번호 확인:</label>
      <input type="password" id="confirm-password" name="confirm-password" required>
    </div>
    <button id="signup" type="submit">회원가입</button>
  </form>
  <p>이미 계정이 있으신가요? <a href="${pageContext.request.contextPath}/users/login">로그인</a></p>
</div>
</body>
<script>
  $(document).ready(function(){
    $("#email").on('input', function(){
        var email = $("#email").val();
          $.ajax({
            url: "${pageContext.request.contextPath}/users/checkEmail",
            type: "GET",
            data: {email: email},
            success: function(response) {
              if((response === "The email is allowed.") && (isValidEmail(email))) {
                  $("#guide_email").text(response);
                  $("#guide_email").css("color", "blue");
                  $("#signup").removeAttr("disabled");
                  $("#signup").css("backgroundColor", "#ff6600");
                  $("#signup").css("cursor", "pointer");
              } else {
                $("#guide_email").text("The email is not allowed");
                $("#guide_email").css("color", "red");
                $("#signup").attr("disabled", "disabled");
                $("#signup").css("backgroundColor", "grey");
                $("#signup").css("cursor", "default");
              }
            },
            error: function(xhr, status, error) {
              // 사용자에게 에러 메시지 표시
              console.log(error);
            }
          });
      });
  });

  function isValidEmail(email) {
    var regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    return regex.test(email);
  }
</script>

</html>
