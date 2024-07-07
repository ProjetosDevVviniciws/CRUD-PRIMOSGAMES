package locadoragames;

import java.sql.Connection; // Ele que irá conectar ao banco de dados e trazer os resultados do import java.sql.Statement.
import java.sql.ResultSet; // Traz um conjunto de resultados de uma consulta SQL, por exemplo: SELECT, INSERT, USE, DELETE, UPDATE, entre outos.
import java.sql.Statement; // Serve para passar os parametros SQL e até mesmo instruções para o banco de dados. 
import java.util.Scanner; // Onde irá receber os dados do usuário, via console.

// COMANDOS A SEREM USADOS PARA RODAR O CODIGO:
// javac -cp .\lib\mysql-connector-j-8.4.0.jar -d bin\locadora .\src\BancoDeDados\DbConfig.java .\src\DataBaseOperations\DataBaseOperations.java .\src\Main\Main.java .\src\Rotas\Clientes.java .\src\Rotas\Games.java .\src\Rotas\Precos.java
// java -cp "bin.\locadora;lib/mysql-connector-j-8.4.0.jar" locadoragames.Main


/* ============================= Main ============================= */

/**
 * Classe principal do sistema PrimosLocadora, responsável por exibir o menu principal e
 * chamar os métodos apropriados para gerenciar clientes, games e preços.
 */

public class Main {

    /**
     * Método principal que exibe o menu principal e direciona para os submenus de Clientes,
     * Games e Preços, ou encerra o programa.
     * 
     * @param args Argumentos de linha de comando (não utilizados).
     */

    public static void main(String[] args) {
        
/* ============================= Menu Principal ============================= */

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\n" + "-".repeat(40) + "\n");
            System.out.println("Seja bem vindo ao PrimosLocadora!");
            System.out.println("\nMenu Principal:");
            System.out.println("1. Menu Clientes");
            System.out.println("2. Menu Games");
            System.out.println("3. Menu Preços");
            System.out.println("4. Sair");
            System.out.print("-".repeat(40) + "\n");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    menuClientes(scanner);
                    break;
                case 2:
                    menuGames(scanner);
                    break;
                case 3:
                    menuPrecos(scanner);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inexistente, por favor selecione novamente!");

            }
        }
    }

/* ============================= Menu Clientes ============================= */

    /**
     * Exibe o menu de gerenciamento de clientes e realiza operações como buscar,
     * adicionar, atualizar e remover clientes.
     * 
     * @param scanner Scanner para ler a entrada do usuário.
     */

    public static void menuClientes(Scanner scanner) {
        Clientes clientes = new Clientes();
        while (true) {
            System.out.print("\n" + "-".repeat(40) + "\n");
            System.out.println("\nMenu Clientes:");
            System.out.println("1. Buscar todos os Clientes.");
            System.out.println("2. Adicionar um novo Cliente.");
            System.out.println("3. Deletar um cliente.");
            System.out.println("4. Atualizar cliente existente.");
            System.out.println("5. Voltar ao menu principal");
            System.out.print("-".repeat(40) + "\n");
            System.out.println("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    clientes.buscarClientes(); // Serve para buscar todos os clientes que já estão cadastrados no clientes.
                    break;
                case 2:
                    System.out.print("\nSistema de cadastro do Cliente");
                    System.out.print("\nNome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    clientes.adicionarClientes(nome, email, cpf);
                    break;
                case 3:
                    System.out.print("\nSistema de atualização do cliente");
                    System.out.print("Id do cliente a ser atualizado: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Novo email: ");
                    String novoEmail = scanner.nextLine();
                    System.out.print("Novo CPF: ");
                    String novoCPF = scanner.nextLine();
                    clientes.atualizarClientes(idAtualizar, novoNome, novoEmail, novoCPF);
                    break;
                case 4:
                    System.out.print("\nSistema de remoção do Cliente");
                    System.out.print("Id do cliente a ser removido: ");
                    int idRemover = scanner.nextInt();
                    scanner.nextLine();
                    clientes.removerClientes(idRemover);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inexistente, por favor digite novamente.");
            }
        }
    }

/* ============================= Menu Games ============================= */

    /**
     * Exibe o menu de gerenciamento de games e realiza operações como buscar,
     * adicionar, atualizar e remover games.
     * 
     * @param scanner Scanner para ler a entrada do usuário.
     */

    public static void menuGames(Scanner scanner) {
        Games games = new Games();
        while (true) {
            System.out.print("\n" + "-".repeat(40) + "\n");
            System.out.println("\nMenu Games");
            System.out.println("1. Buscar todos os Games");
            System.out.println("2. Adicionar um novo Game");
            System.out.println("3. Deletar um Game");
            System.out.println("4. Atualizar Game existente");
            System.out.println("5. Voltar ao menu principal");
            System.out.print("-".repeat(40) + "\n");
            System.out.println("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();
            
            switch (escolha) {
                case 1:
                    games.buscarGames();
                    break;
                case 2:
                    System.out.print("\nSistema de cadastro do Game");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Categoria: (Terror, FPS, Multijogador, Esportes, Transportes, Sobrevivencia)");
                    String categoria = scanner.nextLine();
                    System.out.print("Ano de lançamento: ");
                    int ano_de_lancamento = scanner.nextInt();
                    System.out.print("Status (true/false): ");
                    boolean disponivel = scanner.nextBoolean();
                    System.out.print("Imagem Game: ");
                    String url_game = scanner.nextLine();
                    System.out.println("Preço por dia: ");
                    double preco_por_dia = scanner.nextDouble();
                    scanner.nextLine();
                    games.adicionarGames(nome, categoria, ano_de_lancamento, disponivel, url_game, preco_por_dia);
                    break;
                case 3:
                    System.out.print("Sistema de atualização do Game");
                    System.out.print("\nId do Game a ser atualizado: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Novo nome");
                    String novoNome = scanner.nextLine();
                    System.out.print("Nova categoria: ");
                    String novaCategoria = scanner.nextLine();
                    System.out.print("Nova Ano de lançamento: ");
                    int novo_ano_de_lancamento = scanner.nextInt();
                    System.out.print("Novo Status (true/false): ");
                    boolean novoStatus = scanner.nextBoolean();
                    System.out.print("Nova Imagem do Game: ");
                    String nova_url_game = scanner.nextLine();
                    System.out.print("Novo preço por dia: ");
                    double novo_preco_por_dia = scanner.nextDouble();
                    games.atualizarGames(idAtualizar, novoNome, novaCategoria, novo_ano_de_lancamento, novoStatus, nova_url_game, novo_preco_por_dia);
                    break;
                case 4:
                    System.out.print("Sistema de remoção do Game");
                    System.out.print("Id do Game a ser removido: ");
                    int idRemover = scanner.nextInt();
                    scanner.nextLine();
                    games.removerGames(idRemover);
                    break;
                case 5:
                    return;
                default:
                    System.out.print("Opção inexistente, por favor digite novamente.");
                }
            }
        }

/* ============================= Menu Preços ============================= */

    /**
     * Exibe o menu de gerenciamento de preços e realiza operações como buscar,
     * adicionar, atualizar e remover preços.
     * 
     * @param scanner Scanner para ler a entrada do usuário.
     */

    public static void menuPrecos(Scanner scanner) {
        Precos precos = new Precos();
        while (true) {
            System.out.println("\nMenu Preços");
            System.out.print("\n" + "-".repeat(40) + "\n");
            System.out.println("1. Buscar todos os preços");
            System.out.println("2. Adicionar um novo preço");
            System.out.println("3. Deletar um preço");
            System.out.println("4. Atualizar um preço");
            System.out.println("5. Voltar ao menu principal");
            System.out.print("-".repeat(40) + "\n");
            System.out.println("Escolha uma opação: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    precos.buscarPrecos();
                    break;
                case 2:
                    System.out.print("Sistema de cadastro do Preço");
                    System.out.print("Categoria: ");
                    String categoria = scanner.nextLine();
                    System.out.print("Preço por dia: ");
                    double preco_por_dia = scanner.nextDouble();
                    scanner.nextLine();
                    precos.adicionarPrecos(categoria, preco_por_dia);
                    break;
                case 3:
                    System.out.print("Sistema de atualização do Preço");
                    System.out.print("Id do preço a ser atualizado: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nova categoria: ");
                    String novaCategoria = scanner.nextLine();
                    System.out.print("Novo preço por dia: ");
                    double novo_preco_por_dia = scanner.nextDouble();
                    precos.atualizarPrecos(idAtualizar, novaCategoria, novo_preco_por_dia);
                    break;
                case 4:
                    System.out.print("Sistema de remoção do Preço");
                    System.out.print("Id do preço a ser removido: ");
                    int idRemover = scanner.nextInt();
                    scanner.nextLine();
                    precos.removerPrecos(idRemover);
                    break;
                case 5:
                    return;
                default:
                    System.out.print("Opção inexistente, por favor digite novamente.");
                }
            }
        }
    }