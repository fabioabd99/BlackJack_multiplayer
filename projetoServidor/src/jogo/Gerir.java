package jogo;

import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Gerir extends UnicastRemoteObject implements GerirInterface {

    private static Gerir gerir = null;
    private Game game;
    private JogadorInterface[] jogadores = new JogadorInterface[3];

    private Gerir() throws RemoteException {
        super();
    }

    public static Gerir getGerir() throws RemoteException {
        if (gerir == null) {
            return new Gerir();
        } else {
            return gerir;
        }
    }

    @Override
    public JogadorInterface login(CallBackInterface callback, String name) throws RemoteException {

        for (int i = 0; i < jogadores.length; i++) {
            if (jogadores[i] == null) {

                for (JogadorInterface jogador : jogadores) {
                    if (jogador != null) {
                        ((Jogador) jogador).getCallback().mensagem("Novo Jogador: " + name + " entrou no jogo\n", this);
                    }
                }

                jogadores[i] = new Jogador();
                ((Jogador) jogadores[i]).setId(i);
                ((Jogador) jogadores[i]).setUsername(name);
                ((Jogador) jogadores[i]).setCallback(callback);

                System.out.println(jogadores[i].getUsername() + " conectou-se as " + new java.util.Date());
                ((Jogador) jogadores[i]).addGerirListener(new MyGerirListener());

                return jogadores[i];
            }
        }
        return null;
    }

    @Override
    public String[] getNomes() throws RemoteException {
        String[] nomes = new String[3];
        for (int i = 0; i < jogadores.length; i++) {
            if (jogadores[i] == null) {
                nomes[i] = null;
            } else {
                nomes[i] = jogadores[i].getUsername();
            }
        }
        return nomes;
    }

    @Override
    public int[] getQuantias() throws RemoteException {
        int[] quantia = new int[3];
        for (int i = 0; i < jogadores.length; i++) {
            if (jogadores[i] == null) {
                return null;
            } else {
                quantia[i] = jogadores[i].getQuantia();
            }
        }
        return quantia;
    }

    public JogadorInterface[] getJogadores() throws RemoteException {
        return this.jogadores;
    }

    class MyGerirListener implements GerirListener {

        @Override
        public void jogadorDesconectado(ActionEvent e) {
            Jogador jogador = (Jogador) e.getSource();
            int id = jogador.getId();
            String name = jogador.getUsername();
            jogadores[id] = null;

            System.out.println(name + " saiu do jogo.");
        }

        @Override
        public void jogadorComecouJogo(ActionEvent e) throws RemoteException {

            Jogador jogador = (Jogador) e.getSource();
            jogador.setStarted(true);

            if (checkTodosJogadoresProntos()) {
                game = new Game(Gerir.this, jogadores);
            }
        }
    }

    private boolean checkTodosJogadoresProntos() {
        for (JogadorInterface jogador : jogadores) {
            try {
                if ((jogador != null) && !jogador.isStarted()) {
                    return false;
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public JogadorInterface getDealer() throws RemoteException {
        if (this.game != null) {
            return this.game.getDealer();
        } else {
            return null;
        }
    }
}
