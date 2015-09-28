package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.testBean;
import dao.testDAO;
import dao.testVO;

public class MainControl extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // postメソッド
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

      testDAO dao = new testDAO();
      List<testVO> list = new ArrayList<testVO>();
      ArrayList<testBean> beans = new ArrayList<testBean>();

      try {
		list = dao.testSelect(req.getParameter("userId"));
		req.setAttribute("message","検索ID:"+req.getParameter("userId")+"で検索しました");
	  } catch (SQLException e) {
	  }

      //データがある場合
      if(this.checkData(list)) {
          testBean bean = new testBean();
          bean.setRegistrant_id(list.get(0).getRegistrant_id());
          bean.setRegistrant_password(list.get(0).getRegistrant_password());
          beans.add(bean);

      } else {
          System.out.println("データがありません");
      }

      //JSP側にBeanを連携
      if(beans.size() > 0){
        req.setAttribute("dbdata", beans.get(0));
      }



      //JSP設定
      RequestDispatcher rd = req.getRequestDispatcher("/dblist.jsp");
      rd.forward(req, resp);
    }


    /**
     * DAOデータの有無チェック
     * @return
     */
    public boolean checkData(List list){
        boolean ret = true;

        if(list==null) {
            ret = false;
        }
        else {
            if(list.size() < 1){
                ret = false;
            }
        }
        return ret;
    }

}
