<%--
  Created by IntelliJ IDEA.
  User: thlnkpad
  Date: 2018/5/26
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EditLab</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <meta charset="UTF-8">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
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
                                <li>
                                    <a href="#">Something else here</a>
                                </li>
                                <li class="divider">
                                </li>
                                <li>
                                    <a href="#">Separated link</a>
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
                    <span>修改实验室信息</span>
                </h1>
                <p>
                    <a class="btn btn-primary btn-large" href="#">Learn more</a>
                </p>
            </div>
            <form role="form" action="${pageContext.request.contextPath} /lab/editLab" method="post">
                <div class="form-group">
                    <label>实验室编号</label>
                    </label><input type="text" class="form-control" id="labIdInput" name="labId" value="${param.labId}" readonly/>
                </div>
                <div class="form-group">
                    <label for="locationInput">实验室位置</label><input type="text" class="form-control" id="locationInput" name="location"/>
                </div>
                <div class="form-group">
                    <label for="sizeInput">计算机数量</label><input type="text" class="form-control" id="sizeInput" name="size"/>
                </div>
               
                <%--<div class="form-group">--%>
                    <%--<label>选择身份</label>--%>
                    <%--<select class="form-control" name="role" readonly="">--%>
                        <%--<option>stu</option>--%>
                        <%--<option>admin</option>--%>
                    <%--</select>--%>
                <%--</div>--%>
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
