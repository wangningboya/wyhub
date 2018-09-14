$(document).ready(function () {
    $("#xixi").bootstrapTable({
        method: "post",
        url: "/getPrizeList", // 获取表格数据的url
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
        // search: true,						//是否启用搜索框
        // searchOnEnterKey: true,				//按回车触发搜索方法
        showColumns: true,                  //是否显示所有的列
        showRefresh: true,                  //是否显示刷新按钮
        showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
        cardView: false,                    //是否显示详细视图
        silent: true,                       //刷新事件必须设置

        //参数
        contentType: 'application/x-www-form-urlencoded',
        queryParams: function (params) { // 请求服务器数据时发送的参数，可以在这里添加额外的查询参数，返回false则终止请求
            var temp={
                limit:params.limit,
                offset:params.offset,
                type:"table"
            };
            return temp;
        },
//    sortName: 'id', // 要排序的字段
//    sortOrder: 'desc', // 排序规则
        columns: [
            {
                field: 'prizeName', // 返回json数据中的name
                title: '奖品名称', // 表格表头显示文字
                align: 'center', // 左右居中
                valign: 'middle' // 上下居中
            }, {
                field: 'prizeColor',
                title: '奖品颜色',
                align: 'center',
                valign: 'middle'
            }, {
                field: 'prizePro',
                title: '奖品概率',
                align: 'center',
                valign: 'middle'
            }, {
                title: "操作",
                align: 'center',
                valign: 'middle',
                width: 160, // 定义列的宽度，单位为像素px
                formatter: function (value, row, index) {
                    return '<button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal" data-prizeid="'+row.prizeId+'"  >修改</button>' +
                        '<button class="btn btn-warning btn-sm" onclick="del(\'' + row.prizeId + '\')">删除</button>';
                }
            }
        ],locale:'zh-CN',//中文支持,
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

    });

    $('#myModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget); // 触发事件的按钮
        var prizeId = button.data("prizeid"); // 解析出prizeid内容
        var modal = $(this); //获得模态框本身
        // modal.find('.modal-title').text('Message To ' + recipient)  // 更改将title的text
        // modal.find('.modal-body input').val(recipient)
        $.post(
            "getPrizeById",
            {
                prizeId: prizeId
            }, function (data) {
                var detail = '<div class="modal-header">' +
                    '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">' +
                    "X" +
                    '</button>' +
                    '<h4 class="modal-title" id="myModalLabel"> 修改奖品信息 </h4>' +
                    '</div>' +
                    '<div class="modal-body">' +

                    '<form class="form-horizontal" role="form">' +
                    '<div class="form-group">' +
                    '<label for="prizeName" class="col-sm-2 control-label">奖品名称</label>' +
                    '<div class="col-sm-10">' +
                    '<input type="text" class="form-control" id="prizeName" placeholder="请输入奖品名称" value="'+data.prizeName+'">' +
                    '</div>' +
                    '</div>' +

                    '<div class="form-group">' +
                    '<label for="prizeColor" class="col-sm-2 control-label">奖品颜色</label>' +
                    '<div class="col-sm-10">' +
                    '<input type="text" class="form-control" id="prizeColor" placeholder="请输奖品颜色" value="'+data.prizeColor+'">' +
                    '</div>' +
                    '</div>' +

                    '<div class="form-group">' +
                    '<label for="prizePro" class="col-sm-2 control-label">奖品概率</label>' +
                    '<div class="col-sm-10">' +
                    '<input type="text" class="form-control" id="prizePro" placeholder="请输奖品概率" value="'+data.prizePro+'">' +
                    '</div>' +
                    '</div>' +

                    '</form>' +

                    '</div>' +
                    '<div class="modal-footer">' +
                    '<button type="button" class="btn btn-default" data-dismiss="modal">关闭' +
                    '</button>' +
                    '<button type="button" class="btn btn-primary" onclick="edit(\'' + data.prizeId + '\')">' +
                    '提交更改' +
                    '</button>' +
                    '</div>'
                $("#haha").append(detail);
            }
        )
    })
    // $('#myModal').on('hidden.bs.modal', function () {
    //     $(".modal-header").remove();
    //     $(".modal-body").remove();
    //     $(".form-horizontal").remove();
    //     $(".modal-footer").remove();
    // })


});

function add() {
    if (!confirm("您确定要添加吗？")) {
        return;
    }
    $.post(
        "addPrize",
        {
            prizeName:$("#prizeName1").val(),
            prizeColor:$("#prizeColor1").val(),
            prizePro:$("#prizePro1").val()
        },
        function (data) {
            alert("添加奖品成功！");
            location.reload();
        }
    )
}

function edit(prizeId) {
    if (!confirm("您确定要修改吗？")) {
        return;
    }
    $.post(
        "editPrize",
        {
            prizeId: prizeId,
            prizeName:$("#prizeName").val(),
            prizeColor:$("#prizeColor").val(),
            prizePro:$("#prizePro").val()
        },
        function (data) {
            alert("修改成功！");
            location.reload();
        }
    )
}

function del(prizeId) {
    if (!confirm("您确定要删除吗？")) {
        return;
    }
    $.post(
        "delPrizeById",
        {
            prizeId: prizeId
        },
        function (data) {
            alert("删除成功！");
            location.reload();
        }
    )
}
