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

    <script>
        gaulhoExg = /\( *[0-9]+ *\/ *[0-9]+ *\)/;
        let dataList;
        $(function(){
            makeTable();
            $("#btnAddTodo").on("click", AddTodo);
        });

        function getContentType(content){
            console.log(gaulhoExg.test(content));
            if( gaulhoExg.test(content) ){
                return 'stack';
            }else{
                return 'normal';
            }
        }

        function toggleDel($input){
            let $del = $input.closest("del");
            if ($del.get(0) == undefined) {
                $input.wrap("<del></del>");
            } else {
                $input.unwrap("del");
            }
        }

        function addDel($input){
            $input.wrap("<del></del>");
        }

        function removeDel($input){
            $input.unwrap("del");
        }

        function showHideCheck($button, bool){
            let $img = $button.find("i");
            if(!bool){


                $img.removeClass("leafCheck");
                $img.hasClass("leafHide");
                $img.hide();

            }else{
                $img.removeClass("leafHide");
                $img.addClass("leafCheck");
                $img.show();
                console.log("leaf Show");
            }
        }


        function toggleCheck($button){
            let $img = $button.find("svg");
            if($img.hasClass("leafCheck")){
                console.log("leaf HIde");
                $img.removeClass("leafCheck");
                $img.hasClass("leafHide");
                $img.hide();

            }else{
                $img.removeClass("leafHide");
                $img.addClass("leafCheck");
                $img.show();
                console.log("leaf Show");
            }
        }

        function toggleCheckByEvent(event){
            let $img = event.data.button.find("svg");
            if($img.hasClass("leafCheck")){
                $img.removeClass("leafCheck");
                $img.hasClass("leafHide");
                $img.hide();
            }else{
                $img.removeClass("leafHide");
                $img.addClass("leafCheck");
                $img.show();
            }
        }


        function addTrEvent($tr){
            $tr.on("click", function() {
                let $input = $(this).find("input[name='content']");
                let $button = $(this).find("button");
                let content = $input.val();
                let type = getContentType(content);
                console.log("content : " + content);
                console.log(type);
                let sub1;
                let sub2;
                if (type == 'normal') {
                    toggleDel($input);
                    toggleCheck($button);
                } else if (type == 'stack') {
                    let newContent = content;
                    let index = newContent.indexOf('/');
                    let curCount = pickNumber(newContent, index - 1, -1);
                    let maxCount = pickNumber(newContent, index + 1, 1);
                    let beforeContent = newContent.substring(0, findGualho(content, index, -1));
                    let afterContent = newContent.substring(findGualho(content, index, 1) - 1);
                    let $del = $input.closest("del");
                    if (curCount == maxCount) {
                        if ($del.get(0) == undefined) {
                            addDel($input);
                            toggleCheck($button);
                        } else {
                            removeDel($input);
                            toggleCheck($button);
                            curCount = 0;
                            content = beforeContent + " " + curCount + " / " + maxCount + " " + afterContent;
                            $input.val(content);
                        }
                    } else {
                        ++curCount;
                        content = beforeContent + " " + curCount + " / " + maxCount + " " + afterContent;
                        $input.val(content);
                        if (curCount == maxCount) {
                            if ($del.get(0) == undefined) {
                                addDel($input);
                                toggleCheck($button);
                            }
                        }
                    }
                    sub1 = curCount;
                    sub2 = maxCount;
                }
                let json = {};

                let originStr = $input.val();
                if( type == 'stack'){
                    let gaulhoStr = gaulhoExg.exec(originStr)[0];
                    originStr = originStr.replace(gaulhoStr, '');
                }

                json.todoNo = $(this).find(".hiddenClass").attr("name");
                json.content = originStr;
                json.check = $button.find("svg").hasClass("leafCheck")+"";
                json.sub1 = sub1;
                json.sub2 = sub2;

                let parsed = JSON.stringify(json);


                $.ajax({
                    type: "POST",
                    url: "todoUpdate.do",
                    data: parsed,
                    datatype: "json",
                    contentType: "application/json",
                    success: function (data) {

                        if( data.result == "1"){

                        }else{

                        }
                    }
                });
            });
        }

        function findGualho(str, point, direction){

            if( direction <= 0 ){
                for( let i = point; i >= 0 ; --i){
                    let char = str.charAt(i);
                    if( char == '('){

                        return i+1;
                    }
                }
            }else{
                for( let i = point; i < str.length; ++i){
                    let char = str.charAt(i);
                    if( char == ')'){

                        return i+1;
                    }
                }
            }

            return -1;
        }

        function pickNumber(str, point, direction){
            let returnStr = "";
            if(direction > 0){
                for( let  i = point; i < str.length; ++i){
                    let char = str.charAt(i);
                    if( char == " "){

                    }else if( isNumber(char )){
                        returnStr = returnStr.concat(char);
                    }else{
                        break;
                    }
                }
            }else{
                for( let i = point; i >= 0; --i){
                    let char = str.charAt(i);
                    if( char == " ") {
                    }else if( isNumber(char )){
                        returnStr = char.concat(returnStr);
                    }else{
                        break;
                    }
                }
            }
            return returnStr;
        }


        function isNumber(character){
            let res = /^[0-9]+$/;
            return res.test(character);
        }

        function makeTable(){
            $.ajax({
                type: "POST",
                url: "getTodoData.do",
                datatype: "json",
                contentType: "application/json",
                success: function (data) {

                    dataList = data.list;
                    $(dataList).each(function(index, item){
                       AddTr(index, item);
                    });
                }
            });
        }
        function AddTr(index, item){
            let $tableBody = $("#tbodyTodo");
            let $tr = $("<tr>");

            addTrEvent($tr);
            let $td = $("<td>");
            $td.addClass("text-center");
            $td.css("vertical-align", "middle");
            $tableBody.append($tr);
            $tr.append($td);
            $td.html(index+1);
            <!-- # 숫자 끝 -->

            <!-- 체크 부분 -->
            $td = $("<td>");
            $td.addClass("text-center");
            $td.css("vertical-align", "middle");
            let $btnLeaf = $("<ct:button_leaf />");
            $td.append($btnLeaf);

            let $btnIcon = $btnLeaf.find("i");

            if( item.uCheck == "true"){
                $btnIcon.removeClass("leafHide");
                $btnIcon.addClass("leafCheck");
            }else{
                $btnIcon.removeClass("leafCheck");
                $btnIcon.addClass("leafHide");
            }

            $tr.append($td);
            <!-- 체크 부분 끝 -->

            <!-- content 부분 -->
            $td = $("<td>");
            $td.addClass("text-left");
            $td.css("vertical-align", "middle");
            $tr.append($td);
            let $todoInput = $("<ct:todo_input />");

            let $hiddenInput = $todoInput.closest(".hiddenClass");

            $hiddenInput.attr("name", item.uNo);
            $hiddenInput.val(item.uNo);

            let newContent = item.uContent;
            let type = item.uSub2;
            if( type) {

                let curCount = item.uSub1;
                let maxCount = item.uSub2;


                newContent =  "( " + curCount + " / " + maxCount + " ) " + newContent ;
                $todoInput.val(newContent);
            }else{
                $todoInput.val(newContent);
            }
            $todoInput.css("background-color", "rgba(0,0,0,0)");
            $td.append($todoInput);

            let $input = $tr.find("input[name='content']");

            console.log($input.get(0));

            if( item.uCheck == "true"){
                addDel($input);
            }
            <!-- content 끝 -->
        }


        //할일 추가 버튼 눌렀을때 실행되는 함수
        let $addTodoTr;
        function AddTodo(){
            let $tbodyTodo = $("#tbodyTodo");
            let count = $tbodyTodo.find("tr").length;
            $addTodoTr = $("<tr>");
            $tbodyTodo.append($addTodoTr);
            //숫자 부분
            ++count;
            let $td = $("<td>");
            $addTodoTr.append($td);
            $td.html(count.toString());

            //체크 박스 부분
            $td = $("<td>");
            $addTodoTr.append($td);
            let $btnLeaf = $("<ct:button_leaf />");
            showHideCheck($btnLeaf, false);
            $btnLeaf.on("click", { button : $btnLeaf } , toggleCheckByEvent);

            $td.append($btnLeaf);

            //content 부분
            $td = $("<td>");
            $addTodoTr.append($td);

            //입력폼 옆으로 하기위해 div 추가
            let $divRow = $("<div class='row'>");
            $td.append($divRow);
            //할일 부분 입력폼
            let $divCol = $("<div class='col'>");
            $divRow.append($divCol);
            let $input = $("<input type='text' name='ipTodo' class='form-control border-0 inputAddTodoText' placeholder='ex ) 주민에게 인사하기'>");
            $input.on("keydown", onChangeTodo);
            $divCol.append($input);

            //최대치 부분 입력폼
            $divCol = $("<div class='col'>");
            $divRow.append($divCol);
            let $inputMax = $("<input type='number' name='ipMax' class='form-control border-0 inputADdTodoNumber mt-xl-0 mt-sm-2' placeholder='최대치를 입력해라 구리. 안써도 된다 구리.' > ");
            $divCol.append($inputMax);
            $input.get(0).focus();

            //저장 버튼
            $divCol = $("<div class='col d-flex justify-content-end'>");
            $divRow.append($divCol);
            let $btnSave = $("<button type='button' class='btn btn-primary' >추가한다 구리</button> ");

            $divCol.append($btnSave);
            $btnSave.on("click", insertLine);
        }
        function insertLine() {
            let $tr = $(this).parents("tr");
            let content = $(this).parent().parent().find("input[name='ipTodo']").val();
            let sub2 = $(this).parent().parent().find("input[name='ipMax']").val();
            let check = $tr.find("svg").hasClass("leafCheck");
            let lineNo = $tr.find("td:first").html();

            let exp = /[/()]+/;
            if( exp.test(content) ){
                showMessage("'/', '(', ')' 이 세 문자는 쓸수 없다 구리");
                return;
            }


            let json= {};
            json.content= content;
            json.sub2 = sub2;
            json.check = check;
            json.lineNo = lineNo;

            let parsed = JSON.stringify(json);
            //controller에 추가
            $.ajax({
                type: "POST",
                url: "insertTodo.do",
                data: parsed,
                datatype: "json",
                contentType: "application/json",
                success: function (data) {
                    if(data.result == "true"){
                        $tr.remove();
                        alert("입력 성공");
                        AddTr(parseInt(lineNo)-1, data.item);
                    }else{
                        alert("입력 실패");
                    }
                }
            });
        }

        function onChangeTodo(event){

            let key = event.which;
            let isShift = event.shiftKey;
            if((isShift && key == 57) || (isShift && key == 48) || (!isShift && key == 191)){

                event.preventDefault();
            }
        }

        function showMessage(message){
            alert(message);
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
                        <th class="text-center" scope="col" style="width: 5%; min-width: 4rem">#</th>
                        <th class="text-center" scope="col" style="width: 10%; min-width: 4rem">체 크</th>
                        <th class="text-left" scope="col" style="width: 85%; min-width: 4rem">할 일</th>
                    </tr>
                    </thead>
                    <tbody id="tbodyTodo">

                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-12 d-flex justify-content-center">
            <button id="btnAddTodo" class="btn btn-primary" type="button">할 일 추가</button>
        </div>
    </div>
</div>
</body>
</html>
