package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	private CorsoDAO corsoDao;
	private StudenteDAO studenteDao;
	
	
	public Model() {
		this.corsoDao = new CorsoDAO();
		this.studenteDao= new StudenteDAO();
	}


	public List<Corso> getTuttiICorsi() {
		return this.corsoDao.getTuttiICorsi();
	}
	
	public Studente getNomeCogomeStudente(int matricola) {
		return this.studenteDao.getNomeCogomeStudente(matricola);
	}
	
	public List<Studente> getCorsiStudente(String codins){
		return this.studenteDao.getCorsiStudente(codins);
	}
	
	public List<Corso> getCorsiStudenteDaMatricola(int matricola) {
		return this.corsoDao.getCorsiStudenteDaMatricola(matricola);
	}

}
