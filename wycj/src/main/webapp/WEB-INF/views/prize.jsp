<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="/resource/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/resource/css/bootstrap-table.css" />

    <script type="text/javascript" src="/js/jquery-1.11.1.min.js" ></script>
    <script type="text/javascript" src="/resource/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="/resource/js/bootstrap-table.js" ></script>
    <script type="text/javascript" src="/resource/js/bootstrap-table-zh-CN.js" ></script>

    <script type="text/javascript" src="/resource/js/prize.js" ></script>
    <title>奖品管理</title>
    <input type="hidden" id="account" value="${account}"/>
</head>
<body>
<div id="welcome" style="float: right">
    <span style="color: red;font-weight: bold">欢迎你：${account.userName}</span>
    <button onclick="javascrtpt:window.location.href='/logout'" style="background: red" >登出</button>
</div>
<button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#addPrize" >添加奖品</button>
<div class="panel panel-default">
    <div class="panel-body">
        <table id="xixi">
        </table>
    </div>
</div>
<div class="modal fade" id="addPrize" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header"> 
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"> 
                X
                </button> 
            <h4 class="modal-title" id="myModalLabel"> 添加奖品信息 </h4>
            </div> 
            <div class="modal-body"> 

            <form class="form-horizontal" role="form">
                <div class="form-group">
                    <label for="prizeName1" class="col-sm-2 control-label">奖品名称</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="prizeName1" placeholder="请输入奖品名称" >
                        </div>
                    </div>

                <div class="form-group">
                    <label for="prizeColor1" class="col-sm-2 control-label">奖品颜色</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="prizeColor1" placeholder="请输奖品颜色" >
                        </div>
                    </div>

                <div class="form-group">
                    <label for="prizePro1" class="col-sm-2 control-label">奖品概率</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="prizePro1" placeholder="请输奖品概率" >
                        </div>
                    </div>

                </form>

            </div> 
            <div class="modal-footer"> 
            <button type="button" class="btn btn-default" data-dismiss="modal">关闭 
                </button> 
            <button type="button" class="btn btn-primary" onclick="add()" >
                提交更改 
            </button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" id="haha">
        </div>
    </div>
</div>
</body>
</html>