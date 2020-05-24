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
	<link href="${pageContext.request.contextPath}/resources/css/k_css/layout.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

<script src="${pageContext.request.contextPath}/resources/js/jquery-3.5.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="${$pageContext.reqeust.contextPath}/resources/js/main/main.js"></script>
<html>

<head>
    <title>모아봐요 수집의 숲</title>
</head>
<body>
<div class="main_wrap">
	<div id="header">
		<div class="main_head">
			<div class="head">
				<h1>
					<a href="#"><img src="${pageContext.request.contextPath}/resources/images/main_logo.png" alt="" /></a>
				</h1>
				<p>
					<a href="#"><img src="${pageContext.request.contextPath}/resources/images/login.png" alt="" /></a>
				</p>
			</div>
		</div>
	</div>
	<div id="container">
		<div class="contain">
			<div class="list_tab01">
				<div class="list_box">
					<ul>
						<li class="list_on">
							<span>할일</span>
							<a href="#">
								<img src="${pageContext.request.contextPath}/resources/images/tab_icon01_off.png" alt="" class="img_off" />
								<img src="${pageContext.request.contextPath}/resources/images/tab_icon01_on.png" alt="" class="img_on" />
							</a>
						</li>
						<li>
							<span>박물관 도감</span>
							<a href="#">
								<img src="${pageContext.request.contextPath}/resources/images/tab_icon02_off.png" alt="" class="img_off" />
								<img src="${pageContext.request.contextPath}/resources/images/tab_icon02_on.png" alt="" class="img_on" />
							</a>
						</li>
						<li>
							<span>음반</span>
							<a href="#">
								<img src="${pageContext.request.contextPath}/resources/images/tab_icon03_off.png" alt="" class="img_off" />
								<img src="${pageContext.request.contextPath}/resources/images/tab_icon03_on.png" alt="" class="img_on" />
							</a>
						</li>
						<li>
							<span>아이템 도감</span>
							<a href="#">
								<img src="${pageContext.request.contextPath}/resources/images/tab_icon04_off.png" alt="" class="img_off" />
								<img src="${pageContext.request.contextPath}/resources/images/tab_icon04_on.png" alt="" class="img_on" />
							</a>
						</li>
						<li>
							<span>DIY 도감</span>
							<a href="#">
								<img src="${pageContext.request.contextPath}/resources/images/tab_icon05_off.png" alt="" class="img_off" />
								<img src="${pageContext.request.contextPath}/resources/images/tab_icon05_on.png" alt="" class="img_on" />
							</a>
						</li>
						<li>
							<span>주민 도감</span>
							<a href="#">
								<img src="${pageContext.request.contextPath}/resources/images/tab_icon06_off.png" alt="" class="img_off" />
								<img src="${pageContext.request.contextPath}/resources/images/tab_icon06_on.png" alt="" class="img_on" />
							</a>
						</li>
						<li>
							<span>꽃, 나무 도감</span>
							<a href="#">
								<img src="${pageContext.request.contextPath}/resources/images/tab_icon07_off.png" alt="" class="img_off" />
								<img src="${pageContext.request.contextPath}/resources/images/tab_icon07_on.png" alt="" class="img_on" />
							</a>
						</li>
						<li>
							<span>마일 업적 정보</span>
							<a href="#">
								<img src="${pageContext.request.contextPath}/resources/images/tab_icon08_off.png" alt="" class="img_off" />
								<img src="${pageContext.request.contextPath}/resources/images/tab_icon08_on.png" alt="" class="img_on" />
							</a>
						</li>
						<li>
							<span>무트코인</span>
							<a href="#">
								<img src="${pageContext.request.contextPath}/resources/images/tab_icon09_off.png" alt="" class="img_off" />
								<img src="${pageContext.request.contextPath}/resources/images/tab_icon09_on.png" alt="" class="img_on" />
							</a>
						</li>
						<li>
							<span>게시판</span>
							<a href="#">
								<img src="${pageContext.request.contextPath}/resources/images/tab_icon10_off.png" alt="" class="img_off" />
								<img src="${pageContext.request.contextPath}/resources/images/tab_icon10_on.png" alt="" class="img_on" />
							</a>
						</li>
						<li>
							<span>정보</span>
							<a href="#">
								<img src="${pageContext.request.contextPath}/resources/images/tab_icon11_off.png" alt="" class="img_off" />
								<img src="${pageContext.request.contextPath}/resources/images/tab_icon11_on.png" alt="" class="img_on" />
							</a>
						</li>
					</ul>
				</div>
				<p class="btn_prev hand">
					<span>L</span>
				</p>
				<p class="btn_next hand">
					<span>R</span>
				</p>
			</div>
			<div class="list_tab02">
				<div class="list_tab02_box">
					<ul>
						<li class="on"><a href="#">K.K</a></li>
						<li><a href="#">깨빈</a></li>
						<li><a href="#">부옥</a></li>
						<li><a href="#">죠니</a></li>
						<li><a href="#">무파니</a></li>
						<li><a href="#">여욱</a></li>
						<li><a href="#">사하라</a></li>
					</ul>
				</div>	
				<p class="btn_prev02 hand">
					<span>&#10094;</span>
				</p>
				<p class="btn_next02 hand">
					<span>&#10095;</span>
				</p>
			</div>
			<div class="item_set">
				<div class="item_search_btn">
					<div class="item_search">
						<p class="hand">검색</p>
						<input type="text" name="search" />
					</div>
					<div class="item_btn">
						<p class="hand"><span>A</span>할일 추가</p>
						<p class="hand"><span>B</span>할일 수정</p>
					</div>
				</div>
				<div class="item_list">
					<div class="item_list_box">
						<table>
							<colgroup>
								<col width="70" />
								<col width="10%" />
								<col width="8%" />
								<col width="*" />
								<col width="59" />
								<col width="59" />
							</colgroup>
							<thead>
								<tr>
									<th>상하</th>
									<th>체크</th>
									<th>수</th>
									<th class="txt_left">할 일</th>
									<th class="nopadding hand"><span class="rotate90">&#10094;</span></th>
									<th class="nopadding hand"><span class="rotate90">&#10095;</span></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="hand"><img src="${pageContext.request.contextPath}/resources/images/updown_btn.png" alt="" /></td>
									<td>2</td>
									<td>3</td>
									<td colspan="3" class="txt_left">4</td>
								</tr>
								<tr>
									<td class="hand"><img src="${pageContext.request.contextPath}/resources/images/updown_btn.png" alt="" /></td>
									<td>2</td>
									<td>3</td>
									<td colspan="3" class="txt_left">4</td>
								</tr>
								<tr>
									<td class="hand"><img src="${pageContext.request.contextPath}/resources/images/updown_btn.png" alt="" /></td>
									<td>2</td>
									<td>3</td>
									<td colspan="3" class="txt_left">4</td>
								</tr>
							</tbody>
						</table>
					</div>
					
					<div class="item_list_box">
						<table>
							<colgroup>
								<col width="70" />
								<col width="10%" />
								<col width="8%" />
								<col width="*" />
								<col width="59" />
								<col width="59" />
							</colgroup>
							<thead>
								<tr>
									<th>상하</th>
									<th>체크</th>
									<th>수</th>
									<th class="txt_left">할 일</th>
									<th class="nopadding hand"><span class="rotate90">&#10094;</span></th>
									<th class="nopadding hand"><span class="rotate90">&#10095;</span></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="hand"><span class="rotate180"><img src="${pageContext.request.contextPath}/resources/images/updown_btn.png" alt="" /></span></td>
									<td>2</td>
									<td>3</td>
									<td colspan="3" class="txt_left">4</td>
								</tr>
								<tr>
									<td class="hand"><span class="rotate180"><img src="${pageContext.request.contextPath}/resources/images/updown_btn.png" alt="" /></span></td>
									<td>2</td>
									<td>3</td>
									<td colspan="3" class="txt_left">4</td>
								</tr>
								<tr>
									<td class="hand"><span class="rotate180"><img src="${pageContext.request.contextPath}/resources/images/updown_btn.png" alt="" /></span></td>
									<td>2</td>
									<td>3</td>
									<td colspan="3" class="txt_left">4</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<div class="updown_btn">
			<p class="rotate90 hand">&#10094;</p>
			<p class="rotate90 hand">&#10095;</p>
		</div>
	</div>
</div>



<!-- 슬라이드 스크립트 -->
<script>
 $('.btn_prev').on(function(){
 	$('.list_box ul li:last').prependTo('.list_box ul');
 	$('.list_box ul').css('margin-left',-116);
 	$('.list_box ul').stop().animate({marginLeft:0}, 0)
 });
 $('.btn_next').on(function(){
 	$('.list_box').stop().animate({marginLeft:-116}, 0, function(){
 		$('.list_box ul li:first').appendTo('.list_box ul');
 		$('.list_box').css({marginLeft:0})
 	})
 });
 </script>
 
 <script>
 $('.btn_prev02').on(function(){
 	$('.list_tab02_box ul li:last').prependTo('.list_tab02_box ul');
 	$('.list_tab02_box ul').css('margin-left',-164);
 	$('.list_tab02_box ul').stop().animate({marginLeft:0}, 0)
 });
 $('.btn_next02').on(function(){
 	$('.list_tab02_box').stop().animate({marginLeft:-116}, 0, function(){
 		$('.list_tab02_box ul li:first').appendTo('.list_tab02_box ul');
 		$('.list_tab02_box').css({marginLeft:0})
 	})
 });
 </script>


</body>
</html>
