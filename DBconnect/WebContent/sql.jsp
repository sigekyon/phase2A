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
DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/selfjsp");
Connection db = ds.getConnection();


//SQL
PreparedStatement pstm = null;
String query = "SELECT * FROM test WHERE registrant_id = ?";
ResultSet rs = null;
String registrant_id = "";

pstm = db.prepareStatement(query);
pstm.setString(1, "001");
rs = pstm.executeQuery();

while(rs.next()){
    registrant_id = rs.getString("registrant_id");
    System.out.println(registrant_id);

    %>
    <%=registrant_id %>
    <%
}


//CLOSE
pstm.close();
db.close();
%>

SQLの実行に成功しました。
</body>
</html>
