<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, javax.naming.*, javax.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>データベースへの接続</title>
</head>
<body>
<%
Context context = new InitialContext();
DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/ensyu1");
Connection db = ds.getConnection();


//SQL(SELECT)
PreparedStatement pstm = null;
String querySelect = "SELECT * FROM ensyu1Table";
ResultSet rs = null;
String lastId = "0";

pstm = db.prepareStatement(querySelect);
rs = pstm.executeQuery();
while(rs.next()){
    %>
    <%=rs.getString("id") %>
    <%=rs.getString("name") %>
    <%=rs.getString("age") %><br/>
    <%

    //最後のIDを格納する
    lastId = rs.getString("id");
}
//CLOSE
pstm.close();

//SQL(INSERT)
PreparedStatement pstm2 = null;
String queryInsert = "INSERT INTO ensyu1table(id,name,age) VALUES("+lastId+" + 1,'NTC','54')";
pstm2 = db.prepareStatement(queryInsert);
pstm2.execute();
pstm2.close();

db.close();
%>

SQLの実行に成功しました。
</body>
</html>
