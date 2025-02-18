package it.polito.tdp.lab04;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.DAO.StudenteDAO;
import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Corso> cmbCorsi;

    @FXML
    private TextField txtCognome;

    @FXML
    private TextField txtNMatricola;

    @FXML
    private TextField txtNome;

    @FXML
    private TextArea txtRisultati;

    @FXML
    void btnCercaCorsi(ActionEvent event) {
    	txtRisultati.clear();
    	
    	int matricola = Integer.parseInt(txtNMatricola.getText());
    	
    	List<Corso> corsi_matricola = model.getCorsiStudenteDaMatricola(matricola);
    	
    	for (Corso c: corsi_matricola) {
    		txtRisultati.appendText(c +"\n");
    	}
    	
    	if (txtRisultati.getText().equals("")) {
    		txtRisultati.setText("Studente non esistente");
    	}
    	

    }

    @FXML
    void btnCercaIscrittiCorso(ActionEvent event) {
    	txtRisultati.clear();
    	
    	if (cmbCorsi.getValue() == null) {
    		txtRisultati.setText("Selezionare un corso");
    		return;
    	}
    	
    	Corso combobox = cmbCorsi.getValue();
    	String codins = combobox.getCodins();
    	
    	List<Studente> studenti = this.model.getCorsiStudente(codins);
    	
    	for(Studente s: studenti) {
    		txtRisultati.appendText(s +"\n");
    	}
    	txtRisultati.setDisable(false);

    }

    @FXML
    void btnCercaNomeCognome(ActionEvent event) {
    	
     
    	int matricola = Integer.parseInt(txtNMatricola.getText());
    	
    	txtNome.setText(model.getNomeCogomeStudente(matricola).getNome());
    	txtCognome.setText(model.getNomeCogomeStudente(matricola).getCognome());

    }

    @FXML
    void btnIscrivi(ActionEvent event) {

    }

    @FXML
    void btnReset(ActionEvent event) {
    	txtRisultati.clear();
    	txtNMatricola.clear();
    	txtNome.clear();
    	txtCognome.clear();

    }

    @FXML
    void initialize() {
        assert cmbCorsi != null : "fx:id=\"cmbCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNMatricola != null : "fx:id=\"txtNMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultati != null : "fx:id=\"txtRisultati\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    	cmbCorsi.getItems().add(null);
    	cmbCorsi.getItems().addAll(model.getTuttiICorsi());
    }
    

}