package it.albertus.ejb.model;

import java.util.Date;

public class Utente {

	private String username;
	private transient String password;
	private String nome;
	private String cognome;
	private Date dataNascita;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	@Override
	public String toString() {
		return "Utente [username=" + username + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita + "]";
	}

}
