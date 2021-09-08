package jogo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Dealer extends UnicastRemoteObject implements JogadorInterface {

    private ArrayList<MaoInterface> maos;
    private Game game;

    public Dealer(Game game) throws RemoteException {
        super();
        this.game = game;
    }
	
    public void addCartasInicio() throws RemoteException {
        MaoInterface hand = new Mao(0);
        ((Mao) hand).addCard(game.getNextCard());
        ((Mao) hand).addCard(game.getNextCard());
        ((Mao) hand).getCards().get(0).visivel = false;

        maos = new ArrayList<MaoInterface>();
        maos.add(hand);
    }

    public void mostraPrimeiraCartaDelaer() {
        ((Mao) maos.get(0)).getCards().get(0).visivel = true;
    }

    public void vezDealer() {
        Mao hand = (Mao) maos.get(0);
        try {
            while (hand.getPontos() < 17) {
                this.hit();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void desconectado() throws RemoteException {
    }

    @Override
    public void start(int aposta) throws RemoteException {
    }

    @Override
    public boolean isMinhaVez() throws RemoteException {
        return false;
    }

    @Override
    public void stand() throws RemoteException {
        game.mensagemClientes("Dealer stand");
    }

    @Override
    public void hit() throws RemoteException {

        Mao hand = (Mao) maos.get(0);
        hand.addCard(game.getNextCard());

        game.mensagemClientes("Dealer hit");
    }

    @Override
    public String getUsername() throws RemoteException {
        // TODO Auto-generated method stub
        return "Dealer";
    }

    @Override
    public int getQuantia() throws RemoteException {
        // TODO Auto-generated method stub
        return -1;
    }

    @Override
    public int getId() throws RemoteException {
        // TODO Auto-generated method stub
        return -1;
    }

    @Override
    public boolean isStarted() throws RemoteException {
        // TODO Auto-generated method stub
        return false;
    }

    public ArrayList<MaoInterface> getMaos() throws RemoteException {
        return this.maos;
    }

    @Override
    public MaoInterface getMao(int index) throws RemoteException {
        return maos.get(index);
    }
}
