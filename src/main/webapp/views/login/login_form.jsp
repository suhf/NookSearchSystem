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
    <script>
        $(function(){
           $("#btn_join").on("click", function(){
                location.href="join_page.do";
           });
           $("#btn_login").on("click", login );
        });

        function login(){
            let json = {};
            json.id = $("#id").val();
            json.password = $("#password").val();
            let parsed = JSON.stringify(json);

            console.log(parsed);

            $("#btn_login").off();
            $("#btn_login").attr("disabled", true);
            $.ajax({
                type: "POST",
                url: "loginCheck.do",
                data: parsed,
                datatype: "json",
                contentType: "application/json",
                success: function (data) {
                    let result = data.result;
                    if (result == "false") {
                        alert("아이디 혹은 비밀번호가 틀렸어 너굴");
                    } else {
                        $("#frm").submit();
                    }
                    $("#btn_login").on("click", login );
                    $("#btn_login").attr("disabled", false);
                },
                complete : function(){
                    $("#btn_login").on("click", login );
                    $("#btn_login").attr("disabled", false);
                }
            });
        }

    </script>
</head>
<body>
<div class="container h-100">
    <div class="d-flex flex-wrap justify-content-center align-content-center h-100">
        <form id="frm" name="frm" method="post" action="todo_page.do">
            <label for="id">ID : </label>
            <input class="form-control" type="text" id="id" name="id" aria-describedby="idHelp">
            <small id="idHelp" class="form-text text-muted">아이디를 입력해주세요</small>
            <label for="password">PW : </label>
            <input class="form-control" type="password" id="password" name="password" aria-describedby="pwHelp">
            <small id="pwHelp" class="form-text text-muted">비밀번호를 입력해주세요</small>
            <button id="btn_login" class="btn btn-primary" type="button">로그인</button>
            <button id="btn_join" class="btn btn-primary" type="button">회원가입</button>
        </form>
    </div>
</div>
</body>
</html>
