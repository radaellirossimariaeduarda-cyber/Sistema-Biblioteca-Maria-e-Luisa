package exception;

public class LeitorNaoEncontrado extends Exception{
    public LeitorNaoEncontrado(){
        super("Leitor não encontrado.");
    }
}