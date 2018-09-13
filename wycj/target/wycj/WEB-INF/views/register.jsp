<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/26
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/resource/css/bootstrap.min.css" />

    <script type="text/javascript" language="javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="/resource/js/bootstrap.min.js" ></script>
    <script type="text/javascript" language="javascript" src="resource/js/register.js"></script>
    <title>注册</title>
</head>
<body>
    <%--账号：<input type="text" id="userAccount" name="userAccount"><br/>--%>
    <%--密码  ：<input type="text" id="userPwd" name="userPwd"><br/>--%>
    <%--姓名：<input type="text" id="userName" name="userName"><br/>--%>
    <%--手机  ：<input type="text" id="userTel" name="userTel"><br/>--%>
    <%--邮箱：<input type="text" id="userEmail" name="userEmail"><br/>--%>
    <%--性别  ：<input type="text" id="userSex" name="userSex"><br/>--%>
    <%--收货地址  ：<input type="text" id="userAddress" name="userAddress"><br/>--%>
    <div style="position: fixed;width: 500px;height: 300px; left: 35%;;top: 30%;">
        <form class="form-horizontal" role="form">
            <div class="form-group">
                <label for="userAccount" class="col-sm-2 control-label">账号</label>
                <div class="col-sm-10">
                    <input id="userAccount" type="text" class="form-control"  placeholder="请输入账号" oninput="checkAccount(this)">
                    <p id="check" style="color: red;font-weight: bold" hidden="hidden">*用户名重复</p>
                </div>
            </div>
            <div class="form-group">
                <label for="userPwd" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10">
                    <input id="userPwd" type="text" class="form-control"  placeholder="请输入密码">
                </div>
            </div>
            <div class="form-group">
                <label for="userName" class="col-sm-2 control-label">姓名</label>
                <div class="col-sm-10">
                    <input id="userName" type="text" class="form-control"  placeholder="请输入姓名">
                </div>
            </div>
            <div class="form-group">
                <label for="userTel" class="col-sm-2 control-label">手机</label>
                <div class="col-sm-10">
                    <input id="userTel" type="text" class="form-control"  placeholder="请输入手机">
                </div>
            </div>
            <div class="form-group">
                <label for="userEmail" class="col-sm-2 control-label">邮箱</label>
                <div class="col-sm-10">
                    <input id="userEmail" type="text" class="form-control"  placeholder="请输入邮箱">
                </div>
            </div>
            <div class="form-group">
                <label for="userSex" class="col-sm-2 control-label">性别</label>
                <div class="col-sm-10">
                    <input id="userSex" type="text" class="form-control"  placeholder="请输入性别">
                </div>
            </div>
            <div class="form-group">
                <label for="userAddress" class="col-sm-2 control-label">收货地址</label>
                <div class="col-sm-10">
                    <input id="userAddress" type="text" class="form-control"  placeholder="请输入收货地址">
                </div>
            </div>
        </form>

        <button id="reButton" onclick="register()">注册</button>
    </div>
</body>
</html>
