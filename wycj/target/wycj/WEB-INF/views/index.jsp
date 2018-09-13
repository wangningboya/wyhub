<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

<title>鑫义皇冠赌场</title>
</head>
<input type="hidden" id="account" value="${account}"/>
<input type="hidden" id="userId" value="${account.userId}"/>
<input type="hidden" id="roleId" value="${account.roleId}"/>
<input type="hidden" id="authList" value="${authList}"/>
<body background="/resource/images/background.jpg" style="background-size:100% 100%">
	<div id="welcome" style="float: right">
		<span style="color: red;font-weight: bold">欢迎你：${account.userName}</span>
		<button onclick="javascrtpt:window.location.href='/logout'" style="background: red" >登出</button>
	</div>
	<div id="menu" style="float: left"></div>
	<div style="margin:auto;width: 150px;height: 50px"  >
		<span style="font-weight: bold;color: red;font-size: 30px">抽奖页面</span>
	</div>
	<div>
		<div style="margin: 0 auto;width: 800px">
			<canvas style="margin: auto" id="cvs" width="800px" height="600px">
			</canvas>
			<div id="zz" style="transform-origin: 50% 100%;width: 30px;height: 250px;position: relative; left: 385px;top: -550px">
				<img src="../../resource/images/zz.png" style="width: 30px;height: 250px">
			</div>
		</div>
		<button onclick="xz()" style="width: 100px;height: 50px;position: relative;left: 880px;top: -200px">开始抽奖</button>
		<div id="prizeTable" style="position: relative;top: -750px;width:180px;background: #EEE0E5">
		</div>
	</div>



</body>
<script type="text/javascript" language="javascript" src="js/jquery-1.11.1.min.js"></script>

<script type="text/javascript" language="javascript" src="resource/js/rotary.js"></script>
<script type="text/javascript" language="javascript" src="/resource/js/index.js"></script>
</html>
