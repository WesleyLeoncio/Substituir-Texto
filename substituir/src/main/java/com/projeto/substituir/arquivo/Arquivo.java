package com.projeto.substituir.arquivo;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arquivo {

    private String nomeDoArquivo;
    private String palavra;
    private String texto;

    public Arquivo() {
    }

    public Arquivo(String nomeDoArquivo, String palavra, String texto) {
        this.nomeDoArquivo = nomeDoArquivo;
        this.palavra = palavra;
        this.texto = texto;
    }

    
    public String LerArquivo() {

        List<String> listPalavra = new ArrayList<>();

        try {
            FileInputStream arquivo = new FileInputStream(nomeDoArquivo);
            InputStreamReader input = new InputStreamReader(arquivo);
            BufferedReader br = new BufferedReader(input);
            String linha;

            do {
                linha = br.readLine();
                if (linha != null) {
                    String[] palavras = linha.split("\n");
                    listPalavra.addAll(Arrays.asList(palavras));
                }

            } while (linha != null);

        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo!");
        }
        String backup = texto;
        String palavra = backup;
        StringBuilder lista = new StringBuilder();

        for (String s : listPalavra) {
            palavra = palavra.replaceAll(this.palavra, s); // Troca palavra pela palavra desejada
            lista.append(palavra).append("\n");
            palavra = backup;
        }
        return lista.toString();
    }

    public String abrirArquivo() {
        JFileChooser arquivo = new JFileChooser();
        FileNameExtensionFilter filtroTxt = new FileNameExtensionFilter("Arquivos TXT", "txt");
        arquivo.addChoosableFileFilter(filtroTxt);
        arquivo.setAcceptAllFileFilterUsed(false);
        if (arquivo.showOpenDialog(arquivo) == JFileChooser.APPROVE_OPTION) {
            nomeDoArquivo = (arquivo.getSelectedFile().getAbsolutePath());
        }
        return nomeDoArquivo;
    }

}
