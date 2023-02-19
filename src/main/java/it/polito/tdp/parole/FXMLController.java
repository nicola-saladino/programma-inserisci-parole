package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private TextArea txtTempiEsecuzione;
    
    @FXML
    private Button btnCancella;

    @FXML
    void doInsert(ActionEvent event) {
    	long startTime = System.nanoTime();
    	 String parola = txtParola.getText().trim();
         if(!parola.isEmpty()) {
             elenco.addParola(parola);
             txtParola.clear();
             updateTxtResult();
         }
         long endTime = System.nanoTime();
         txtTempiEsecuzione.appendText("Inserimento: " + (endTime - startTime) + " nanosecondi\n");
    }

    @FXML
    void doReset(ActionEvent event) {
    	long startTime = System.nanoTime();
    	elenco.reset();
        updateTxtResult();
        long endTime = System.nanoTime();
        txtTempiEsecuzione.appendText("Reset: " + (endTime - startTime) + " nanosecondi\n");
    }
    
    private void updateTxtResult() {
        List<String> parole = elenco.getElenco();
        StringBuilder sb = new StringBuilder();
        for (String parola : parole) {
            sb.append(parola).append("\n");
        }
        txtResult.setText(sb.toString());
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	long startTime = System.nanoTime();
    	String parolaSelezionata = txtResult.getSelectedText();
    	if (parolaSelezionata != null && !parolaSelezionata.isEmpty()) {
    		elenco.cancellaParola(parolaSelezionata.trim());
    		updateTxtResult();
    	}
    	long endTime = System.nanoTime();
        txtTempiEsecuzione.appendText("Cancellazione: " + (endTime - startTime) + " nanosecondi\n");
    	
    }

    @FXML
    void initialize() {
    	assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTempiEsecuzione != null : "fx:id=\"txtTempiEsecuzione\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
