# Sistema-Biblioteca-Maria-e-Luisa
Projeto realizado nas aulas de programação pelas alunas Maria Eduarda Radaelli Rossi e Luísa Giacomelli Westerlund.
# Biblioteca Era Uma Vez

O **Biblioteca Era Uma Vez** é um sistema de gerenciamento de biblioteca desenvolvido em **Java**. O projeto aplica os conceitos fundamentais de **Programação Orientada a Objetos (POO)** e adota o padrão de arquitetura **MVC (Model-View-Controller)** para operação via console.

O sistema permite gerenciar o cadastro de livros e leitores, realizar o fluxo completo de empréstimos e devoluções, consultar informações em tempo real e gerar relatórios físicos dos dados da biblioteca.
## Objetivo do Projeto
Aplicar de forma prática os conceitos de POO estudados na disciplina, construindo uma aplicação robusta baseada em terminal. 
Os principais conceitos implementados são:
*   Classes, Objetos e Encapsulamento
*   Herança e Classes Abstratas
*   Interfaces e Polimorfismo
*   Estruturas de Dados (`HashMap`, `HashSet` e `ArrayList`)
*   Tratamento customizado de Exceções
*   Persistência de dados em arquivos (Binários e Texto)
*   Arquitetura de Software (Padrão MVC)
## Link do Repositório
*   GitHub: [[INSIRA AQUI O LINK DO REPOSITÓRIO](https://github.com)]
## Arquitetura do Sistema (MVC)
O projeto está dividido de acordo com a responsabilidade de cada camada do padrão **MVC**:
### Model (Modelagem dos Dados)
Representa as entidades e a estrutura de dados do negócio.
*   `Pessoa`: Classe abstrata que reúne as informações básicas comuns a qualquer indivíduo.
*   `Leitor`: Representa o usuário da biblioteca e estende a classe abstrata `Pessoa`.
*   `Livro`: Representa as obras e implementa o contrato da interface `Emprestavel`.
*   `Emprestimo`: Modela a transação de um empréstimo ativo ou finalizado.
*   `Emprestavel`: Interface que dita as operações obrigatórias associadas à locação (`emprestar()`, `devolver()`, `estaDisponivel()`).
### Controller (Regras de Negócio)
*   `BibliotecaController`: Concentra toda a inteligência e validação do sistema. É responsável por gerenciar e coordenar as ações de inserção, busca, remoção, geração de relatórios e persistência física de dados.
### View (Interface do Usuário)
*   `Main`: Responsável pela renderização do menu interativo no console, leitura das entradas de dados digitadas e chamada dos respectivos métodos do controlador.
## Estrutura de Pastas do Projeto
Os arquivos `.java` e os diretórios de persistência respeitam a seguinte árvore estrutural:

```text
Biblioteca/
│
├── src/
│   ├── controller/
│   │   └── Bibliotecacontroller.java
│   │
│   ├── exception/
│   │   ├── EmprestimoException.java
│   │   ├── LeitorNaoEncontrado.java
│   │   └── LivroNaoEncontrado.java
│   │
│   ├── model/
│   │   ├── Pessoa.java
│   │   ├── Leitor.java
│   │   ├── Livro.java
│   │   ├── Emprestimo.java
│   │   └── Emprestavel.java
│   │
│   ├── util/
│   │   ├── ArquivoBinario.java
│   │   └── ArquivoTexto.java
│   │
│   └── view/
│       └── Main.java
│
└── dados/
```
## Funcionalidades Principais
*   **Cadastro de Livros:** Permite o registro de Título, Autor, Gênero e Ano de Publicação. O Código identificador do livro é gerado automaticamente pelo sistema.
*   **Cadastro de Leitores:** Permite o registro de Nome e CPF. O ID identificador do leitor é gerado automaticamente.
*   **Consulta e Listagem:** Filtros de busca por ID de leitor, código de livro, além de listagens globais de livros, leitores e empréstimos vigentes.
*   **Controle de Empréstimos:** Valida a existência do livro e do leitor, bem como a disponibilidade física do livro. Ao emprestar, vincula temporariamente o livro ao perfil do leitor e armazena metadados como datas (emissão/previsão) e situação cadastral.
*   **Fluxo de Devolução:** Finaliza o empréstimo, devolve a flag de disponibilidade ao livro e o remove da lista de pendências da conta do leitor.
*   **Remoção Segura:** Bloqueia a exclusão de leitores que possuem pendências físicas (livros em posse) ou de livros que estejam atualmente alugados.
## Aplicação Prática de Conceitos de POO
### Herança
```text
Pessoa (Classe Abstrata)
   └── Leitor (Subclasse)
```
### Coleções Utilizadas (`java.util`)
*   `HashMap`: Utilizado em mapas de busca rápida para livros (`Map<Integer, Livro>`) e leitores (`Map<Integer, Leitor>`) usando códigos numéricos como chaves exclusivas.
*   `HashSet`: Utilizado dentro do objeto `Leitor` (`Set<Livro> livrosEmprestados`) para garantir que o leitor não acumule duplicatas do mesmo objeto de forma inconsistente.
*   `ArrayList`: Utilizado como lista linear dinâmica para armazenar o histórico completo de transações (`ArrayList<Emprestimo>`).
### Tratamento de Exceções e Erros
O projeto utiliza um pacote customizado de exceções (`exception/`) para capturar cenários inesperados. Erros como tentar alugar um livro indisponível (`EmprestimoException`) ou buscar chaves inexistentes (`LivroNaoEncontrado`, `LeitorNaoEncontrado`) são capturados via blocos `try/catch` na `Main` e exibidos de forma limpa ao usuário.
## Persistência de Dados
O programa armazena dados de forma permanente no disco na pasta raiz `dados/`:
1.  **Arquivos Binários (`.dat`):** Utiliza a API de Serialização do Java para ler e gravar listas estruturadas de objetos em `dados/livros.dat` e `dados/leitores.dat`, preservando o estado da biblioteca após o encerramento do programa. Classe responsável: `ArquivoBinario.java`.
2.  **Arquivos de Texto (`.txt`):** Exporta relatórios administrativos legíveis de auditoria humana salvos em `dados/relatorioBiblioteca.txt`. Classe responsável: `ArquivoTexto.java`.
## Menu de Interação (Console)
Ao iniciar a aplicação, as seguintes opções estarão disponíveis no terminal:
```text
1 - Cadastrar Livro
2 - Cadastrar Leitor
3 - Listar Livros
4 - Listar Leitores
5 - Realizar Empréstimo
6 - Devolver Livro
7 - Listar Empréstimos
8 - Remover Livro
9 - Remover Leitor
10 - Gerar Relatório
11 - Salvar Dados
0 - Sair
```
## Como Executar
1.  Abra o projeto dentro de uma IDE compatível com a linguagem Java (como **IntelliJ IDEA**, **Eclipse** ou **NetBeans**).
2.  Verifique se o seu **JDK** está configurado e ativo no projeto (recomendado JDK 11 ou superior).
3.  Certifique-se de que a pasta vazia chamada `dados/` existe na raiz do seu diretório de execução para que as gravações de arquivo não falhem (caminhos relativos).
4.  Execute a classe principal localizada em: `src/view/Main.java`.
## Matriz de Requisitos Implementados
| Recurso | Detalhes |
| **Java** | Linguagem base do sistema |
| **Aplicação em Console** | Menu interativo via terminal |
| **Arquitetura MVC** | Camadas separadas corretamente |
| **Classe Abstrata** | Implementada na classe `Pessoa` |
| **Herança** | `Leitor extends Pessoa` |
| **Interface** | Implementada através de `Emprestavel` |
| **Polimorfismo** | Métodos abstratos e assinaturas de interface |
| **Mapas / Conjuntos / Listas** | `HashMap`, `HashSet` e `ArrayList` |
| **Exceções Customizadas** | Tratamento com `try/catch` centralizado |
| **Arquivo Binário** | Armazenamento de estado em `.dat` |
| **Arquivo Texto** | Geração de relatório legível em `.txt` |
## Observações Finais importantes
*   **Validação em Grupo:** Antes da entrega final, faça uma revisão completa para confirmar se todos os integrantes utilizaram exatamente as mesmas assinaturas de pacotes, métodos e arquivos na hora do merge.
*   **Histórico de Empréstimos:** Avalie a necessidade de também serializar a coleção de empréstimos caso o professor exija a persistência de histórico transacional completo após reiniciar a aplicação.
