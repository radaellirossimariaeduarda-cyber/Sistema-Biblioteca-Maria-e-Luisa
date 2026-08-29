package model;

import java.util.HashSet;
import java.util.Set;

public class Leitor extends model.Pessoa {
    private String cpf;
    private Set<model.Livro> livrosEmprestados;
    public Leitor(int id, String nome, String cpf) {
        super(id, nome);
        this.cpf = cpf;
        livrosEmprestados = new HashSet<>();
    }
    public String getcpf() {
        return cpf;
    }
    public void setcpf(String cpf) {
        this.cpf = cpf;
    }
    public Set<model.Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }
    public void adicionarLivro(model.Livro livro){
        livrosEmprestados.add(livro);
    }
    public void removerLivro(model.Livro livro){
        livrosEmprestados.remove(livro);
    }
    @Override
    public String toString() {
        return "\nID: " + id + "\nNome: " + nome + "\nCPF: " + cpf + "\nQuantidade de livros: " + livrosEmprestados.size();
    }
}
