package util;

import model.Emprestimo;
import model.Leitor;
import model.Livro;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

public class ArquivoTexto {
    public static void gerarRelatorio(Map<Integer, Livro> livros, Map<Integer, Leitor> leitores, ArrayList<Emprestimo> emprestimos){
        try{
            FileWriter arquivo = new FileWriter("src/dados/dados.txt", true);
            PrintWriter gravar = new PrintWriter(arquivo);
            gravar.println("        BIBLIOTECA ERA UMA VEZ");
            gravar.println();
            gravar.println("LIVROS");
            for(Livro livro : livros.values()){
                gravar.println(livro);
                gravar.println();
            }
            gravar.println();
            gravar.println("LEITORES");
            for(Leitor leitor : leitores.values()){
                gravar.println(leitor);
                gravar.println();
            }
            gravar.println();
            gravar.println("EMPRÉSTIMOS");
            for(Emprestimo e : emprestimos) {
                gravar.println(e);
                gravar.println();
            }
            gravar.close();
        }
        catch(Exception e){
            System.out.println("Erro ao gerar relatório.");
            e.printStackTrace();
        };
    }
}