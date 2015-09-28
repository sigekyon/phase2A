<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>アンケート結果</title>
</head>
<body>
<h1>アンケート結果</h1>

<%
String name = request.getAttribute("name").toString();
%>


氏名：<%=name %>
<br/><br/>
<a href="check.html">戻る</a>
</body>
</html>