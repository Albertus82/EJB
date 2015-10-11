package it.albertus.ejb.service;

import it.albertus.ejb.model.Utente;

import javax.ejb.Local;

@Local
public interface RegisterService {
	
	boolean register(Utente utente);

}
