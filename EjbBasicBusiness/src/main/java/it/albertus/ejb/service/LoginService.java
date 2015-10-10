package it.albertus.ejb.service;

import it.albertus.ejb.model.Utente;

import javax.ejb.Local;

@Local
public interface LoginService {

	Utente auth(String username, String password);

}
