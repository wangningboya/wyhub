$(document).ready(function() {

    $("#xixi").bootstrapTable({
        method: "post",
        url: "/findAllUser", // 获取表格数据的url
        cache: false, // 设置为 false 禁用 AJAX 数据缓存， 默认为true
        striped: true,  //表格显示条纹，默认为false
        height:window.innerHeight-50,
        sidePagination: 'client', // 设置为客户端分页
        //分页设置
        pagination: true, // 在表格底部显示分页组件，默认false
        pageList: [10, 20], // 设置页面可以显示的数据条数
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

        //参数
        // contentType: 'application/x-www-form-urlencoded',
        // queryParams: function (params) { // 请求服务器数据时发送的参数，可以在这里添加额外的查询参数，返回false则终止请求
        //     var temp={
        //         xixi:"aafadf"
        //     };
        //     return temp;
        // },
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
            },{
                title: "操作",
                align: 'center',
                valign: 'middle',
                width: 160, // 定义列的宽度，单位为像素px
                formatter: function (value, row, index) {
                    return '<button class="btn btn-warning btn-sm" onclick="look(\'' + row.userId + '\')">查看</button>';
                }
            }
        ]
        // onLoadSuccess: function(){  //加载成功时执行
        //     console.info("加载成功");
        // },
        // onLoadError: function(){  //加载失败时执行
        //     console.info("加载数据失败");
        // }

    } );
});

function look(uid) {
    window.location.href="/toUserManages?userId="+uid;
}
