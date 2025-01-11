import javax.imageio.stream.ImageInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class GameStart {

    //****************      FUNCOES INICIAIS     *************************************

    /**
     * funcao Logo inicial
     * @throws FileNotFoundException
     */
    public static void introducao() throws FileNotFoundException {

        File file = new File("Ficheiro_GameStart/Logo");
        Scanner sc = new Scanner(file);

        final String AMARELO = "\u001B[33m";
        final String RESET = "\u001B[0m";
        final String BOLD = "\u001B[1m";  // Códigos ANSI para negrito (não é garantido que funcione em todos os terminais)

        while (sc.hasNextLine()) {
            System.out.println(AMARELO + sc.nextLine() + RESET);
        }

        System.out.println();
        System.out.println("**************************************************************************");
        System.out.println("*                                                                        *");
        System.out.println("*" + BOLD + AMARELO + "             B E M - V I N D O   A O   G A M E S T A R T                " + RESET + "*");
        System.out.println("*                                                                        *");
        System.out.println("*" + AMARELO + "                 .-.   .-.           .---.                              " + RESET + "*");
        System.out.println("*" + AMARELO + "                | OO| | OO|         /  _.-' .-.   .-.  .-.              " + RESET + "*");
        System.out.println("*" + AMARELO + "                |   | |   |         |  '-.  '-'   '-'  '-'              " + RESET + "*");
        System.out.println("*" + AMARELO + "                '^^^' '^^^'          '---'                              " + RESET + "*");
        System.out.println("*" + AMARELO + "                                                                        " + RESET + "*");
        System.out.println("**************************************************************************");
        System.out.println();
        System.out.println(BOLD + "Bem-vindo ao sistema de gestão da GameStart! \nUma loja online de jogos pensada para facilitar a sua vida." + RESET);
        System.out.println();

    }

    /**
     * Funcao menuInicial (escolher o tipo de usuário)
     * @throws FileNotFoundException
     */
    public static void menuInicial() throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);

        int numero, opcao = 0;

        final String AMARELO = "\u001B[33m";
        final String RESET = "\u001B[0m";


        // menu switch para cliente escolher entre administrador, cliente e sair do programa
        do {
            System.out.println(" ");
            System.out.println(AMARELO + "**************************************************************************" + RESET);
            System.out.println(AMARELO + "*                      ESCOLHA O SEU TIPO DE USUÁRIO                     *" + RESET);
            System.out.println(AMARELO + "**************************************************************************" + RESET);
            System.out.println(AMARELO + "1." + RESET + "Administrador");
            System.out.println(AMARELO + "2." + RESET + "Cliente");
            System.out.println(AMARELO + "3." + RESET + "Terminar o Programa");
            System.out.println();
            opcao = sc.nextInt();

            switch (opcao) {

                case 1: // Administrador
                    System.out.println("Seleccionou a opção administrador.");
                    loginAdministrador();
                    break;

                case 2: // Cliente
                    System.out.println("Seleccionou a opção cliente.");
                    menuCliente();
                    break;

                case 3: // Terminar o Programa
                    sairPrograma();
                    sc.close(); // Fechar o Scanner do input
                    return;


                default:
                    System.out.println("Opção inválida. Tente novamente.");

            }
        } while (opcao != 1 && opcao != 2 && opcao != 3);


    }

    //****************      FUNCOES ADMINISTRADOR     *************************************

    /**
     * Funcao password/login do administrador
     * @throws FileNotFoundException
     */
    public static void loginAdministrador() throws FileNotFoundException {
        final String AMARELO = "\u001B[33m";
        final String RED = "\033[0;91m";
        final String RESET = "\u001B[0m";
        final String MAGENTA = "\u001B[35m";

        Scanner sc = new Scanner(System.in);

        String passwordCorrecta = "pass123";
        String voltar = "voltar";

        int tentativas = 3; // apenas 3 tentativas

        // Menu inserir password
        while (tentativas > 0) {
            System.out.println(AMARELO + "**************************************************************************" + RESET);
            System.out.println(AMARELO + "*                         LOGIN DO ADMINISTRADOR                         *" + RESET);
            System.out.println(AMARELO + "**************************************************************************" + RESET);
            System.out.println("Insira a sua password para aceder ao programa como administrador.");
            System.out.println();
            System.out.print("\uD83D\uDD11 " + MAGENTA + "Password ou 'voltar': " + RESET);
            System.out.println();
            String entrada = sc.nextLine();

            // Ciclo para 3 tentativas de password
            if (entrada.equals(passwordCorrecta)) {
                menuAdministrador(); //função menu administrador
                return;
            } else if (entrada.equals(voltar)) {
                menuInicial(); //função menu inicial
                return;
            } else {
                tentativas--;
                System.out.println(RED + "Password incorreta. Tem " + tentativas + " tentativa(s) restante(s)." + RESET);
            }
        }

        System.out.println(RED + "Esgotou as suas tentativas. Irá voltar ao menu inicial." + RESET);
        menuInicial();
    }

    /**
     * Funcao menu do Administrador
     * @throws FileNotFoundException
     */
    public static void menuAdministrador() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        final String AMARELO = "\u001B[33m";
        final String RESET = "\u001B[0m";
        final String RED = "\033[0;91m";

        int opcaoAdmin;

        //menu administrador e guardar opção do usuario
        do {
            System.out.println(" ");
            System.out.println(AMARELO + "**************************************************************************" + RESET);
            System.out.println(AMARELO + "*                          MENU ADMINISTRADOR                            *" + RESET);
            System.out.println(AMARELO + "**************************************************************************" + RESET);
            System.out.println(AMARELO + "1." + RESET + "Exibir o catálogo total");
            System.out.println(AMARELO + "2." + RESET + "Mostrar o número total de vendas realizadas e o valor total acumulado ");
            System.out.println(AMARELO + "3." + RESET + "Lucro total");
            System.out.println(AMARELO + "4." + RESET + " Dados do cliente");
            System.out.println(AMARELO + "5." + RESET + " Exibir qual foi o jogo mais caro vendido e os clientes que o compraram");
            System.out.println(AMARELO + "6." + RESET + " Exibir o melhor cliente e lista de jogos comprados");
            System.out.println(AMARELO + "7." + RESET + " Voltar ao menu Tipo de Usuário");
            System.out.println(AMARELO + "8." + RESET + " Terminar programa");

            opcaoAdmin = sc.nextInt();

            switch (opcaoAdmin) {
                case 1: //Exibir o catálogo total
                    administradorOpcao1();
                    break;

                case 2://Mostrar o número total de vendas realizadas e o valor total acumulado
                    administradorOpcao2();
                    break;

                case 3://Lucro total
                    administradorOpcao3();
                    break;

                case 4://Dados do cliente
                    administradorOpcao4();
                    break;

                case 5://Exibir qual foi o jogo mais caro vendido e os clientes que o compraram
                    administradorOpcao5();
                    break;

                case 6://Exibir o melhor cliente e lista de jogos comprados
                    administradorOpcao6();
                    break;

                case 7://Voltar ao menu Tipo de Usuário
                    menuInicial();
                    break;

                case 8: // Terminar o Programa
                    sairPrograma();
                    sc.close();
                    return;

                default:
                    System.out.println(RED + "Opção inválida. Tente novamente." + RESET);
            }
        } while (opcaoAdmin != 1 && opcaoAdmin != 2 && opcaoAdmin != 3 && opcaoAdmin != 4 && opcaoAdmin != 5 && opcaoAdmin != 6 &&  opcaoAdmin != 7 && opcaoAdmin != 8);
    }

    /**
     * Funcao menu do Administrador Opcao 1 - mostrar o arquivo inteiro
     * @throws FileNotFoundException
     */
    public static void administradorOpcao1() throws FileNotFoundException {
        final String AMARELO = "\u001B[33m";
        final String RESET = "\u001B[0m";
        final String MAGENTA = "\u001B[35m";

        // Caminho do arquivo CSV
        File ficheiro = new File("Ficheiro_GameStart/GameStart_V2.csv");
        Scanner scanner = new Scanner(ficheiro);

        // Ler o cabeçalho
        String cabecalho = scanner.nextLine();
        String[] colunas = cabecalho.split(";");

        // definir espaçamento entre colunas do ficheiro
        System.out.printf(MAGENTA + "%-10s %-12s %-20s %-12s %-30s %-20s %-15s %-30s %-8s\n",
                colunas[0], colunas[1], colunas[2], colunas[3], colunas[4], colunas[5], colunas[6], colunas[7], colunas[8] + RESET);
        System.out.println("*".repeat(162));

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] dados = linha.split(";");
            System.out.printf("%-10s %-12s %-20s %-12s %-30s %-20s %-15s %-30s %-8s\n",
                    dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], dados[6], dados[7], dados[8]);
        }

        // Fechar scanner
        scanner.close();

        //sair do programa ou voltar ao menu administrador
        sairVoltarMenuAdministrador();
    }

    /**
     * Funcao menu do Administrador Opcao 2 - mostrar o número total de vendas realizadas e o valor total acumulado
     * @throws FileNotFoundException
     */
    public static void administradorOpcao2() throws FileNotFoundException {
        final String MAGENTA = "\u001B[35m";
        final String RESET = "\u001B[0m";

        // Caminho do arquivo CSV
        File ficheiro = new File("Ficheiro_GameStart/GameStart_V2.csv");
        Scanner scanner = new Scanner(ficheiro);

        // Ignorar o cabeçalho
        scanner.nextLine();

        int totalVendas = 0;
        double valorTotal = 0;

        //ciclo para calcular o número total de vendas realizadas
        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] dados = linha.split(";");
            totalVendas++;

            double valorVenda = Double.parseDouble(dados[8]); //total acumulado
            valorTotal += valorVenda;
        }

        // Fechar scanner
        scanner.close();

        System.out.println("Número total de vendas realizadas: " + MAGENTA + totalVendas + RESET);
        System.out.println("Valor total acumulado: " + MAGENTA + valorTotal + " €" + RESET);

        // Sair do programa ou voltar ao menu administrador
        sairVoltarMenuAdministrador();
    }

    /**
     * Funcao menu do Administrador Opcao 3 - Calcular o lucro total, considerando que a GameStart possui 20% de lucro em cada jogo vendido
     * @throws FileNotFoundException
     */
    public static void administradorOpcao3() throws FileNotFoundException {
        final String MAGENTA = "\u001B[35m";
        final String RESET = "\u001B[0m";

        // Caminho do arquivo CSV
        File ficheiro = new File("Ficheiro_GameStart/GameStart_V2.csv");
        Scanner scanner = new Scanner(ficheiro);

        // Ignorar o cabeçalho
        scanner.nextLine();

        int totalVendas = 0;
        double lucroTotal = 0;

        // ciclo para calcular o lucro total e os 20% de lucro
        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] dados = linha.split(";");
            totalVendas++;

            double valorVenda = Double.parseDouble(dados[8]);
            double lucroVenda = valorVenda * 0.20;

            lucroTotal += lucroVenda;
        }

        // Fechar scanner
        scanner.close();

        System.out.println("Número total de vendas realizadas: " + MAGENTA + totalVendas + RESET);
        System.out.println("Lucro total acumulado (20% com cada venda): " + MAGENTA + lucroTotal + " €" + RESET);

        // Sair do programa ou voltar ao menu administrador
        sairVoltarMenuAdministrador();
    }

    /**
     * Funcao menu do Administrador Opcao 4 - Dado um idCliente, exibir todas as informações relacionadas a esse cliente (nome, contato, e-mail)
     * @throws FileNotFoundException
     */
    public static void administradorOpcao4() throws FileNotFoundException {
        final String MAGENTA = "\u001B[35m";
        final String RESET = "\u001B[0m";

        // Caminho do arquivo CSV
        File ficheiro = new File("Ficheiro_GameStart/GameStart_V2.csv");
        Scanner scanner = new Scanner(ficheiro);

        String input;
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.print("\uD83D\uDC64" + MAGENTA + " Indique o ID do cliente: " + RESET);
        System.out.println();
        input = sc.next();

        // Ignorar o cabeçalho
        scanner.nextLine();

        //ciclo para ler o input e ir buscar as informações nas posições da matriz do documento
        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] dados = linha.split(";");

            if (input.equals(dados[1])) {
                System.out.println();
                System.out.println(MAGENTA + "________________________________" + "CLIENTE " + dados[1] + "_______________________________" + RESET);
                System.out.println(MAGENTA + "Nome: " + RESET +  dados[2]);
                System.out.println(MAGENTA + "Contacto: " + RESET + dados[3]);
                System.out.println(MAGENTA + "Email: " + RESET + dados[4]);
                break;
            }
        }

        // Sair do programa ou voltar ao menu administrador
        sairVoltarMenuAdministrador();
    }

    /**
     * Funcao menu do Administrador Opcao 5 - Exibir qual foi o jogo mais caro vendido e os clientes que o compraram.
     * @throws FileNotFoundException
     */
    public static void administradorOpcao5() throws FileNotFoundException {
        final String MAGENTA = "\u001B[35m";
        final String RESET = "\u001B[0m";

        // Caminho do arquivo CSV
        File ficheiro = new File("Ficheiro_GameStart/GameStart_V2.csv");
        Scanner scanner = new Scanner(ficheiro);

        // Ignorar o cabeçalho
        scanner.nextLine();

        double maiorValor = 0.0;
        String jogoMaisCaro = "";

        //ciclo para exibir o jogo mais caro vendido
        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] dados = linha.split(";");

            double valorJogo = Double.parseDouble(dados[8]);

            if (valorJogo > maiorValor) {
                maiorValor = valorJogo;
                jogoMaisCaro = dados[7];
            }
        }

        // Exibir os resultados
        System.out.println();
        System.out.println(MAGENTA + "____________________________ JOGO MAIS CARO _____________________________" + RESET);
        System.out.println(MAGENTA + "Jogo: " + RESET + jogoMaisCaro);
        System.out.println(MAGENTA + "Valor: " + RESET + maiorValor + " €");
        System.out.println();

        scanner = new Scanner(ficheiro);

        //ciclo para verificar quais os clientes que compraram
        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] dados = linha.split(";");

            if (jogoMaisCaro.equals(dados[7])) {
                System.out.println(MAGENTA + "__________________________ CLIENTES QUE COMPRARAM _______________________" + RESET);
                System.out.println(MAGENTA + "ID Cliente: " + RESET + dados[1]);
                System.out.println(MAGENTA + "Nome: " + RESET + dados[2]);
                System.out.println(MAGENTA + "Contacto: " + RESET + dados[3]);
                System.out.println(MAGENTA + "Email: " + RESET + dados[4]);
                System.out.println();
            }
        }

        // Sair do programa ou voltar ao menu administrador
        sairVoltarMenuAdministrador();
    }

    /**
     * Funcao menu do Administrador Opcao 6 - - Exibir o melhor cliente (nome, contato, e-mail), ou seja, aquele que gastou mais na loja, seguido da lista de jogos comprados.
     * @throws FileNotFoundException
     */
    public static void administradorOpcao6() throws FileNotFoundException {
        final String MAGENTA = "\u001B[35m";
        final String RESET = "\u001B[0m";

        // Caminho do arquivo CSV
        File ficheiro = new File("Ficheiro_GameStart/GameStart_V2.csv");
        Scanner scanner = new Scanner(ficheiro);

        // Ignorar o cabeçalho
        scanner.nextLine();

        int numeroClientes = 0;

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] dados = linha.split(";");

            int idCliente = Integer.parseInt(dados[1]);

            if (numeroClientes < idCliente ) {
                numeroClientes = idCliente;
            }
        }

        String[][] arrayClientes = new String[numeroClientes][2];
        String newString = "";

        // Preencher o nosso array
        for (int i = 0; i < numeroClientes; i++) {
            arrayClientes[i][0] = Integer.toString(i + 1);
            arrayClientes[i][1] = Integer.toString(0);
        }

        //comparar dados com arrayClientes
        for (int i = 0; i < arrayClientes.length; i++) {
            scanner = new Scanner(ficheiro);

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] dados = linha.split(";");

                if (arrayClientes[i][0].equals(dados[1]) ) {
                    double num1 = Double.parseDouble(arrayClientes[i][1]);
                    double num2 = Double.parseDouble(dados[8]);
                    num1 += num2;
                    arrayClientes[i][1] = Double.toString(num1);
                }
            }
        }

        Double maiorValorGasto = 0.0;
        String idFinal = "";

        for (int i = 0; i < arrayClientes.length; i++) {
            double valor = Double.parseDouble(arrayClientes[i][1]);

            if (valor > maiorValorGasto) {
                maiorValorGasto = valor;
                idFinal = arrayClientes[i][0];
            }
        }

        scanner = new Scanner(ficheiro);

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] dados = linha.split(";");

            if (idFinal.equals(dados[1])) {
                System.out.println(MAGENTA + "______________________________ MELHOR CLIENTE ____________________________" + RESET);
                System.out.println(MAGENTA + "ID Cliente: " + RESET + dados[1]);
                System.out.println(MAGENTA + "Nome: " + RESET + dados[2]);
                System.out.println(MAGENTA + "Contacto: " + RESET + dados[3]);
                System.out.println(MAGENTA + "Email: " + RESET + dados[4]);
                System.out.println();
                System.out.println(MAGENTA + "Total Gasto: " + RESET + maiorValorGasto + " €");

                break;
            }
        }

        // Sair do programa ou voltar ao menu administrador
        sairVoltarMenuAdministrador();
    }

    /**
     * Funcao sair ou voltar ao Menu Administrador
     * @return
     * @throws FileNotFoundException
     */
    public static boolean sairVoltarMenuAdministrador() throws FileNotFoundException {

        final String RESET = "\u001B[0m";
        final String MAGENTA = "\u001B[35m";

        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println(MAGENTA + "<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>" + RESET);
        System.out.println(MAGENTA + "👉" + " O que deseja fazer de seguida: " + RESET);
        System.out.println();
        System.out.println(MAGENTA + "1." + RESET + " voltar ao menu administrador ");
        System.out.println(MAGENTA + "2." + RESET + " sair do programa: ");
        System.out.println(MAGENTA + "<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>" + RESET);

        int opcao = scanner.nextInt();

        if (opcao == 2) {
            sairPrograma();
            return false;
        } else if (opcao == 1) {
            menuAdministrador();
            return true;
        } else {
            System.out.println("Opção inválida! Tente novamente.");
            return sairVoltarMenuAdministrador();
        }
    }

    /**
     * Funcao para sair do Programa com logo Gameover
     * @throws FileNotFoundException
     */
    public static void sairPrograma() throws FileNotFoundException {
        File file = new File("Ficheiro_GameStart/Gameover");
        Scanner sc = new Scanner(file);

        final String MAGENTA = "\u001B[35m";
        final String RESET = "\u001B[0m";

        while (sc.hasNextLine()) {
            System.out.println(MAGENTA + sc.nextLine() + RESET);
        }
        System.out.println("Escolheu sair do programa. \nAté à próxima, player!!!");
    }



    //****************      FUNCOES MENU CLIENTE    *************************************

    /**
     * Funcao menu cliente
     * @throws FileNotFoundException
     */
    public static void menuCliente() throws FileNotFoundException {
            Scanner sc = new Scanner(System.in);

            final String AMARELO = "\u001B[33m";
            final String RESET = "\u001B[0m";

            int opcaoCliente;

            //ciclo para menu cliente com switch
            do {
                System.out.println(" ");
                System.out.println(AMARELO + "**************************************************************************" + RESET);
                System.out.println(AMARELO + "*                                MENU CLIENTE                            *" + RESET);
                System.out.println(AMARELO + "**************************************************************************" + RESET);
                System.out.println(AMARELO + "1." + RESET + " criar novo registo de cliente");
                System.out.println(AMARELO + "2." + RESET + " verificar vagas de estacionamento disponíveis");
                System.out.println(AMARELO + "3." + RESET + " consultar jogos disponíveis ");
                System.out.println(AMARELO + "4." + RESET + " consultar jogos disponíveis por editora em categorias");
                System.out.println(AMARELO + "5." + RESET + " voltar ao menu Tipo de Usuário");
                System.out.println(AMARELO + "6." + RESET + " terminar programa");

                opcaoCliente = sc.nextInt();

                switch (opcaoCliente) {
                    case 1: //criar novo registo de cliente
                        ClienteOpcao1();
                        break;

                    case 2: //verificar vagas de estacionamento disponíveis
                        ClienteOpcao2();
                        break;

                    case 3://consultar jogos disponíveis
                        ClienteOpcao3();
                        break;

                    case 4://consultar jogos disponíveis por editora em categorias
                        ClienteOpcao4();
                        break;

                    case 5://Voltar ao menu Tipo de Usuário");
                        menuInicial();
                        break;

                    case 6:// Terminar o Programa
                        System.out.println("Escolheu sair do programa. Até à próxima.");
                        sc.close();
                        return;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }

            } while (opcaoCliente != 1 && opcaoCliente != 2 && opcaoCliente != 3 && opcaoCliente != 4 && opcaoCliente != 5);
    }

    /**
     * Funcao registo novo cliente
     * @throws FileNotFoundException
     */
    public static void ClienteOpcao1() throws FileNotFoundException {
        final String AMARELO = "\u001B[33m";
        final String RESET = "\u001B[0m";
        final String MAGENTA = "\u001B[35m";

        //caminho onde vou guardar o ficheiro
        File ficheiroNovo = new File("Ficheiro_GameStart/novosregistos.txt");

        //máquina para escrever no meu ficheiro
        PrintWriter maquinaEscrever = new PrintWriter(ficheiroNovo);

        Scanner sc = new Scanner(System.in);

        System.out.println(AMARELO + "**************************************************************************" + RESET);
        System.out.println(AMARELO + "*                         REGISTO DE NOVO CLIENTE                        *" + RESET);
        System.out.println(AMARELO + "**************************************************************************" + RESET);
        System.out.println();

        // nome do cliente
        System.out.print("\uD83D\uDC64 " + MAGENTA + "Nome: " + RESET);
        String nome = sc.next();

        // contato do cliente
        System.out.print("\u260E\uFE0F " + MAGENTA + "Contato telefónico: " + RESET);
        String contato = sc.next();

        // e-mail do cliente
        System.out.print("\uD83D\uDCE7 " + MAGENTA + "E-mail: " + RESET);
        String email = sc.next();
        System.out.println();

        maquinaEscrever.println(nome + " | " + contato + " | " + email);

        // mensagem sucesso
        System.out.println(MAGENTA + "_________________________________________________________________________" + RESET);
        System.out.println(MAGENTA + "\nNovo registo efetuado com sucesso: " + RESET + nome + " | " + contato + " | " + email);

        //fechar a maquina
        maquinaEscrever.close();

        // menu cliente
        sairVoltarMenuCliente();

    }

    /**
     * funcao para consultar vagas de estacionamento com numeros triangulares
     * @throws FileNotFoundException
     */
    public static void ClienteOpcao2() throws FileNotFoundException {
        final String RESET = "\u001B[0m";
        final String MAGENTA = "\u001B[35m";

        System.out.println(MAGENTA + "__________________ CONSULTAR VAGAS DE ESTACIONAMENTO __________________" + RESET);

        System.out.println(MAGENTA + "\nVagas de estacionamento disponíveis:" + RESET);
        System.out.println();

        int soma = 0;
        for (int i = 1; i <= 121; i++) {
            soma = 0;
            for (int j = 1; j <= i; j++) {
                soma += j;
            }
            if (soma > 121) {
                break;
            }
            if (soma % 5 == 0) {
                System.out.println("Está disponível o lugar: " + MAGENTA + soma + RESET);
            }
        }

        // Voltar ao menu cliente ou sair do programa
        sairVoltarMenuCliente();
    }

    /**
     * Funcao para exibir todos os títulos de jogos disponíveis (sem repetições)
     * @throws FileNotFoundException
     */
    public static void ClienteOpcao3() throws FileNotFoundException {
        final String RESET = "\u001B[0m";
        final String MAGENTA = "\u001B[35m";

        Scanner sc = new Scanner(System.in);

        // Caminho do arquivo CSV
        File ficheiro = new File("Ficheiro_GameStart/GameStart_V2.csv");
        Scanner scanner = new Scanner(ficheiro);

        // Ignorar o cabeçalho
        scanner.nextLine();

        String[] jogosUnicos = new String[200];
        String jogo = "";
        int index = 0;

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] dados = linha.split(";");
            jogo = dados[7];

            boolean encontrado = false;

            for (int i = 0; i < jogosUnicos.length; i++) {
                if (jogo.equals(jogosUnicos[i])) {
                    jogo = jogosUnicos[i];
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                jogosUnicos[index] = jogo;
                index++;
            }
        }

        System.out.println(MAGENTA + "___________________________ JOGOS DISPONÍVEIS _________________________" + RESET);

        for (int i = 0; i < index; i++) {
            System.out.println( jogosUnicos[i]);
        }

        scanner.close();

        //voltar ao menu cliente ou sair do programa
        sairVoltarMenuCliente();
    }

    /**
     * Funcao dada uma Editora, exibir todas as categorias e os respectivos jogos publicados por ela.
     * @throws FileNotFoundException
     */
    public static void ClienteOpcao4() throws FileNotFoundException {
        final String AMARELO = "\u001B[33m";
        final String RESET = "\u001B[0m";
        final String RED = "\033[0;91m";
        final String MAGENTA = "\u001B[35m";

        // Caminho do arquivo CSV
        File ficheiro = new File("Ficheiro_GameStart/GameStart_V2.csv");
        if (!ficheiro.exists()) {
            System.out.println(RED + "Erro: O ficheiro não foi encontrado." + RESET);
            return;
        }

        Scanner sc = new Scanner(ficheiro);
        Scanner sc2 = new Scanner(System.in);

        // Definir tamanho máximo de categorias e jogos
        int maxCategorias = 50;
        int maxJogosPorCategoria = 100;

        // Arrays para armazenar categorias e jogos agrupados
        String[] categorias = new String[maxCategorias];
        String[][] jogosPorCategoria = new String[maxCategorias][maxJogosPorCategoria];
        int[] contadorJogos = new int[maxCategorias]; // Número de jogos por categoria
        int totalCategorias = 0; // Contador de categorias únicas
        boolean existeEditora = false;

        // Solicitar o nome da editora ao utilizador
        System.out.print(MAGENTA + "Digite o nome da editora que procura: " + RESET);
        String editoraInput = sc2.nextLine().trim().toLowerCase();

        // Ignorar o cabeçalho do CSV
        if (sc.hasNextLine()) {
            sc.nextLine();
        }

        // Processar o ficheiro linha por linha
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] items = linha.split(";");

            if (items.length < 9) {
                continue;
            }

            String editora = items[5].trim().toLowerCase();
            String categoria = items[6].trim();
            String jogo = items[7].trim();


            if (editora.equals(editoraInput)) {
                existeEditora = true;

                int categoriaIndex = -1;
                for (int i = 0; i < totalCategorias; i++) {
                    if (categorias[i].equalsIgnoreCase(categoria)) {
                        categoriaIndex = i;
                        break;
                    }
                }

                // NovaS categorias
                if (categoriaIndex == -1) {
                    categorias[totalCategorias] = categoria;
                    jogosPorCategoria[totalCategorias][0] = jogo;
                    contadorJogos[totalCategorias] = 1;
                    totalCategorias++;
                } else {
                    // Categorisa existentes evitar duplicados
                    boolean existe = false;
                    for (int j = 0; j < contadorJogos[categoriaIndex]; j++) {
                        if (jogosPorCategoria[categoriaIndex][j].equalsIgnoreCase(jogo)) {
                            existe = true;
                            break;
                        }
                    }

                    // Adicionar jogo se não for duplicado
                    if (!existe) {
                        jogosPorCategoria[categoriaIndex][contadorJogos[categoriaIndex]] = jogo;
                        contadorJogos[categoriaIndex]++;
                    }
                }
            }
        }

        //jogos por editora por categoria
        if (existeEditora) {
            System.out.println();
            System.out.println(AMARELO + "______________________________ JOGOS POR EDITORA ____________________________" + RESET);
            System.out.println();
            System.out.println(AMARELO + "EDITORA  " + editoraInput.toUpperCase() + RESET);
            System.out.println();
            for (int i = 0; i < totalCategorias; i++) {
                System.out.println(MAGENTA + "  Categoria: " + RESET + categorias[i]);
                for (int j = 0; j < contadorJogos[i]; j++) {
                    System.out.println(MAGENTA + "    Jogo: " + RESET + jogosPorCategoria[i][j]);
                }
            }
            System.out.println();
        } else {
            System.out.println(RED + "Não existem resultados" + RESET);
        }

        //voltar ao menu cliente ou sair do programa
        sairVoltarMenuCliente();

        sc.close();
        sc2.close();

    }

    /**
     * Funcao sair ou voltar ao Menu Cliente
     * @return
     * @throws FileNotFoundException
     */
    public static boolean sairVoltarMenuCliente() throws FileNotFoundException {
        final String AMARELO = "\u001B[33m";
        final String RESET = "\u001B[0m";
        final String MAGENTA = "\u001B[35m";

        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println(MAGENTA + "<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>" + RESET);
        System.out.println(MAGENTA + "👉" + " O que deseja fazer de seguida: " + RESET);
        System.out.println();
        System.out.println(MAGENTA + "1." + RESET + " voltar ao menu cliente ");
        System.out.println(MAGENTA + "2." + RESET + " sair do programa: ");
        System.out.println(MAGENTA + "<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>" + RESET);

        int opcao = scanner.nextInt();

        if (opcao == 2) {
            sairPrograma();
            return false;
        } else if (opcao == 1) {
            menuCliente();
            return true;
        } else {
            System.out.println("Opção inválida! Tente novamente.");
            return sairVoltarMenuCliente();
        }
    }


    //****************      MAIN     *************************************

    public static void main(String[] args) throws FileNotFoundException {

        //chamar a função introducao/logo inicial
        introducao();

        //menu inicial/tipo de usuário
        menuInicial();
    }
}
