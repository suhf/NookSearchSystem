<%--
  Created by IntelliJ IDEA.
  User: Suh
  Date: 2020-04-30
  Time: 오후 6:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://fonts.googleapis.com/css?family=Cute+Font" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.5.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/all.min.js"></script>
    <script>
        $(function(){
           $("#btn_default_file").on("click", insertDefaultData);

        });

        function insertDefaultData(){
            console.log("전송함");
            let form = $("#dDataFrm");
            let formData = new FormData();
            formData.append("file", $("#default_file")[0].files[0]);
            $.ajax({
               url: "/defaultDataInsert.do",
               processData: false,
               contentType: false,
               data: formData,
               type: 'POST',
               success: function(result){
                    console.log(result);
                    if(result == "invalid"){
                        alert("업로드한 데이터가 정확하지 않습니다");
                    }else {
                        if (result == "true") {
                            alert("데이터를 성공적으로 업로드 하였습니다");
                            location.href="adminDataInsertPage.do";
                        } else if (result == "false") {
                            alert("데이터베이스에 업로드하다 문제가 생겼습니다");
                        } else {
                            alert("알수없는 에러가 발생하였습니다");
                        }
                    }
               },
                fail: function(){
                   alert("데이터를 전송하는데 실패하였습니다");
                }
            });
        }

        function makeDefaultTodoTable(){
            let $table = $("tb_default_todo_data");

            $table.remove(".dataTr");
        }
    </script>
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <div class="col-12">
                <h1>기본 할일 테이블 입력</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <form id="dDataFrm" name="dDataFrm" enctype="multipart/form-data">
                    <input type="file" class="form-control-file" id="default_file" name="default_file">
                    <button type="button" class="form-control" id="btn_default_file" >전송</button>
                </form>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <table class="table" id="tb_default_todo_data" class="table">
                    <tr>
                        <td>TodoNo</td>
                        <td>IsAlways</td>
                        <td>Content</td>
                        <td>Day</td>
                        <td>MinCount</td>
                        <td>MaxCount</td>
                        <td>NPCName</td>
                        <td>IsEvent</td>
                        <td>EventStartDate</td>
                        <td>EventStartHour</td>
                        <td>EventEndDate</td>
                        <td>EventEndHour</td>
                        <td>SpecialFunction</td>
                        <td>SpecialData1</td>
                        <td>SpecialData2</td>
                        <td>SpecialData3</td>
                        <td>SpecialData4</td>
                    </tr>
                    <c:forEach var="item" items="${list}">
                        <tr class="dataTr">
                            <td>${item.dTodoNo}</td>
                            <td>${item.dIsAlways}</td>
                            <td>${item.dContent}</td>
                            <td>${item.dDay}</td>
                            <td>${item.dMinCount}</td>
                            <td>${item.dMaxCount}</td>
                            <td>${item.dNpcName}</td>
                            <td>${item.dIsEvent}</td>
                            <td>${item.dEventStartDate}</td>
                            <td>${item.dEventStartHour}</td>
                            <td>${item.dEventEndDate}</td>
                            <td>${item.dEventEndHour}</td>
                            <td>${item.dSpecialFunction}</td>
                            <td>${item.dSpecialData1}</td>
                            <td>${item.dSpecialData2}</td>
                            <td>${item.dSpecialData3}</td>
                            <td>${item.dSpecialData4}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</body>
</html>