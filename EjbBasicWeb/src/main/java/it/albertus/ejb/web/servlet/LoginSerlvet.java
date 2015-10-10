package it.albertus.ejb.web.servlet;

import it.albertus.ejb.model.Utente;
import it.albertus.ejb.service.LoginService;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@WebServlet("/login")
public class LoginSerlvet extends HttpServlet {

	private static final long serialVersionUID = -1551226351925345173L;

	private static final String LOGIN_JSP = "/WEB-INF/views/login.jsp";

	private static final Log log = LogFactory.getLog(LoginSerlvet.class);

	@EJB
	private LoginService loginService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(LOGIN_JSP);
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();

		Utente utente = loginService.auth(username, password);
		if (utente != null) {
			log.info("Utente autenticato.");
			request.getSession().setAttribute("utente", utente);
			response.sendRedirect(request.getContextPath() + "/secured/home"); /* Redirect after POST */
		}
		else {
			request.setAttribute("messaggio", "Utenza non valida!");
			RequestDispatcher rd = request.getRequestDispatcher(LOGIN_JSP);
			rd.forward(request, response); /* Forward con messaggio */
		}
	}

}
