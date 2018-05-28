<%--
  Created by IntelliJ IDEA.
  User: shengyiqun
  Date: 2018/5/14
  Time: 下午8:49
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
                        <a class="navbar-brand" href="admin">系统首页</a>
                    </div>
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">


                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="#">登陆</a>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong
                                        class="caret"></strong></a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a href="#">Action</a>
                                    </li>
                                    <li>
                                        <a href="#">Another action</a>
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
            </div>
        </div>
        <div class="col-md-12 column">
            <div class="jumbotron">
                <h1>
                    用户信息管理
                </h1>
                <p>
                    <a class="btn btn-primary btn-large" href="addUserInput">添加用户</a>
                </p>
            </div>
            ${msg}
        </div>
    </div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">×
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    删除用户
                </h4>
            </div>
            <div class="modal-body">
                您确认要删除该用户吗？
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default"
                        data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary submitbtn" data-dismiss="modal">
                    删除
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</body>
<script src="https://code.jquery.com/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $(".submitbtn").click(function(){
            var r=confirm("确认要删除该用户？");
            if(r===true){
            var id = $(this).parent().parent().children('.id').text();
            console.log(id);
            var bool;
            $.ajax({
                data:{
                    id:id
                },
                type:"POST",
                url:"/user/deleteUser",
                success:function (msg) {
                    // alert(msg);
                    bool = msg;
                },
                error:function () {
                    alert("False!!!");
                }
            })

            $(this).parent().parent().remove();
            }
        });
        /*$(".editbtn").click(function(){
            var id = $(this).parent().parent().children('.id').text();
            console.log(id);
            var bool;
            $.ajax({
                data:{
                    id:id
                },
                type:"POST",
                url:"/user/editPage",
                success:function (msg) {
                    alert(msg);
                    bool = msg;
                },
                error:function () {
                    alert("False!!!");
                }
            })

        });*/
    });
    function alt() {
        alert("alalal");
    }
</script>
</html>
