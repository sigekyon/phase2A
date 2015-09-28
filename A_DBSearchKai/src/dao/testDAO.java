package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class testDAO {
    Connection con = null;

    public testDAO(){
        dbBasic conf = new dbBasic();
        this.con = conf.execute();
    }

    public List<testVO> testSelect(String reqData) throws SQLException
    {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<testVO> list = new ArrayList<testVO>();
        String query = "SELECT * FROM login WHERE registrant_id = ?";

        try {
            pstm = con.prepareStatement(query);
            pstm.setString(1,reqData);
            rs = pstm.executeQuery();
            while(rs.next()){

                String registant_id = rs.getString(1);
                String registrant_password = rs.getString(2);

                testVO vo = new testVO();
                vo.setRegistrant_id(registant_id);
                vo.setRegistrant_password(registrant_password);

                list.add(vo);
            }
        }catch (SQLException e){
            pstm.close();
            this.con.close();
        }
        pstm.close();
        this.con.close();
        return list;
    }
}
