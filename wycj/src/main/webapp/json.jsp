<%--<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>--%>

<%--<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">--%>
<html>
  <head>
    <title>json数据处理</title>
    
	<%--<meta http-equiv="pragma" content="no-cache">--%>
	<%--<meta http-equiv="cache-control" content="no-cache">--%>
	<%--<meta http-equiv="expires" content="0">    --%>
	<%--<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">--%>
	<%--<meta http-equiv="description" content="This is my page">--%>
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>

  </head>
  
  <body>
      <script type="text/javascript">
      	$(function(){
      		$("#putAndGetJson").click(function(){
      			//发出一个请求，请头中携带json格式数据
      			$.ajax({
      				url:"json/shouJson",
      				data:'{"stuId":12345678,"stuName":"xx","classId":11111111}',
      				contentType:"application/json",
      				type:"post",
      				success:function(data){  // data:服务端返回的数据
      					alert(JSON.stringify(data));	
      				},
      				dataType:"json"
      			});
      		});
      		
      	});
      
      </script>
      <input type="button" id="putAndGetJson" value="传输和获取json数据">
  </body>
</html>
