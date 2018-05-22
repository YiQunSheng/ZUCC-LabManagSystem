<%@ page language="java" pageEncoding="GB2312" %>

<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
<head>
<title>Lomboz JSP</title>
</head>
<body bgcolor="#FFFFFF">
<%--<form action="user?method=logincheck" method="post">--%>
<form action="${pageContext.request.contextPath} /hello/loginUser" method="post">
  ำรปงฃบ<input type="text" name="userid"/><br>
  รÜย๋ฃบ<input type="password" name="pwd"/><br>
  <input type="submit" value="ตวยฝ"/><br>
</form>
<%
   String errmsg=(String)session.getAttribute("errormsg");
   if(errmsg!=null){
     session.removeAttribute("errormsg");
     out.println(errmsg);
   }
%>
</body>
</html>