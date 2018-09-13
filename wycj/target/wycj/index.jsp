<html>
<head>
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="/resource/js/xixi.js" ></script>
</head>

<body>
<h2>Hello World2!</h2>
<script type="text/javascript">
    $(function () {
        $("#putAndGetJson").click(function () {
            //发出一个请求，请头中携带json格式数据
            $.ajax({
                url: "json/shouJson",
                data: '{"stuId":12345678,"stuName":"xx","classId":11111111}',
                contentType: "application/json",
                type: "post",
                success: function (data) {  // data:服务端返回的数据
                    alert(JSON.stringify(data));
                },
                dataType: "json"
            });
        });

    });

</script>
<h2>hahah</h2>
<input type="button" id="putAndGetJson" value="传输和获取json数据">
</body>
</html>
