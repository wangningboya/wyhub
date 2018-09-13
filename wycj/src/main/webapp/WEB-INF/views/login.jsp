<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/resource/css/bootstrap.min.css" />

    <script type="text/javascript" language="javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="/resource/js/bootstrap.min.js" ></script>
    <script type="text/javascript" language="javascript" src="resource/js/login.js"></script>
    <title>登录</title>
</head>
<body>
    <div style="position: fixed;width: 500px;height: 300px; left: 35%;;top: 30%;">
        <form class="form-horizontal" role="form">
        <div class="form-group">
            <label for="userAccount" class="col-sm-2 control-label">账号</label>
            <div class="col-sm-10">
                <input id="userAccount" type="text" class="form-control"  placeholder="请输入账号">
            </div>
        </div>
        <div class="form-group">
            <label for="userPwd" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input id="userPwd" type="password"  type="text" class="form-control"  placeholder="请输入密码">
            </div>
        </div>
        </form>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button onclick="login()"  class="btn btn-default">登录</button>
                <button onclick="javascrtpt:window.location.href='/register'" class="btn btn-default">注册</button>
            </div>
        </div>
    </div>

</body>
</html>
