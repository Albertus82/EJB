package it.albertus.ejb.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@WebServlet({ "/logout", "/secured/logout" })
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 6788461013066837184L;

	private static final Log log = LogFactory.getLog(LogoutServlet.class);

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
			log.info("Sessione cancellata.");
		}
		response.sendRedirect(request.getContextPath());
	}

}
