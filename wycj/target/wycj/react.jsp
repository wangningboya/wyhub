<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/26
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.bootcss.com/react/16.4.0/umd/react.development.js"></script>
    <script src="https://cdn.bootcss.com/react-dom/16.4.0/umd/react-dom.development.js"></script>
    <script src="https://cdn.bootcss.com/babel-standalone/6.26.0/babel.min.js"></script>
</head>
<body>
<div id="example"></div>
<script type="text/babel">

    function tick() {
        const element = (
                <div>
                    <h1>Hello, world!</h1>
                    <h2>现在是 {new Date().toLocaleTimeString()}.</h2>
                </div>
        );
        ReactDOM.render(
            element,
            document.getElementById('example')
        );
    }

    setInterval(tick, 1000);
</script>
</body>
</html>
