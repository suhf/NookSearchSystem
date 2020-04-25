$(function() {
    $("#list").jqGrid({
        url: 'getTodoData.do',
        mtype : 'POST',
        datatype: 'json',
        jsonReader: {
            root: 'list'
        },
        styleUI: 'Foundation',
        colModel: [
            {name: 'uCheck', label : '체크'},
            {name: 'uContent', label : '할 일'},
            {name: 'uDay', label : '요일'}
        ],
        height: 'auto',
        rowNum: 10,
        pager: '#pager',
        autowidth : true
    });
});