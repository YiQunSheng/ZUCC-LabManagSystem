<%--
  Created by IntelliJ IDEA.
  User: shengyiqun
  Date: 2018/5/25
  Time: 下午9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="jumbotron">
                <h1>
                    个人信息详情
                </h1>
                <p>
                    This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.
                </p>
                <p>
                    <a class="btn btn-primary btn-large" href="#">Learn more</a>
                </p>
            </div>
            <div class="list-group">
                <a href="#" class="list-group-item active">Home</a>
                <div class="list-group-item">
                    <h4 class="list-group-item-heading">
                        ID
                    </h4>
                    <p class="list-group-item-text">
                        ${id}
                    </p>
                </div>
                <div class="list-group-item">
                    <h4 class="list-group-item-heading">
                        用户名
                    </h4>
                    <p class="list-group-item-text">
                        ${name}
                    </p>
                </div>
                <div class="list-group-item">
                    <h4 class="list-group-item-heading">
                        密码
                    </h4>
                    <p class="list-group-item-text">
                        ${pwd}
                    </p>
                </div>
                <div class="list-group-item">
                    <h4 class="list-group-item-heading">
                        身份
                    </h4>
                    <p class="list-group-item-text">
                        ${role}
                    </p>
                </div>
            </div>
            <table class="table">
                <thead>
                <tr>
                    <th>
                        实验室ID
                    </th>
                    <th>
                        使用电脑ID
                    </th>
                    <th>
                        开始时间
                    </th>
                    <th>
                        结束时间
                    </th>
                    <th>
                        时长
                    </th>
                </tr>
                </thead>
                ${infoTable}
            </table>
        </div>
    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
