package dao;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class dbBasic {

    public Connection execute() {

        // DB接続
        String url = "java:comp/env/jdbc/selfjsp";
        Connection db = null;

        try {
          // 変数初期化
          Context context = new InitialContext();
          DataSource ds = (DataSource)context.lookup(url);
          db = ds.getConnection();
        }catch (Exception e) {
        }
        return db;
    }
}
