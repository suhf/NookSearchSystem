<%--
  User: Suh
  Date: 2020-04-23
  Time: 오후 10:22
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <link href="https://fonts.googleapis.com/css?family=Cute+Font" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.5.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/all.min.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/todo.css">
    <style>
        .w-14{
            width : 6.4em;
        }

        tr{
            cursor : pointer;
        }
        input[type="text"] {
            outline : none;
        }

        #tbodyTodo tr:nth-child(2n-1){
            background-color : #89caa2;
        }
        #tbodyTodo tr:nth-child(2n){
            background-color : #70b98b;
        }

        body{
            background-color: #a3d5a4;
            font-family: 'Cute Font', sans-serif;
            font-size : 1.3rem;
        }
    </style>
    <script>
        let dataList;
        $(function(){

            makeTable();
        });

        function addTrEvent($tr){
            $tr.on("click", function(){
                let $input = $(this).find("input");

                let $del = $input.closest("del");
                console.log($del.get(0));
                if($del.get(0) == undefined) {
                    $input.wrap("<del></del>");
                }else{
                    $input.unwrap("del");
                }

            });
        }

        function makeTable(){

            $.ajax({
                type: "POST",
                url: "getTodoData.do",
                datatype: "json",
                contentType: "application/json",
                success: function (data) {
                    let $tableBody = $("#tbodyTodo");
                    dataList = data.list;
                    $(dataList).each(function(index, item){

                        let $tr = $("<tr>");
                        addTrEvent($tr);
                        let $td = $("<td>");
                        $td.addClass("text-center");
                        $tableBody.append($tr);
                        $tr.append($td);
                        $td.html(index+1);

                        $td = $("<td>");
                        $td.addClass("text-left");
                        $tr.append($td);
                        let $todoInput = $("<ct:todo_input />");
                        $todoInput.val(item.uContent);

                        $todoInput.css("background-color", "rgba(0,0,0,0)");
                        $td.append($todoInput);



                    });

                }
            });

        }
    </script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-12">
            <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a class="nav-link active" href="#">할일 리스트</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">도구 리스트</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">물고기 리스트</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">화석 리스트</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">옷 리스트</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">음반 리스트</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">명화 리스트</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">꽃 리스트</a>
                </li>


            </ul>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-12">
            <div class="btn-toolbar d-flex justify-content-center" role="toolbar"
                 aria-label="Toolbar with button groups">
                <div class="btn-group mr-2" role="group" aria-label="First group">
                    <button id="btn1" type="button" class="btn btn-secondary w-14">아무나</button>
                    <button id="btn2" type="button" class="btn btn-secondary w-14">무나아</button>
                    <button id="btn3" type="button" class="btn btn-secondary w-14">나아무</button>
                    <button id="btn4" type="button" class="btn btn-secondary w-14">아나무</button>
                    <button id="btn5" type="button" class="btn btn-secondary w-14">무아나</button>
                    <button id="btn6" type="button" class="btn btn-secondary w-14">K.K</button>
                    <button id="btn7" type="button" class="btn btn-secondary w-14">무파니</button>
                </div>
            </div>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-12">

            <div id="todo_body" class="p-2 border border-dark">
                <table id="tbTodo" class="table text-white">
                    <thead>
                    <tr>
                        <th class="text-center" scope="col" style="width: 10%; min-width: 4rem">#</th>
                        <th class="text-left" scope="col" style="width: 80%; min-width: 4rem">할 일</th>
                    </tr>
                    </thead>
                    <tbody id="tbodyTodo">

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
