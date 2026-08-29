package exception;

public class LivroNaoEncontrado extends Exception{
    public LivroNaoEncontrado(){
        super("Livro não encontrado.");
    }
}