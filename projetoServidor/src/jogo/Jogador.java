package jogo;

import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Jogador extends UnicastRemoteObject implements JogadorInterface {


    private int quantia = 10, id, indexMao = 0;
    private Game game;
    private boolean started = false, minhaVez = false;
    private String username;
    private CallBackInterface callback;

    private ArrayList<MaoInterface> hands;
    private ArrayList<GerirListener> gerirListeners;

    public Jogador() throws RemoteException {
        super();
    }

    public void addCartasInicio() throws RemoteException {

        Mao hand = (Mao) (hands.get(0));
        hand.addCard(game.getNextCard());
        hand.addCard(game.getNextCard());

    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public MaoInterface getMao(int index) {
        if (hands != null && hands.size() > 0) {
            return this.hands.get(index);
        } else {
            return null;
        }
    }

    public ArrayList<MaoInterface> getMaos() {
        return this.hands;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getQuantia() {
        return quantia;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void alteraQuantia(int vitoria) {
        this.quantia += vitoria;
    }

    public CallBackInterface getCallback() {
        return callback;
    }

    public void setCallback(CallBackInterface callback) {
        this.callback = callback;
    }

    @Override
    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean startedGame) {
        this.started = startedGame;
    }

    public void setMinhaVez(boolean minhaVez) {
        this.minhaVez = minhaVez;
    }

    @Override
    public boolean isMinhaVez() throws RemoteException {
        return this.minhaVez;
    }

    public void addGerirListener(GerirListener sel) {
        if (gerirListeners == null) {
            gerirListeners = new ArrayList<GerirListener>(2);
        }
        gerirListeners.add(sel);
    }

    @Override
    public void desconectado() throws RemoteException {
        eventDesconectar(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
    }

    @Override
    public void start(int aposta) throws RemoteException {
        if (this.started) {
            return;
        }
        MaoInterface hand = new Mao(aposta);
        this.hands = new ArrayList<MaoInterface>();
        this.hands.add(hand);
        eventStart(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
    }

    
    @Override
    public void stand() throws RemoteException {
        if (!this.started) {
            return;
        }
        if (!this.minhaVez) {
            return;
        }
        game.mensagemClientes("Player " + username + " stands");
        game.nextStep();
    }

    @Override
    public void hit() throws RemoteException {
        Mao hand = (Mao) hands.get(indexMao);
        hand.addCard(game.getNextCard());
        game.mensagemClientes("Player " + username + " hits");

        if (hand.getPontos() > 21) {
            game.nextStep();
        }
    }

    void eventDesconectar (ActionEvent e) {
        if (gerirListeners != null) {
            for (int i = 0; i < gerirListeners.size(); i++) {
                gerirListeners.get(i).jogadorDesconectado(e);
            }
        }
    }

    void eventStart(ActionEvent e) throws RemoteException {
        if (gerirListeners != null) {
            for (int i = 0; i < gerirListeners.size(); i++) {
                gerirListeners.get(i).jogadorComecouJogo(e);
            }
        }
    }
}
