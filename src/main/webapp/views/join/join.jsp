<%--
  User: Suh
  Date: 2020-04-06
  Time: 오전 12:57
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, target-densitydpi=medium-dpi" />
	<meta name="format-detection" content="telephone=no" />
	<link href="/wbbs/img/favicon.ico" rel="shortcut icon" />
	
	<link href="${pageContext.request.contextPath}/resources/css/k_css/default.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/resources/css/k_css/login.css" rel="stylesheet" type="text/css" />

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

<div class="wrap">
	<div class="join">
		<h1>
			<a href="#"><img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="" /></a>
		</h1>
		<div class="login_box">
			<form id="frm" name="frm" action="join.do" method="post" class = "rounded">
				<p class="font_box">회원가입 <span>* 반드시 입력해주세요</span></p>
				<div class="join_group">
				 	<dl>
				 		<dt>* 아이디</dt>
				 		<dd>
				 			<input id="id" name="id" class="form-control" placeholder="아이디를 입력해주세요." />
				 		</dd>
				 	</dl>
				 	<dl>
				 		<dt>* 비밀번호</dt>
				 		<dd>
				 			 <input type="password" id="password" name="password" class="form-control" placeholder="비밀번호를 입력해주세요." />
				 		</dd>
				 	</dl>
				 	<dl>
				 		<dt>* 비밀번호 확인</dt>
				 		<dd>
				 			<input type="password" id="pwCheck" name="pwCheck" class="form-control" placeholder="비밀번호 확인" />
				 		</dd>
				 	</dl>
				 	<dl>
				 		<dt>* 섬 이름</dt>
				 		<dd>
				 			<input name="IslandName" type="text" placeholder="섬 이름을 입력해주세요." />
				 		</dd>
				 	</dl>
				 	<dl>
				 		<dt>* 게임 캐릭터 이름</dt>
				 		<dd>
				 			<input name="CharacterName" type="text" placeholder="캐릭터 이름을 입력해주세요." />
				 		</dd>
				 	</dl>
				 	<dl>
				 		<dt>* 섬위치</dt>
				 		<dd>
				 			<span><input type="radio" name="hemisphere" value="북반구"/> 북반구</span> <span><input type="radio" name="hemisphere" value="남반구"/> 남반구</span>
				 		</dd>
				 	</dl>
				 	<dl>
				 		<dt class="color_none">친구코드</dt>
				 		<dd>
				 			<input name="friendCode" type="text" placeholder="친구코드" />
				 		</dd>
				 	</dl>
				 	<dl>
				 		<dd>
				 			<ul>
				 				<li>아이디 / 패스워드를 찾을 수 있는 기능을 제공하고 있지 않아 구리</li>
				 				<li>아이디 / 패스워드 수정 기능도 제공하지 않으니 아이디 / 패스워드를 꼭 기억해야 해 구리</li>				 			
				 			</ul>
				 		</dd>
				 	</dl>
	            </div>
	            <div class="join_btn">
		             <button id="btn_join" type="button">회원가입</button> 
		             <button type="button" onclick="location.href='home.do'">취소</button>
				</div>
			</form>
		</div>
	</div>
</div>

<!-- <div class="view" style="background-image: url('${pageContext.request.contextPath}/img/wallpaper/login_wallpaper.png'); background-repeat: no-repeat; background-size: cover; background-position: center center;">
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
</div> -->


</body>
</html>
