<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>登陆</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <!-- 引入 Bootstrap -->
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
  <div class="row clearfix">
    <div class="col-md-12 column center-block">
      <div class="page-header">
        <h1>
          实验室管理系统 <small>登陆界面</small>
        </h1>
      </div>
      <form class="form-horizontal" role="form">
        <div class="form-group">
          <label for="userId" class="col-sm-2 control-label">用户ID</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="userId" />
          </div>
        </div>
        <div class="form-group">
          <label for="pwd" class="col-sm-2 control-label">Password</label>
          <div class="col-sm-10">
            <input type="password" class="form-control" id="pwd" />
          </div>
        </div>

      </form>
      <div class="col-sm-offset-2 col-sm-10">
        <button  class="btn btn-primary submitbtn">Login</button>
      </div>
    </div>
  </div>
</div>
</body>

<script src="https://code.jquery.com/jquery.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $(".submitbtn").click(function(){

            var userId = $("#userId").val();
            var pwd = $("#pwd").val();
            console.log(userId);
            $.ajax({
                data:{
                    userId:userId,
                    pwd:pwd
                },
                type:"POST",
                url:"/user/login",
                success:function (msg) {
                    // alert(msg);

                    if(msg==="admin") window.location.href="/user/admin";
                    else　alert(msg);
                },
                error:function () {
                    alert("False!!!");
                }
            })



        });
    });
</script>
</html>