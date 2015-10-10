package it.albertus.ejb.dao;

import it.albertus.ejb.model.Utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Named /* Opzionale */
@ApplicationScoped
public class UtenteDaoImpl extends BaseDao implements UtenteDao {

	private static final Log log = LogFactory.getLog(UtenteDaoImpl.class);

	@Override
	public Utente findUtenteByUsername(String username) {
		Utente utente = null;
		Connection c = null;
		PreparedStatement s = null;
		ResultSet r = null;
		try {
			c = getDataSource().getConnection();
			s = c.prepareStatement("SELECT password, nome, cognome, data_nascita FROM utenti WHERE username = ?");
			s.setString(1, username);
			r = s.executeQuery();
			if (r.next()) {
				utente = new Utente();
				utente.setUsername(username);
				utente.setPassword(r.getString(1));
				utente.setNome(r.getString(2));
				utente.setCognome(r.getString(3));
				utente.setDataNascita(r.getDate(4));
				log.info("Utente presente nel database: " + utente + '.');
			}
			else {
				log.warn("Utente NON presente nel database.");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				r.close();
				s.close();
				c.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return utente;
	}

}
