<%--
  Created by IntelliJ IDEA.
  User: fengzipei
  Date: 12/18/15
  Time: 00:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Photo Album</title>
</head>
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
<style>
  form {
    margin: 0 auto;
    width:250px;
  }
  h1{
    text-align: center;
  }
  a{
    text-align: center;
  }
  body{
    background: url("http://127.0.0.1:8080/file/test/c2fffc4e-f67a-4970-94ed-880748932ded.jpg") no-repeat center center fixed;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;
  }
</style>
<body>
<div align="center">
  <h1 class="hero-tagline">Welcome to Photo Album</h1><br><br>
  <form action="dispatcherServlet" method="post" class="pure-form">
  <input type="text" name="username" placeholder="Username"><br><br>
  <input type="password" name="password" placeholder="Password"><br><br>
  <input type="submit" class="pure-button pure-button-primary" value="Login in"><br>
</form><br>
<a href="signup.jsp">New User?</a>
</body>
</html>
