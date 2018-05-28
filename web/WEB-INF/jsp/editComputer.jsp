<%--
  Created by IntelliJ IDEA.
  User: thlnkpad
  Date: 2018/5/26
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>EditComputer</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <meta charset="UTF-8">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>实验室管理系统ZUCCLabs</small>
                </h1>
            </div>
            <div class="jumbotron">
                <h1>
                    <span>修改计算机信息</span>
                </h1>
                <p>
                    <a class="btn btn-primary btn-large" href="#">Learn more</a>
                </p>
            </div>
            <form role="form" action="${pageContext.request.contextPath} /computer/editComputer" method="post">
                <div class="form-group">
                    <label>计算机编号</label>
                    </label><input type="text" class="form-control" id="computerIdInput" name="computerId" value="${param.computerId}" readonly/>
                </div>
                <div class="form-group">
                    <label for="ipAddressInput">ip地址</label><input type="text" class="form-control" id="ipAddressInput" name="ipAddress"/>
                </div>
                <div class="form-group">
                    <label for="ipAddressInput">选择状态</label><input type="text" class="form-control"  name="status" value="未被使用" readonly/>
                </div>
                <input type="submit" class="btn btn-default" value="修改"/>

            </form>
        </div>
    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
