package com.ofppt.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ofppt.commun.FactoryInstance;
import com.ofppt.presentation.AdapterModel;
import com.ofppt.presentation.AppManager;

public class AppServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AppManager start = FactoryInstance.buildMenu();
		int nbr = 0;
		String[] listCollections = req.getParameterValues("listCollections");
		String[] listMaps = req.getParameterValues("listMaps");

		try {
			
			// no Integer or not a Integer Type
			nbr = Integer.parseInt(req.getParameter("nbr"));
			
			// no valid number
			if (nbr < 10 || nbr > 1000000) {
				req.setAttribute("error", "noValidNum");
				req.getRequestDispatcher("index.jsp").forward(req, resp);
				
			}else if (listCollections == null && listMaps == null) {
				// no collections
				req.setAttribute("error", "noCollection");
				req.getRequestDispatcher("index.jsp").forward(req, resp);
				
			} else {
				// input Valid
				AdapterModel modelAdapter = start.startTest(nbr, listCollections, listMaps);
				req.setAttribute("model", modelAdapter);
				//req.setAttribute("error", "newTest");
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
			
			
		} catch (NumberFormatException e) {
			req.setAttribute("error", "noInteger");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		

		System.out.println(nbr);

		

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
