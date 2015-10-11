package it.albertus.ejb.dao;

import it.albertus.ejb.model.Utente;

public interface UtenteDao {

	Utente findById(String username);

	boolean save(Utente utente);

}
