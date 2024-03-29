package com.projeto.substituir.controller;

import com.projeto.substituir.arquivo.Arquivo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author Wesley
 */
public class FXMLPrincipalController implements Initializable {

    @FXML
    private TextField txt_arquivo;
    @FXML
    private TextField txt_palavra;
    @FXML
    private TextField txt_texto;
    @FXML
    private TextArea txt_comandos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO document why this method is empty
    }
    
    @FXML
    public void abrirArquivo() {
       Arquivo arq = new Arquivo();
       txt_arquivo.setText(arq.abrirArquivo());
    }
    
    @FXML
    public void btSubstituir() {
        String arquivo = txt_arquivo.getText();
        String palavra = txt_palavra.getText();
        String texto = txt_texto.getText();
        Arquivo arq = new Arquivo(arquivo,palavra, texto);

        txt_comandos.setText(arq.LerArquivo());
    }

    

}
