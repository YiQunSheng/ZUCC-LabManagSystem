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
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <nav class="navbar navbar-default" role="navigation">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/user/admin">系统首页</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">


                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#">您好，${userName}</a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" >用户<strong
                                    class="caret"></strong></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="#">信息</a>
                                </li>
                                <li>
                                    <a href="/user/logout">Logout</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>

            </nav>
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
                    <label for="userIdInput">用户ID</label><input type="text" class="form-control" id="userIdInput" name="userId" placeholder="请输入8位Id" minlength="8" maxlength="8" required/>
                </div>
                <div class="form-group">
                    <label for="userNameInput">用户名</label><input type="text" class="form-control" id="userNameInput" name="userName" placeholder="请输入3-30位用户名" minlength="3" maxlength="30" required/>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">密码</label><input type="text" class="form-control" id="exampleInputPassword1" name="pwd" placeholder="请输入3-15位密码" minlength="3" maxlength="15" required/>
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
<%
    String msg =(String)request.getAttribute("msg");
%>
<script src="https://code.jquery.com/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
    var msg1 = '<%=msg%>';
    if(msg1!=='null'){
        alert(msg1);
    }
</script>
</html>
