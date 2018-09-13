$(function () {
    initTable();

});

function initTable() {
    $("#xixi").bootstrapTable({
        method: "post",
        url: "/findUserPrizeDtoList", // 获取表格数据的url
        cache: false, // 设置为 false 禁用 AJAX 数据缓存， 默认为true
        striped: true,  //表格显示条纹，默认为false
        height:window.innerHeight-50,
        sidePagination: 'server', // 设置为服务端分页
        // sidePagination: 'client',
        dataField:"rows",//返回的想要放到列表上的数据
        //分页设置
        pagination: true, // 在表格底部显示分页组件，默认false
        pageList: [10, 20, 50], // 设置页面可以显示的数据条数
        pageSize: 10, // 页面数据条数
        pageNumber: 1, // 首页页码
        //工具栏
        // search:true,						//是否启用搜索框
        // searchOnEnterKey:true,				//按回车触发搜索方法
        showColumns: true,                  //是否显示所有的列
        showRefresh: true,                  //是否显示刷新按钮
        showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
        cardView: false,                    //是否显示详细视图
        silent: true,                       //刷新事件必须设置

        // 参数
        contentType: 'application/x-www-form-urlencoded', //post必须定义
        queryParams: function (params) { // 请求服务器数据时发送的参数，可以在这里添加额外的查询参数，返回false则终止请求
            console.log(params);
            var temp={
                limit:params.limit,
                offset:params.offset
            };
            return temp;
        },
//    sortName: 'id', // 要排序的字段
//    sortOrder: 'desc', // 排序规则
        columns: [
            {
                field: 'userAccount', // 返回json数据中的name
                title: '账号', // 表格表头显示文字
                align: 'center', // 左右居中
                valign: 'middle' // 上下居中
            }, {
                field: 'userName',
                title: '用户名',
                align: 'center',
                valign: 'middle'
            }, {
                field: 'prizeName',
                title: '奖品',
                align: 'center',
                valign: 'middle'
            }, {
                field: 'prizeTime',
                title: '中奖时间',
                align: 'center',
                valign: 'middle',
                formatter: function (value, row, index) {
                    var date=new Date();
                    date.setTime(value);
                    var year=date.getFullYear();
                    var month=(date.getMonth()+1);
                    var day=date.getDate();
                    var hours=date.getHours();
                    var minutes=date.getMinutes();
                    var seconds=date.getSeconds();
                    if(hours<10){
                        hours="0"+hours
                    }
                    if(minutes<10){
                        minutes="0"+minutes
                    }
                    if(seconds<10){
                        seconds="0"+seconds
                    }
                    return year+'年'+month+"月"+day+"日 "+hours+":"+minutes+":"+seconds;
                }
            }, {
                field: 'state',
                title: '领奖状态',
                align: 'center',
                valign: 'middle',
                formatter: function (value, row, index) {
                    if(value=="0"){
                        return "未领奖";
                    }
                    if(value=="1"){
                        return "<p style='color: red;font-weight: bold'>已领奖</p>";
                    }
                }
            }, {
                title: "操作",
                align: 'center',
                valign: 'middle',
                width: 160, // 定义列的宽度，单位为像素px
                formatter: function (value, row, index) {
                    return '<button class="btn btn-warning btn-sm" onclick="del(\'' + row.id + '\')">删除</button>';
                }
            }
        ], locale:'zh-CN',//中文支持,
        responseHandler:function(res){
            //在ajax获取到数据，渲染表格之前，修改数据源
            console.log(res);
            return res;
        },
        onLoadSuccess: function(){  //加载成功时执行
            console.info("加载成功");
        },
        onLoadError: function(){  //加载失败时执行
            console.info("加载数据失败");
        }

    } );
}

function del(upid) {
    if(!confirm("您确定要删除吗？")){
        return;
    }
    $.post(
        "delUserPrizeById",
        {
            id:upid
        },
        function (data) {
            alert("删除成功！");
            location.reload();
        }
    )
}
