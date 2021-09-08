package jogo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Mao extends UnicastRemoteObject implements MaoInterface {

    private ArrayList<Card> cartas;
    private int aposta;
    private int valor;

    public Mao(int aposta) throws RemoteException {
        cartas = new ArrayList<Card>();
        this.aposta = aposta;
    }

    public ArrayList<Card> getCards() {
        return cartas;
    }

    public int getAposta() throws RemoteException {
        return aposta;
    }

    public void setAposta(int aposta) {
        this.aposta = aposta;
    }

    public void addCard(Card card) {
        this.cartas.add(card);
    }

    @Override
    public int getPontos() throws RemoteException {
        int totalPontos = 0;

        int numAs = 0;

        for (int i = 0; i < cartas.size(); i++) {
            Card bjc = (Card) cartas.get(i);
            if (bjc.getValor() == 1) {
                numAs++;
            }
            int ponto = bjc.getPontos();
            if (ponto == 1) {
                ponto = 11;
            }
            totalPontos += ponto;
        }

        while (totalPontos > 21 && numAs > 0) {
            totalPontos -= 10;
            numAs--;
        }

        valor = totalPontos;

        return totalPontos;
    }

    public int getValor() throws RemoteException {
        return valor;
    }

    @Override
    public ArrayList<int[]> getCardsIntArray() throws RemoteException {
        ArrayList<int[]> cartasInts = new ArrayList<int[]>();
        for (Card card : cartas) {
            cartasInts.add(card.toIntArray());
        }
        return cartasInts;
    }

}
