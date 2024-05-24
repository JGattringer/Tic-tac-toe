import java.util.Random;
import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        // Iniciamos nosso scanner
        Scanner sc = new Scanner(System.in);

        // Declaramos nossas matriz e placares e variaveis de controle
        char[][] tabuleiro = new char[3][3];
        boolean[][] tabuleiroMarcado = new boolean[3][3];
        boolean jogaNovamente = true;
        int placarPlayer1 = 0;
        int placarPlayer2 = 0;

        // Recebemos os nomes dos jogadores nas variaveis player1, player2.
        System.out.println("Bem Vindo ao Jogo da Velha!!");

        System.out.print("Por favor digite o nome do Player 1: ");
        String player1 = sc.nextLine().trim();

        System.out.print("Agora digite o nome do Player 2: ");
        String player2 = sc.nextLine().trim();

        System.out.println();

        // Loop externo ao jogo controla quando o programa encerra
        while(jogaNovamente) {

            // Inicializamos o tabuleiro com espaços vazios
            for (int i = 0; i < tabuleiro.length; i++) {
                for (int j = 0; j < tabuleiro[i].length; j++) {
                    tabuleiro[i][j] = ' ';
                }
            }

            // Geramos um numero random entre 1 - 10 para sortear o jogador.
            int randomNumber = new Random().nextInt(10) + 1;
            String playerAtual;

            // Condicao pora descobrir qual jogador vai comecar!
            // Se o numero sorteado for impar o jogador 1 inica caso contrario o 2.
            if (randomNumber % 2 == 0) {
                playerAtual = player2;
            } else {
                playerAtual = player1;
            }

            System.out.println("O jogador que vai iniciar o jogo e o: " + playerAtual);
            System.out.println("Por favor, jogador " + playerAtual + " escolha a sua peca!");
            System.out.println("Digite 'X' ou 'O' para escolher sua peca!");

            // declaramos variaveis para receber o valor da peca do player.
            char player1Peca;
            char player2Peca;

            // Loop para definir as pecas de cada jogador.
            while (true) {
                char pecaEscolhida = sc.nextLine().toUpperCase().charAt(0);

                if (pecaEscolhida == 'X' || pecaEscolhida == 'O') {
                    // Checamos qual e o player atual para definir sua peca!
                    if (playerAtual.equals(player1)) {
                        player1Peca = pecaEscolhida;

                        if (player1Peca == 'X') {
                            player2Peca = 'O';
                        } else {
                            player2Peca = 'X';
                        }
                    } else {
                        player2Peca = pecaEscolhida;
                        if (player2Peca == 'X') {
                            player1Peca = 'O';
                        } else {
                            player1Peca = 'X';
                        }
                    }
                    break;
                } else {
                    System.out.println("Escolha inválida. Por favor, digite 'X' ou 'O' para escolher sua peça!");
                }
            }

            // variavel para receber o valor da peca do jogador atual.
            char pecaAtual;

            // Condicao para definir qual vai ser a peca do jogador atual definida no loop anterior.
            if (playerAtual.equals(player1)) {
                pecaAtual = player1Peca;
            } else {
                pecaAtual = player2Peca;
            }

            System.out.println();

            // Iniciando a partida!
            System.out.println("Iniciando a partida e gerando tabuleiro......");
            System.out.println("Vamos comecar o jogo! O jogador que vai iniciar o jogo e o : " + playerAtual);
            System.out.println(" Jogador " + playerAtual + " Sua peca e a: " + pecaAtual);

            // definimos uma variavel boolean para controlar a said do loop das regras do jogo.
            boolean gameOver = false;

            // Loop com a logica do jogo
            while (!gameOver) {

                // Exibimos o tabuleiro com números de linhas e colunas
                System.out.println("    1   2   3"); // Cabeçalho das colunas
                for (int i = 0; i < tabuleiro.length; i++) {
                    System.out.print((i + 1) + " "); // Índice das linhas

                    for (int j = 0; j < tabuleiro[i].length; j++) {
                        System.out.print("|_");
                        System.out.print(tabuleiro[i][j]);
                        System.out.print("_");
                    }
                    System.out.println("|");
                }
                System.out.println();

                // Loop para escolher a jogada
                while (true) {

                    boolean entradaValida = false;
                    int linha = -1, coluna = -1;

                    do {
                        System.out.println("Por favor, " + playerAtual + ", escolha uma linha de 1 - 3: ");
                        // verifica se o scanner recebeu um int como valor para a linha
                        if (sc.hasNextInt()) {
                            linha = sc.nextInt() - 1;
                            System.out.println("Por favor, " + playerAtual + ", escolha uma coluna de 1 - 3: ");
                            // verifica se o scanner recebeu um int como valor para a coluna
                            if (sc.hasNextInt()) {
                                coluna = sc.nextInt() - 1;
                                // Verificar se as coordenadas estão dentro dos limites do tabuleiro
                                // e se a posição no tabuleiro ainda não foi marcada
                                if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && !tabuleiroMarcado[linha][coluna]) {
                                    entradaValida = true;
                                } else {
                                    System.out.println("Posição inválida ou já marcada. Por favor, escolha outra posição.");
                                }
                            } else {
                                System.out.println("Entrada inválida para a coluna. Por favor, insira um número inteiro válido.");
                            }
                        } else {
                            System.out.println("Entrada inválida para a linha. Por favor, insira um número inteiro válido.");
                        }
                    } while (!entradaValida);

                    tabuleiro[linha][coluna] = pecaAtual;
                    tabuleiroMarcado[linha][coluna] = true;

                    sc.nextLine();// Limpamos o buffer
                    break;
                }
                // Verificamos se um  dos jogadores ja ganhou, ou a partida terminou em empate!
                // Verifica linhas
                for (int i = 0; i < 3; i++) {
                    if (tabuleiro[i][0] == pecaAtual && tabuleiro[i][1] == pecaAtual && tabuleiro[i][2] == pecaAtual) {
                        gameOver = true;
                        break;
                    }
                }
                // Verifica colunas
                for (int j = 0; j < 3; j++) {
                    if (tabuleiro[0][j] == pecaAtual && tabuleiro[1][j] == pecaAtual && tabuleiro[2][j] == pecaAtual) {
                        gameOver = true;
                        break;
                    }
                }
                // Verifica diagonais
                if (tabuleiro[0][0] == pecaAtual && tabuleiro[1][1] == pecaAtual && tabuleiro[2][2] == pecaAtual) {
                    gameOver = true;
                }
                if (tabuleiro[0][2] == pecaAtual && tabuleiro[1][1] == pecaAtual && tabuleiro[2][0] == pecaAtual) {
                    gameOver = true;
                }
                // Se alguém gameOver, declara o vencedor e termina o jogo
                if (gameOver) {
                    System.out.println("O jogo terminou e o ganhador foi o jogador " + playerAtual + "!");

                    // Printamos o jogo final com a ultima jogada vencedora!
                    System.out.println("    1   2   3"); // Cabeçalho das colunas
                    for (int i = 0; i < tabuleiro.length; i++) {
                        System.out.print((i + 1) + " "); // Índice das linhas

                        for (int j = 0; j < tabuleiro[i].length; j++) {
                            System.out.print("|_");
                            System.out.print(tabuleiro[i][j]);
                            System.out.print("_");
                        }
                        System.out.println("|");
                    }

                    System.out.println();

                    // adiciona 1 ponto ao jogador vencedor!
                    if(playerAtual.equals(player1)) {
                        placarPlayer1++;
                    }
                    else{
                        placarPlayer2++;
                    }
                    System.out.println("Pontuacao Player 1 : " + placarPlayer1 + " Placar Player 2 : " + placarPlayer2);
                    continue;
                }

                // Verifica se o jogo terminou em empate
                boolean tabuleiroCompleto = true;
                for (int i = 0; i < tabuleiroMarcado.length; i++) {
                    for (int j = 0; j < tabuleiroMarcado[i].length; j++) {
                        if (!tabuleiroMarcado[i][j]) {
                            tabuleiroCompleto = false;
                            break;
                        }
                    }
                    if (!tabuleiroCompleto) {
                        break;
                    }
                }
                // Se todos os espaços estão usados e ninguém venceu, declara empate
                if (tabuleiroCompleto) {
                    System.out.println("O jogo terminou em empate!");
                    System.out.println("Pontuacao Player 1 : " + placarPlayer1 );
                    System.out.println("Placar Player 2 : " + placarPlayer2);
                    gameOver = true;
                    continue;
                }

                System.out.println();

                // Alternar jogadores
                if (playerAtual.equals(player1)) {
                    playerAtual = player2;
                    pecaAtual = player2Peca;
                } else {
                    playerAtual = player1;
                    pecaAtual = player1Peca;
                }
            }
            System.out.println("Deseja jogar novamente? Digite 'Sim' para jogar novamente ou 'Nao' para encerrar!");
            // Loop para vereficar se os jogadores querem jogar novamente!
            while (true) {
                String escolha = sc.nextLine().toUpperCase();
                if (!escolha.isEmpty()) { // Verifica se a entrada não está vazia
                    char opcao = escolha.charAt(0);
                    if (opcao == 'S') {
                        jogaNovamente = true;

                        // reiniciamos a tabela conferencia caso o jogador queira jogar novacmente.
                        for (int i = 0; i < tabuleiroMarcado.length; i++) {
                            for (int j = 0; j < tabuleiroMarcado.length ; j++) {
                                tabuleiroMarcado[i][j] = false;
                            }
                        }
                        // Saimos do loop da partida e voltamos ao loop externo para continuar o jogo.
                        System.out.println();
                        break;

                    } else if (opcao == 'N') {
                        System.out.println("Parabens pela vitoria, estamos encerrando o programa.....");
                        // tornamos a variavel de controle falsa, saimos do loop da partida e encerramos o programa!
                        jogaNovamente = false;
                        break;

                    } else {
                        System.out.println("Resposta inválida, tente novamente!");
                    }
                } else {
                    System.out.println("Resposta inválida, tente novamente!");
                }
            }
        }
        // fechamos o scanner
        sc.close();
    }
}
