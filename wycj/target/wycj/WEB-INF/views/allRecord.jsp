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

    <script type="text/javascript" src="/resource/js/allRecord.js" ></script>
    <title>所有中奖信息</title>
    <input type="hidden" id="account" value="${account}"/>
</head>
<body>
<div id="welcome" style="float: right">
    <span style="color: red;font-weight: bold">欢迎你：${account.userName}</span>
    <button onclick="javascrtpt:window.location.href='/logout'" style="background: red" >登出</button>
</div>
<div class="panel panel-default">
    <div class="panel-body">
        <table id="xixi">
        </table>
    </div>
</div>
</body>
</html>