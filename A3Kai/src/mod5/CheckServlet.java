package mod5;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		this.doPost(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {




		//名前
		String name = req.getParameter("username");
		if(name == null||name ==""){
			name = "未入力";
		} else {
		}

		req.setAttribute("name", name);

		RequestDispatcher rd = req.getRequestDispatcher("check_result.jsp");
		rd.forward(req, resp);


	}


}

