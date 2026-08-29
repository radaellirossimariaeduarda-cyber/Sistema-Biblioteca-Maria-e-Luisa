package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Emprestimo  implements Serializable{
    private int codigo;
    private Livro livro;
    private Leitor leitor;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean devolvido;
    public Emprestimo(int codigo, Livro livro, Leitor leitor, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.codigo = codigo;
        this.livro = livro;
        this.leitor = leitor;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.devolvido = false;
    }
    public int getCodigo() {
        return codigo;
    }
    public Livro getLivro() {
        return livro;
    }
    public Leitor getLeitor() {
        return leitor;
    }
    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }
    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }
    public boolean isDevolvido() {
        return devolvido;
    }
    public void finalizarEmprestimo(){
        devolvido = true;
        livro.devolver();
    }
    @Override
    public String toString() {
        return "Empréstimo: " + codigo
                + "\nLivro: " + livro.getTitulo()
                + "\nLeitor: " + leitor.getNome()
                + "\nData Empréstimo: " + dataEmprestimo
                + "\nData Devolução: " + dataDevolucao
                + "\nDevolvido: " + devolvido;

    }
}