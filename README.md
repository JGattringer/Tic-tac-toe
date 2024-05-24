# Jogo da Velha
Bem-vindo ao Jogo da Velha! Este é um jogo clássico para dois jogadores, onde cada jogador escolhe uma peça (X ou O) e tenta formar uma linha horizontal, vertical ou diagonal no tabuleiro.

## Descrição
Este programa é uma implementação simples do jogo da velha em Java. Ele permite que dois jogadores humanos joguem entre si, alternando turnos até que um jogador vença ou o jogo termine em empate.

## Funcionalidades
- Dois jogadores podem jogar entre si.
- Os jogadores escolhem suas peças (X ou O) no início do jogo.
- O programa alterna automaticamente os turnos entre os jogadores.
- Verifica automaticamente se um jogador ganhou ou se o jogo terminou em empate.
- Mantém a pontuação dos jogadores.
- Permite que os jogadores joguem várias partidas.
## Como Executar
- Certifique-se de ter o Java instalado em sua máquina.
- Compile o código com o comando:
```javac JogoDaVelha.java```
- Execute o programa com o comando:
```java JogoDaVelha```

## Como Jogar

## Início do Jogo:

- O programa solicitará os nomes dos dois jogadores.
    Um número aleatório é gerado para decidir qual jogador começará.
- O jogador inicial escolhe sua peça (X ou O) e a peça do outro jogador é automaticamente atribuída.
    Durante o Jogo:
    
- O tabuleiro é exibido com as posições disponíveis.
- O jogador atual escolhe a posição onde deseja colocar sua peça.
- O programa verifica se houve uma vitória ou empate após cada jogada.
- 
## Fim do Jogo:

- Se um jogador formar uma linha (horizontal, vertical ou diagonal) com suas peças, ele vence e sua pontuação é incrementada.
- Se todas as posições do tabuleiro forem preenchidas sem que haja um vencedor, o jogo termina em empate.
- O programa pergunta se os jogadores desejam jogar novamente. Se a resposta for "Sim", uma nova partida começa. Caso contrário, o programa é encerrado.

## Exemplo de uso:
    Bem Vindo ao Jogo da Velha!!
    
    Por favor digite o nome do Player 1: Alice
    Agora digite o nome do Player 2: Bob
    
    O jogador que vai iniciar o jogo e o: Alice
    Por favor, jogador Alice escolha a sua peca!
    Digite 'X' ou 'O' para escolher sua peca!
    X
    
    Iniciando a partida e gerando tabuleiro......
    Vamos comecar o jogo! O jogador que vai iniciar o jogo e o : Alice
    Jogador Alice Sua peca e a: X
        1   2   3
    1 |_ _|_ _|_ _|
    2 |_ _|_ _|_ _|
    3 |_ _|_ _|_ _|
    
    Por favor, Alice, escolha uma linha de 1 - 3: 1
    Por favor, Alice, escolha uma coluna de 1 - 3: 1

## Estrutura do Código
O código está estruturado da seguinte forma:

- Declaração de Variáveis: Variáveis para o tabuleiro, controle de jogadas e placar.
- Entrada de Jogadores: Recebe os nomes dos jogadores e sorteia quem inicia.
- Configuração de Peças: O jogador inicial escolhe sua peça.
- Loop do Jogo: Alterna entre os jogadores, recebe as jogadas e verifica as condições de vitória ou empate.
- Fim de Partida: Exibe o resultado da partida, atualiza o placar e pergunta se os jogadores desejam jogar novamente.
- Encerramento: Fecha o scanner e encerra o programa.
## Autor
Este código foi desenvolvido por Joao Gattringer. Sinta-se à vontade para modificá-lo e melhorá-lo!

Divirta-se jogando o Jogo da Velha!
