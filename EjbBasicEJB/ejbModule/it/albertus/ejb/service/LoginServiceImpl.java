package it.albertus.ejb.service;

import it.albertus.ejb.dao.UtenteDao;
import it.albertus.ejb.model.Utente;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Stateless
public class LoginServiceImpl implements LoginService {

	private static final Log log = LogFactory.getLog(LoginServiceImpl.class);

	@Inject
	private UtenteDao utenteDao;

	@Override
	public String toString() {
		return "LoginServiceImpl [utenteDao=" + utenteDao + "]";
	}

	@Override
	public Utente auth(String username, String password) {
		Utente utente = utenteDao.findUtenteByUsername(username);
		if (utente != null && !utente.getPassword().equals(password)) {
			log.warn("La password specificata non corrisponde con quella presente nel database.");
			utente = null;
		}
		return utente;
	}

}
