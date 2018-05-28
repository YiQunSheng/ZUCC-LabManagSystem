<%--
  Created by IntelliJ IDEA.
  User: thlnkpad
  Date: 2018/5/26
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddUser</title>
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
                    <span>添加实验室</span>
                </h1>
                <p>
                    <a class="btn btn-primary btn-large" href="#">Learn more</a>
                </p>
            </div>
            <form role="form" action="${pageContext.request.contextPath} /lab/addLab" method="post">
                <div class="form-group">
                    <label for="labIdInput">实验室编号</label><input type="text" class="form-control" id="labIdInput" name="labId"/>
                </div>
                <div class="form-group">
                    <label for="locationInput">实验室位置</label><input type="text" class="form-control" id="locationInput" name="location"/>
                </div>
                <div class="form-group">
                    <label for="sizeInput">实验室计算机数量</label><input type="text" class="form-control" id="sizeInput" name="size"/>
                </div>
                <%--<div class="form-group">--%>
                    <%--<label>选择身份</label>--%>
                    <%--<select class="form-control" name="role">--%>
                        <%--<option>stu</option>--%>
                        <%--<option>admin</option>--%>
                    <%--</select>--%>
                <%--</div>--%>
                <input type="submit" class="btn btn-default" value="添加实验室"/>

            </form>
        </div>
    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
