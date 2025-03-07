<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Jogo "Combate Remasterizado"</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            color: #333;
            margin: 40px;
        }
        h1 {
            color: #2e8b57;
        }
        h2 {
            color: #333;
        }
        ul {
            list-style-type: none;
            padding: 0;
        }
        li {
            padding: 5px 0;
        }
        .highlight {
            color: #ff6347;
        }
        .instructions {
            background-color: #eef;
            padding: 10px;
            border-radius: 5px;
        }
        .code-snippet {
            background-color: #282c34;
            color: white;
            padding: 10px;
            border-radius: 5px;
            font-family: 'Courier New', Courier, monospace;
        }
    </style>
</head>
<body>

    <h1>Jogo "Combate Remasterizado"</h1>

    <p><strong>Descrição:</strong></p>
    <p>"Combate Remasterizado" é um jogo de batalha de tanques desenvolvido em Java utilizando a plataforma Greenfoot. O jogo oferece ao jogador uma experiência onde ele controla um tanque marrom e deve destruir 10 tanques inimigos para vencer. O jogo inclui elementos de estratégia, como gerenciamento de munição e coleta de suprimentos. A cada vitória, o jogador avança para uma nova fase do jogo.</p>

    <h2><span class="highlight">Objetivo do Jogo:</span></h2>
    <ul>
        <li>Controle o tanque marrom utilizando as setas direcionais do teclado.</li>
        <li>Atire usando a tecla "F".</li>
        <li>Destrua os tanques inimigos para somar pontos e alcançar 1000 pontos para vencer.</li>
        <li>Recolha munição deixada por um avião sobrevoador quando os tiros do jogador estiverem abaixo de 90.</li>
        <li>Vença a batalha eliminando todos os tanques inimigos e complete o objetivo de derrotá-los.</li>
    </ul>

    <h2><span class="highlight">Como Jogar:</span></h2>
    <ol>
        <li><strong>Tela Inicial:</strong> O jogador aprenderá as instruções do jogo e pressionará ENTER para iniciar o jogo.</li>
        <li><strong>Campo de Batalha:</strong> A fase inicial começa e o jogador controla o tanque enquanto tenta eliminar os inimigos e recolher suprimentos.</li>
        <li><strong>Vencer ou Perder:</strong> O jogador vence quando atingir 1000 pontos, eliminando todos os tanques inimigos. Caso o jogador seja atingido, ele perde.</li>
        <li><strong>Nova Partida:</strong> O jogador pode reiniciar o jogo pressionando ENTER após uma derrota ou vitória.</li>
    </ol>

    <h2><span class="highlight">Estrutura do Jogo:</span></h2>
    <ul>
        <li><strong>Tela Inicial:</strong> Apresenta as instruções e opções de início do jogo.</li>
        <li><strong>Campo de Batalha:</strong> Local onde ocorre a ação do jogo, com os tanques do jogador e inimigos.</li>
        <li><strong>Tela de Vitória:</strong> Mostra uma mensagem quando o jogador vence a partida.</li>
        <li><strong>Tela de Derrota:</strong> Exibe a mensagem quando o jogador perde e permite reiniciar o jogo.</li>
    </ul>

    <h2><span class="highlight">Recursos:</span></h2>
    <ul>
        <li><strong>Música de Fundo:</strong> Sons de vitória e derrota são tocados ao longo do jogo.</li>
        <li><strong>Elementos Visuais:</strong> Animações de tanques e um avião aliado que deixa munição para o jogador.</li>
        <li><strong>Controles:</strong> Setas do teclado para movimentar o tanque e tecla "F" para atirar.</li>
    </ul>

    <h2><span class="highlight">Tecnologias Utilizadas:</span></h2>
    <ul>
        <li>Java</li>
        <li>Greenfoot (plataforma de desenvolvimento de jogos)</li>
    </ul>

</body>
</html>
