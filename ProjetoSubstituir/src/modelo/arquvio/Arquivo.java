package modelo.arquvio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

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
                    for (int i = 0; i < palavras.length; i++) {
                        listPalavra.add(palavras[i]);
                    }
                }

            } while (linha != null);

        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo!");
        }
        String backup = texto;
        String palavra = backup;
        String lista = "";

        for (int i = 0; i < listPalavra.size(); i++) {
            palavra = palavra.replaceAll(this.palavra, listPalavra.get(i)); // Troca palavra pela palavra desejada
            lista += palavra + "\n";
            palavra = backup;
        }
        return lista;
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
