<%--
  User: Suh
  Date: 2020-04-06
  Time: 오전 12:57
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

<script src="${pageContext.request.contextPath}/resources/js/jquery-3.5.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<html>
<head>
    <title>회원가입</title>
    <style>
    </style>
    <script>
        $(document).ready(function(){

            $("#pwCheck").change(function(){
               if($("#pwCheck").val() != $("#password").val()){
                   $("#pwCheck").focus();
                   $("#pwCheckHelp").show();
               }else{
                   $("#pwCheckHelp").hide();
               }
            });

            $("#btn_join").on("click", checkJoin);
        });

        function checkJoin(){
        //ajax로 같은 이메일이 존재하나 확인해야함
            var str = $("#id").val();
            var json = {};
            json.id = str;
            var parsed = JSON.stringify(json);
            $("#btn_join").off();
            if($("#pwCheck").val() == $("#password").val()) {
                $.ajax({
                    type: "POST",
                    url: "userCheck.do",
                    data: parsed,
                    datatype: "json",
                    contentType: "application/json",
                    success: function (data) {
                        console.log(data);
                        let result = data.result;
                        if (result == "true") {
                            alert("이미 있는 아이디야. 너굴");
                        } else {
                            document.getElementById("frm").submit();
                        }
                    },
                    complete : function(){
                        $("#btn_join").on("click", checkJoin);
                    }
                });
            }else{
                if($("#pwCheck").val() != $("#password").val()){
                    $("#pwCheck").focus();
                    $("#pwCheckHelp").show();
                }else{
                    $("#pwCheckHelp").hide();
                }
            }
        }
    </script>
</head>
<body>
<div class="view" style="background-image: url('${pageContext.request.contextPath}/img/wallpaper/login_wallpaper.png'); background-repeat: no-repeat; background-size: cover; background-position: center center;">
    <div class="container" style="width: 30%;">
        <div class="row justify-content-md-center align-items-center"  style="height : 100%;">
            <div class="col">
                <form id="frm" name="frm" action="join.do" method="post" class = "rounded" style="background-color: white; padding : 2em;">
                    <div class="form-group">
                        <label for="id">아이디</label>
                        <input id="id" name="id" class="form-control" placeholder="ID" required>
                        <small id="emailHelp" class="form-text text-muted">반드시 입력해주세요</small>
                        <small id="existId" class="form-text" style="color : red; display : none"> * 해당 아이디는 이미 존재합니다</small>
                    </div>
                    <div class="form-group">
                        <label>비밀번호</label>
                        <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
                    </div>
                    <div class="form-group">
                        <label>비밀번호 확인</label>
                        <input type="password" id="pwCheck" name="pwCheck" class="form-control" placeholder="Password" required>
                        <small id="pwCheckHelp" class="form-text" style="color:red; display: none">위의 비밀번호와 똑같이 입력하셔야 합니다</small>
                    </div>
                    <button id="btn_join" type="button" class="btn btn-primary">가입</button>
                    <button type="button" class="btn btn-danger" onclick="location.href='home.do'">취소</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
