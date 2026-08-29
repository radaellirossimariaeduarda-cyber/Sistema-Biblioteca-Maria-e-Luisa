package model;

import java.io.Serializable;

public class Livro implements model.Emprestavel, Serializable{
    private int codigo;
    private String titulo;
    private String autor;
    private String genero;
    private int anoPublicacao;
    private boolean disponivel;
    public Livro(int codigo, String titulo, String autor, String genero, int anoPublicacao) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anoPublicacao = anoPublicacao;
        this.disponivel = true;
    }
    @Override
    public void emprestar() {
        disponivel = false;
    }
    @Override
    public void devolver() {
        disponivel = true;
    }
    @Override
    public boolean estaDisponivel() {
        return disponivel;
    }
    public int getCodigo() {
        return codigo;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public String getGenero() {
        return genero;
    }
    public int getAnoPublicacao() {
        return anoPublicacao;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
    @Override
    public String toString() {
        return "\nCódigo: " + codigo + "\nTítulo: " + titulo + "\nAutor: " + autor + "\nGênero: " + genero + "\nAno: " + anoPublicacao + "\nDisponível: " + disponivel;
    }
}