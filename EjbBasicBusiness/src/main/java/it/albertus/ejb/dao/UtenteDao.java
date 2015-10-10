package it.albertus.ejb.dao;

import it.albertus.ejb.model.Utente;

public interface UtenteDao {

	Utente findUtenteByUsername(String username);

}
