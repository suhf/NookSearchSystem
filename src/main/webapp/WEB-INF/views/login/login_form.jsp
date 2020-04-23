<%--
  User: Suh
  Date: 2020-04-22
  Time: 오후 11:14
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.5.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container h-100">
    <div class="d-flex flex-wrap justify-content-center align-content-center h-100">
        <form id="frm" name="frm" method="post" action="loginCheck.do">
            <label for="id">ID : </label>
            <input class="form-control" type="text" id="id" name="id" aria-describedby="idHelp">
            <small id="idHelp" class="form-text text-muted">아이디를 입력해주세요</small>
            <label for="pw">PW : </label>
            <input class="form-control" type="password" id="pw" name="pw" aria-describedby="pwHelp">
            <small id="pwHelp" class="form-text text-muted">비밀번호를 입력해주세요</small>
            <button class="btn btn-primary" type="submit">로그인</button>
        </form>
    </div>
</div>
</body>
</html>
