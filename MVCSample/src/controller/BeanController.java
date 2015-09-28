package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BeanSample;

public class BeanController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		ArrayList<BeanSample> beans = new ArrayList<BeanSample>();
		BeanSample bean = new BeanSample();

		bean.setBeanId("001");
		beans.add(bean);

		req.setAttribute("beanData", beans.get(0));


		RequestDispatcher rd = req.getRequestDispatcher("/beanSample.jsp");
		rd.forward(req, resp);

	}

}
