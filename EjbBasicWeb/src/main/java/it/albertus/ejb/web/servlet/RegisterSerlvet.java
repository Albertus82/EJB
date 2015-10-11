package it.albertus.ejb.web.servlet;

import it.albertus.ejb.model.Utente;
import it.albertus.ejb.service.RegisterService;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@WebServlet("/register")
public class RegisterSerlvet extends HttpServlet {

	public enum RegistrationError {
		CAMPI_OBBLIGATORI("Uno o pi\u00F9 campi obbligatori non risultano compilati."),
		FORMATO_DATA("Data di nascita non formattata correttamente."),
		UTENTE_ESISTENTE("Username gi\u00E0 in uso.");

		private RegistrationError(String message) {
			this.message = message;
		}

		private final String message;

		public String getMessage() {
			return message;
		}
	}

	private static final long serialVersionUID = -5781712276535412369L;

	private static final String REGISTER_JSP = "/WEB-INF/views/register.jsp";

	private static final Log log = LogFactory.getLog(RegisterSerlvet.class);

	@EJB
	private RegisterService registerService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(REGISTER_JSP);
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Set<RegistrationError> errors = new LinkedHashSet<RegistrationError>();

		Utente utente = new Utente();
		utente.setUsername(request.getParameter("username").trim());
		utente.setPassword(request.getParameter("password").trim());
		utente.setNome(request.getParameter("nome").trim());
		utente.setCognome(request.getParameter("cognome").trim());

		if (StringUtils.isBlank(utente.getUsername()) || StringUtils.isBlank(utente.getPassword()) || StringUtils.isBlank(utente.getNome()) || StringUtils.isBlank(utente.getCognome())) {
			errors.add(RegistrationError.CAMPI_OBBLIGATORI);
		}

		// Validazione data di nascita
		Date dataNascita = null;
		if (StringUtils.isNotBlank(request.getParameter("dataNascita"))) {
			try {
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				df.setLenient(false);
				dataNascita = df.parse(request.getParameter("dataNascita").trim());
				utente.setDataNascita(dataNascita);
			}
			catch (Exception e) {
				errors.add(RegistrationError.FORMATO_DATA);
			}
		}

		if (errors.isEmpty()) {
			if (registerService.register(utente)) {
				log.info("Utente registrato.");
			}
			else {
				errors.add(RegistrationError.UTENTE_ESISTENTE);
			}
		}

		if (errors.isEmpty()) {
			request.getSession().setAttribute("utente", utente);
			response.sendRedirect(request.getContextPath() + "/secured/home");
		}
		else {
			request.setAttribute("errors", errors);
			request.setAttribute("utente", utente);
			RequestDispatcher rd = request.getRequestDispatcher(REGISTER_JSP);
			rd.forward(request, response); /* Forward con errori */
		}
	}

}
