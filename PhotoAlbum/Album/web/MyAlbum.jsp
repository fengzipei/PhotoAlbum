<%@ page import="java.io.File" %><%--
  Created by IntelliJ IDEA.
  User: fengzipei
  Date: 12/18/15
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

<html lang="en">
<head>
    <title>My Photo Album</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
<style>
    form{
        text-align: center;
        alignment: center;
    }
    img{
        alignment: center;
    }
    body{
        margin-left: 100px;
        margin-right: 100px;
    }
    h1{
    }
</style>
<body>

<%
    String username = request.getAttribute("username").toString();
    String album = request.getAttribute("album").toString();
    File currentDirectory = new File("../webapps/file/" + username + File.separator + album);
    File[] files = currentDirectory.listFiles();
%>
<h1> Hello, <%= username%>. </h1>

<form accept-charset="UTF-8" action="jumpServlet" method="post" style="display: inline; " class="pure-form">
    <input class="button-small pure-button" type="submit" value="Home" name="button0"/>
    <input type="hidden" name = "username" value= <%=username%>>
</form>

<form method="POST" action="uploadServlet" enctype="multipart/form-data" class="pure-form">
    <input type="file" name="file" id="file" />
    <input type="hidden" value= <%="../webapps/file/" + username + File.separator + album%> name="destination"/>
    <input type="hidden" name = "username" value= <%=username%>>
    <input type="hidden" name = "album" value= <%=album%>>
    <input type="submit" value="Upload" name="upload" id="upload" class="button-small pure-button"/>
</form>
<%
    for(File file : files){
%>
<h2><%=file.getName()%></h2>
<img class = "pure-img" src= "<%="../file/" + username + File.separator + album + File.separator + file.getName()%>" width="500" align="middle">
<form accept-charset="UTF-8" action="deleteFileServlet" method="post" style="display: inline; " class="pure-form">
    <input type="hidden" name="filename" value=<%=file.getAbsolutePath()%> />
    <input class="button-small pure-button" type="submit" value="Delete" name="button0"/>
    <input class="button-small pure-button" onclick="location.href = '../file/<%=username%>/<%=album%>/<%=file.getName()%>';"  value="See original picture"/>
    <input type="hidden" name = "username" value= <%=username%>>
    <input type="hidden" name = "album" value= <%=album%>>
</form>
<form action="changeFileNameServlet" method="post" class="pure-form" style="display: inline;">
    <input type="text" name="newname" placeholder="New name">
    <input type="hidden" name="username" value="<%=username%>">
    <input type="hidden" name = "album" value= <%=album%>>
    <input type="hidden" name="filename" value="<%=file.getAbsolutePath()%>">
    <input type="submit" class="button-warning pure-button" value="Change name">
</form>
<br><br>
<%
    }
%><br>

</body>
</html>