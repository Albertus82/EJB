package it.albertus.ejb.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secured/home")
public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = -1484498917538379888L;

	private static final String HOME_JSP = "/WEB-INF/views/home.jsp";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(HOME_JSP);
		rd.forward(request, response);
	}

}
