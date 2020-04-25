<%--
  User: Suh
  Date: 2020-04-25
  Time: 오후 8:12
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
</body>
</html>
