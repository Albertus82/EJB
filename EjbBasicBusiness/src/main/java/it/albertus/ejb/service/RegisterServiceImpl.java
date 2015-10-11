package it.albertus.ejb.service;

import it.albertus.ejb.dao.UtenteDao;
import it.albertus.ejb.model.Utente;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Stateless
public class RegisterServiceImpl implements RegisterService {

	private static final Log log = LogFactory.getLog(RegisterServiceImpl.class);

	@Inject
	private UtenteDao utenteDao;

	@Override
	public String toString() {
		return "LoginServiceImpl [utenteDao=" + utenteDao + "]";
	}

	@Override
	public boolean register(Utente utente) { /* Andrebbe eseguito in transazione */
		boolean registered = false;
		if (utenteDao.findById(utente.getUsername()) == null) {
			utenteDao.save(utente);
			registered = true;
		}
		else {
			log.warn("Utente gia' presente: " + utente.getUsername());
		}
		return registered;
	}

}
