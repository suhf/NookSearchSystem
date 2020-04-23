<%--
  User: Suh
  Date: 2020-04-23
  Time: 오후 10:22
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.5.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/todo.css">
    <style>
        .w-14{
            width : 6.4em;
        }

        tr{
            cursor : pointer;
        }
    </style>
    <script>
        $(function(){

            $("tr").bind("click", function(){
                let $input = $(this).find("input");
                let $label = $(this).find("label");
                if($input.prop("checked")){
                    $input.prop("checked", false);
                    $label.html($label.text());
                }else{
                    $input.prop("checked", true);
                    $label.wrapInner("<del></del>");
                }
            });
        });
    </script>
</head>
<body>
<div class="container-fluid">

    <div class="row">
        <div class="col-12">
            <div class="btn-toolbar d-flex justify-content-center" role="toolbar"
                 aria-label="Toolbar with button groups">
                <div class="btn-group mr-2 " role="group" aria-label="First group">
                    <button id="btnMon" type="button" class="btn btn-secondary w-14">월요일</button>
                    <button id="btnTue" type="button" class="btn btn-secondary w-14">화요일</button>
                    <button id="btnWed" type="button" class="btn btn-secondary w-14">수요일</button>
                    <button id="btnThu" type="button" class="btn btn-secondary w-14">목요일</button>
                    <button id="btnFri" type="button" class="btn btn-secondary w-14">금요일</button>
                    <button id="btnSat" type="button" class="btn btn-secondary w-14">K.K(토)</button>
                    <button id="btnSun" type="button" class="btn btn-secondary w-14">무파니(일)</button>
                </div>
            </div>
        </div>
    </div>
    <div class="row pt-3">
        <div class="col-12">
            <h1 class="text-center">할 일</h1>
            <div id="todo_body" class="p-2 border border-dark">
                <table id="tbTodo"class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">할 일</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="moveRow">
                        <th scope="row">1</th>
                        <td>
                            <div class="custom-control custom-checkbox">
                                <input id="checkbox1" type="checkbox" class="custom-control-input todo_input_checkbox">
                                <label class="custom-control-label font" for="checkbox1"> 돌 캐기</label>
                            </div>
                        </td>
                    </tr>
                    <tr class="moveRow">
                        <th scope="row">2</th>
                        <td>나무 베기</td>
                    </tr>
                    <tr class="moveRow">
                        <th scope="row">3</th>
                        <td>주민에게 레시피 받기1</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <input id="check" type="checkbox">
</div>
</body>
</html>
