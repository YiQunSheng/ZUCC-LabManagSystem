<%@ page language="java" pageEncoding="GB2312" %>

<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
<title>Lomboz JSP</title>
</head>
<body bgcolor="#FFFFFF">
<%--<form action="user?method=logincheck" method="post">--%>
<form <%--action="${pageContext.request.contextPath} /hello/loginUser" method="post"--%>>
  �û���<input type="text" name="userId"/><br>
  ���룺<input type="password" name="pwd"/><br>
  <input type="submit" value="��½" id="submit1"/><br>
</form>
<%--<%
   String errmsg=(String)session.getAttribute("errormsg");
   if(errmsg!=null){
     session.removeAttribute("errormsg");
     out.println(errmsg);
   }
%>--%>
<script type="text/javascript">
    $(function() {
        $("#submit1").click(function() {
            var json = {
                'username':$(':input[name=userId]').val(),
                'password':$(':input[name=pwd]').val()
            };
            //json�ַ��� {"username":"admin","password":"123456"}
            var postdata = JSON.stringify(json);//json����ת��json�ַ���
            alert(postdata);
            $.ajax({
                type : 'POST',
                contentType : 'application/json',//ע������
                /**
                 *(Ĭ��: true) Ĭ������£�ͨ��dataѡ��ݽ��������ݣ������һ������(�����Ͻ�ֻҪ�����ַ���)��
                 * ���ᴦ��ת����һ����ѯ�ַ����������Ĭ���������� "application/x-www-form-urlencoded"��
                 * ���Ҫ���� DOM ����Ϣ��������ϣ��ת������Ϣ��������Ϊ false��
                 */
                processData : false,
                url : '/user/login',
                dataType : 'json',
                data : postdata,
                success : function(data) {
                    alert('username : '+data.username+'\npassword : '+data.password);
                },
                error : function() {
                    alert('error...');
                }
            });
        });
    });
</script>
</body>
</html>