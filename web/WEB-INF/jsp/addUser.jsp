<%--
  Created by IntelliJ IDEA.
  User: shengyiqun
  Date: 2018/5/23
  Time: 下午7:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddUser</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
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
                    <span>添加用户</span>
                </h1>
                <p>
                    <a class="btn btn-primary btn-large" href="#">Learn more</a>
                </p>
            </div>
            <form role="form" action="${pageContext.request.contextPath} /user/addUser">
                <div class="form-group">
                    <label for="userIdInput">用户ID</label><input type="text" class="form-control" id="userIdInput" name="userId"/>
                </div>
                <div class="form-group">
                    <label for="userNameInput">用户名</label><input type="text" class="form-control" id="userNameInput" name="userName"/>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">密码</label><input type="text" class="form-control" id="exampleInputPassword1" name="pwd"/>
                </div>
                <div class="form-group">
                    <label>选择身份</label>
                    <select class="form-control" name="role">
                        <option>stu</option>
                        <option>admin</option>
                    </select>
                </div>
                <input type="submit" class="btn btn-default">添加用户!</input>

            </form>
        </div>
    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
