<%@ page import="java.io.File" %><%--
  Created by IntelliJ IDEA.
  User: fengzipei
  Date: 12/19/15
  Time: 8:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Albums</title>
</head>
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
<style>
    body{
        margin-left: 100px;
        margin-right: 100px;
    }
    h2{
        color: navy;
    }
    .button-success {
        background: rgb(28, 184, 65); /* this is a green */
    }
    .button-error {
        background: rgb(202, 60, 60); /* this is a maroon */
    }
    .button-warning {
        background: rgb(66, 184, 221); /* this is an orange */
    }

</style>
<body>
<%
    String username = request.getAttribute("username").toString();
%>
<header>
<h1> Hello, <%= username%>. </h1>
</header>
<nav>
<form action="createServlet" method="post" class="pure-form" >
    <input class="pure-input-1-3" type="text" name="albumname" placeholder="Create new photo album" >
    <input type="hidden" name="username" value="<%=username%>">
    <input type="submit" class="pure-button pure-button-primary" value="Create">
</form>
</nav>
<h2> All Albums</h2>
<%
    File currentDirectory = new File("../webapps/file/" + username);
    File[] fileList = currentDirectory.listFiles();
    for (File file : fileList) {
        if (file.isDirectory()) {
%>
<div style="background-color: aliceblue; width:500px; border: 3px solid dodgerblue;">
    <h2 style="display: inline;" ><%=file.getName()%></h2>
    <form action="enterAlbumServlet" method="post" class="pure-form" >
    <input type="hidden" name="filename" value="<%=file.getName()%>">
    <input type="hidden" name="username" value="<%=username%>">
    <input type="submit" class="button-success pure-button" value="Enter">
</form>
<form action="deleteDirecoryServlet" method="post" class="pure-form" >
    <input type="hidden" name="username" value="<%=username%>">
    <input type="hidden" name="filename" value="<%=file.getAbsolutePath()%>">
    <input type="submit" class="button-error pure-button " value="Delete">
</form>
<form action="changeDirectoryNameServlet" method="post" class="pure-form" >
    <input type="text" name="newname" placeholder="New name">
    <input type="hidden" name="username" value="<%=username%>">
    <input type="hidden" name="filename" value="<%=file.getAbsolutePath()%>">
    <input type="submit" class="button-warning pure-button " value="Change name">
</form>
</div><br>
<% }
}
%>
</body>
</html>
