package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Studente;


public class StudenteDAO {
	
	public Studente getNomeCogomeStudente(int matricola) {
		
		Studente s = null;
		
		final String sql = "SELECT * "
				+ "FROM studente s "
				+ "WHERE s.`matricola`=?";


		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setInt(1, matricola);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				s = new Studente(rs.getInt("matricola"),rs.getString("cognome"),rs.getString("nome"),rs.getString("CDS"));

			}

			conn.close();
			return s;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
	public List<Studente> getCorsiStudente(String codins) {
		
		List<Studente> result = new LinkedList<Studente>();
		
		final String sql = "SELECT s.matricola, s.nome, s.cognome, s.CDS "
				+ "FROM studente s, iscrizione i "
				+ "WHERE s.matricola= i.matricola AND i.codins=?";


		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, codins);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Studente s = new Studente(rs.getInt("matricola"),rs.getString("cognome"),rs.getString("nome"),rs.getString("CDS"));
				result.add(s);

			}

			conn.close();
			return result;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
		
	}
}
