package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
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

    }

    @FXML
    void btnCercaIscrittiCorso(ActionEvent event) {

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