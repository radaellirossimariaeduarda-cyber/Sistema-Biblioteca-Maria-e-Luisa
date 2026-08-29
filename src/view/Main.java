package view;

import controller.BibliotecaController;
import org.jetbrains.annotations.NotNull;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        BibliotecaController controller = new BibliotecaController();
        controller.carregarDados();
        int opcao;
        do {
            System.out.println("\n   BIBLIOTECA ERA UMA VEZ");
            System.out.println("\n1 - Cadastrar Livro");
            System.out.println("2 - Cadastrar Leitor");
            System.out.println("3 - Listar Livros");
            System.out.println("4 - Listar Leitores");
            System.out.println("5 - Realizar Empréstimo");
            System.out.println("6 - Devolver Livro");
            System.out.println("7 - Listar Empréstimos");
            System.out.println("8 - Remover Livro");
            System.out.println("9 - Remover Leitor");
            System.out.println("10 - Gerar Relatório");
            System.out.println("11 - Salvar Dados");
            System.out.println("0 - Sair");
            System.out.print("\nEscolha: ");
            opcao = entrada.nextInt();
            entrada.nextLine();
            switch (opcao) {
                case 1:
                    cadastrarLivro (controller, entrada);
                    break;
                case 2:
                    cadastrarLeitor(controller, entrada);
                    break;
                case 3:
                    controller.listarLivros();
                    break;
                case 4:
                    controller.listarLeitores();
                    break;
                case 5:
                    realizarEmprestimo(controller, entrada);
                    break;
                case 6:
                    devolverLivro(controller, entrada);
                    break;
                case 7:
                    controller.listarEmprestimos();
                    break;
                case 8:
                    removerLivro (controller, entrada);
                    break;
                case 9:
                    removerLeitor(controller, entrada);
                    break;
                case 10:
                    controller.gerarRelatorio();
                    System.out.println("Relatório gerado!");
                    break;
                case 11:
                    controller.salvarDados();
                    System.out.println("Dados salvos!");
                    break;
                case 0:
                    controller.salvarDados();
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
    private static void cadastrarLivro(@NotNull BibliotecaController controller, @NotNull Scanner entrada){
        System.out.print("Título: ");
        String titulo = entrada.nextLine();
        System.out.print("Autor: ");
        String autor = entrada.nextLine();
        System.out.print("Gênero: ");
        String genero = entrada.nextLine();
        System.out.print("Ano: ");
        int ano = entrada.nextInt();
        entrada.nextLine();
        controller.cadastrarLivro(titulo, autor, genero, ano);
        System.out.println("Livro cadastrado!");
    }
    private static void cadastrarLeitor(@NotNull BibliotecaController controller, @NotNull Scanner entrada){
        System.out.print("Nome: ");
        String nome = entrada.nextLine();
        System.out.print("CPF: ");
        String cpf = entrada.nextLine();
        controller.cadastrarLeitor(nome, cpf);
        System.out.println("Leitor cadastrado!");
    }
    private static void realizarEmprestimo(BibliotecaController controller, @NotNull Scanner entrada){
        System.out.print("Código do livro: ");
        int livro = entrada.nextInt();
        System.out.print("ID do leitor: ");
        int leitor = entrada.nextInt();
        entrada.nextLine();
        try{
            controller.realizarEmprestimo(livro, leitor);
            System.out.println("Empréstimo realizado!");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    private static void devolverLivro(@NotNull BibliotecaController controller, @NotNull Scanner entrada) {
        System.out.print("Código do empréstimo: ");
        int codigo = entrada.nextInt();
        entrada.nextLine();
        if (controller.devolverLivro(codigo)) {
            System.out.println("Livro devolvido!");
        }
        else {
            System.out.println("Erro na devolução.");
        }
    }
    private static void removerLivro(@NotNull BibliotecaController controller, @NotNull Scanner entrada){
        System.out.print("Código do livro: ");
        int codigo = entrada.nextInt();
        entrada.nextLine();
        if(controller.removerLivro(codigo)) {
            System.out.println("Livro removido.");
        }
        else {
            System.out.println("Não foi possível remover.");
        }
    }
    private static void removerLeitor(@NotNull BibliotecaController controller, @NotNull Scanner entrada){
        System.out.print("ID do leitor: ");
        int id = entrada.nextInt();
        entrada.nextLine();
        if(controller.removerLeitor(id)){
            System.out.println("Leitor removido.");
        }
        else{
            System.out.println("Não foi possível remover.");
        }
    }
}