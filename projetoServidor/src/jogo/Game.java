package jogo;

import java.rmi.RemoteException;

public class Game {

    private Gerir gerir;
    private Jogador[] jogadores;
    private Dealer dealer;
    private int vezJogador;
    private Deck cardPack;

    public Game(Gerir gerir, JogadorInterface[] jogadores) throws RemoteException {

        this.gerir = gerir;

        cardPack = new Deck();
        cardPack.shuffle();

        dealer = new Dealer(this);

        this.jogadores = new Jogador[jogadores.length];
        for (int i = 0; i < jogadores.length; i++) {
            if (jogadores[i] != null) {
                this.jogadores[i] = (Jogador) jogadores[i];
                this.jogadores[i].setGame(this);
            }
        }

        vezJogador = -1;

        System.out.println("Jogo começou");

        start();
    }

    public JogadorInterface getDealer() {
        return this.dealer;
    }

    public void start() throws RemoteException {
        dealer.addCartasInicio();

        for (int i = 0; i < jogadores.length; i++) {
            if (jogadores[i] != null) {
                jogadores[i].addCartasInicio();
            }
        }

        mensagemClientes("Jogo começou");
        nextStep();
    }

    public Card getNextCard() {
        if (!cardPack.hasNext()) {
            cardPack.shuffle();
        }
        return cardPack.next();
    }

    public void nextStep() {

        //definir a vez do jogador anterior para falso
        if (vezJogador >= 0 && jogadores[vezJogador] != null) {
            jogadores[vezJogador].setMinhaVez(false);
        }

        vezJogador++;
        while (vezJogador < jogadores.length) {

            //se ainda houver jogador para mover
            if (jogadores[vezJogador] != null) {

                //definir a vez do jogador para verdadeiro
                jogadores[vezJogador].setMinhaVez(true);
                System.out.println("É a vez do " + jogadores[vezJogador].getUsername() + " !!!");
                mensagemClientes("É a vez do " + jogadores[vezJogador].getUsername() + " !!!");
                return;
            }
            vezJogador++;
        }

        System.out.println("É a vez do Dealer");
        mensagemClientes("É a vez do Dealer");

        dealer.mostraPrimeiraCartaDelaer();
        dealer.vezDealer();

        calcularResultado();

        for (Jogador jogador : jogadores) {
            if (jogador != null) {
                jogador.setStarted(false);

            }
        }
        mensagemClientes("Ronda acabou");
    }

    public void calcularResultado() {

        try {
            int pontosDealer = dealer.getMaos().get(0).getPontos();
            for (Jogador jogador : jogadores) {
                if (jogador != null) {
                    Mao mao = (Mao) jogador.getMaos().get(0);
                    int pontosJogador = mao.getPontos();
                    int aposta = mao.getAposta();
                    if (pontosJogador >= 22) {
                        jogador.alteraQuantia(0 - aposta);
                        mensagemClientes(jogador.getUsername() + " perdeu.");
                    } else {
                        if (pontosDealer < 22) {
                            if (pontosJogador < pontosDealer) {
                                jogador.alteraQuantia(0 - aposta);
                                mensagemClientes(jogador.getUsername() + " perdeu.");
                            } else if (pontosJogador > pontosDealer) {
                                jogador.alteraQuantia(aposta);
                                mensagemClientes(jogador.getUsername() + " ganhou.");
                            } else {
                                mensagemClientes(jogador.getUsername() + " empatou.");
                            }
                        } else {
                            jogador.alteraQuantia(aposta);
                            mensagemClientes(jogador.getUsername() + " ganhou.");
                        }
                    }
                }
            }

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void mensagemClientes(String mensagem) {
        for (Jogador jogador : jogadores) {
            if (jogador != null) {
                try {
                    jogador.getCallback().mensagem(mensagem, gerir);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
