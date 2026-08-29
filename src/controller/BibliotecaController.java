package controller;

import exception.EmprestimoException;
import exception.LeitorNaoEncontrado;
import exception.LivroNaoEncontrado;
import model.Emprestimo;
import model.Leitor;
import model.Livro;
import util.ArquivoBinario;
import util.ArquivoTexto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BibliotecaController {
    private Map<Integer, Livro> livros;
    private Map<Integer, Leitor> leitores;
    private ArrayList<Emprestimo> emprestimos;
    private int proximoLivro;
    private int proximoLeitor;
    private int proximoEmprestimo;
    public BibliotecaController() {
        livros = new HashMap<>();
        leitores = new HashMap<>();
        emprestimos = new ArrayList<>();
        proximoLivro = 1;
        proximoLeitor = 1;
        proximoEmprestimo = 1;
    }
    public void cadastrarLivro(String titulo, String autor, String genero, int ano) {
        Livro livro = new Livro(proximoLivro, titulo, autor, genero, ano);
        livros.put(proximoLivro, livro);
        proximoLivro++;
    }
    public void cadastrarLeitor(String nome, String cpf) {
        Leitor leitor = new Leitor(proximoLeitor, nome, cpf);
        leitores.put(proximoLeitor, leitor);
        proximoLeitor++;
    }
    public Livro buscarLivro(int codigo) {
        return livros.get(codigo);
    }
    public Leitor buscarLeitor(int id) {
        return leitores.get(id);
    }
    public void listarLivros() {
        if(livros.isEmpty()){
            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        for(Livro livro : livros.values()){
            System.out.println(livro);
        }
    }
    public void listarLeitores() {
        if(leitores.isEmpty()){
            System.out.println("Nenhum leitor cadastrado.");
            return;
        }
        for(Leitor leitor : leitores.values()){
            System.out.println(leitor);
        }
    }
    public boolean realizarEmprestimo(int codigoLivro, int idLeitor)
            throws LivroNaoEncontrado,
            LeitorNaoEncontrado,
            EmprestimoException, EmprestimoException {
                Livro livro = livros.get(codigoLivro);
                    if(livro == null){
                         throw new LivroNaoEncontrado();
                    }
                    Leitor leitor = leitores.get(idLeitor);
                    if(leitor == null){
                        throw new LeitorNaoEncontrado();
                    }
                    if(!livro.estaDisponivel()){
                        throw new EmprestimoException("Livro indisponível.");
                    }
                    livro.emprestar();
                    leitor.adicionarLivro(livro);
                    Emprestimo emprestimo = new Emprestimo(proximoEmprestimo, livro, leitor, LocalDate.now(), LocalDate.now().plusDays(7));
                    emprestimos.add(emprestimo);
                    proximoEmprestimo++;
                    return false;
    }
    public boolean devolverLivro(int codigoEmprestimo){
        for(Emprestimo e : emprestimos){
            if(e.getCodigo() == codigoEmprestimo){
                if(e.isDevolvido()){
                    return false;
                }
                e.finalizarEmprestimo();
                e.getLeitor().removerLivro(e.getLivro());
                return true;
            }
        }
        return false;
    }
    public void listarEmprestimos() {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo registrado.");
            return;
        }
        for (Emprestimo e : emprestimos) {
            System.out.println(e);
        }
    }
    public boolean removerLivro(int codigo){
        Livro livro = livros.get(codigo);
        if(livro == null){
            return false;
        }
        else if(!livro.estaDisponivel()){
            return false;
        }
        livros.remove(codigo);
        return true;
    }
    public boolean removerLeitor(int id){
        Leitor leitor = leitores.get(id);
        if(leitor == null){
            return false;
        }
        if(!leitor.getLivrosEmprestados().isEmpty()){
            return false;
        }
        leitores.remove(id);
        return true;
    }
    public Map<Integer, Livro> getLivros() {
        return livros;
    }
    public Map<Integer, Leitor> getLeitores() {
        return leitores;
    }
    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
    public void salvarDados(){
        ArquivoBinario.salvar("src/dados/livros.dat", livros);
        ArquivoBinario.salvar("src/dados/leitores.dat", leitores);
    }
    public void carregarDados(){
        Object objLivros = ArquivoBinario.carregar("dados/livros.dat");
        Object objLeitores = ArquivoBinario.carregar("dados/leitores.dat");
        if(objLivros != null){
            livros = (HashMap<Integer,Livro>) objLivros;
        }
        if(objLeitores != null){
            leitores = (HashMap<Integer,Leitor>) objLeitores;
        }
    }
    public void gerarRelatorio(){
        ArquivoTexto.gerarRelatorio(livros, leitores, emprestimos);
    }
    public int quantidadeLivros(){
        return livros.size();
    }
    public int quantidadeLeitores(){
        return leitores.size();
    }
    public int quantidadeEmprestimos(){
        return emprestimos.size();
    }
    public int livrosDisponiveis(){
        int contador = 0;
        for(Livro livro : livros.values()){
            if(livro.estaDisponivel()){
                contador++;
            }
        }
        return contador;
    }
    public int livrosEmprestados(){
        return quantidadeLivros() - livrosDisponiveis();
    }
}