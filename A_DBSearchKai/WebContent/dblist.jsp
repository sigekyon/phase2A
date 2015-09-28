<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MainControl</title>
</head>
<body>
<jsp:useBean id="dbdata" scope="request" class="bean.testBean"/>
ID：<jsp:getProperty name="dbdata" property="registrant_id"/><br>
PW：<jsp:getProperty name="dbdata" property="registrant_password"/><br>
</body>
</html>