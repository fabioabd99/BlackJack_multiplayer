package jogo;

import java.util.Random;

public class Deck {

    private Card[] cartas;
    private int indexAtual;

    public Deck() {

        cartas = new Card[52];
        indexAtual = 0;

        int index = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 14; j++) {
                cartas[index++] = new Card(i, j);
            }
        }

    }
    public void shuffle() {
        for (int i = cartas.length - 1; i > 0; i--) {
            Random r = new Random();
            int s = r.nextInt(i + 1);
            Card temp = cartas[s];
            for (int j = s; j < i; j++) {
                cartas[j] = cartas[j + 1];
            }
            cartas[i] = temp;
        }
        indexAtual = 0;
    }

    public boolean hasNext() {
        return (indexAtual < cartas.length);
    }

    public Card next() {
        return cartas[indexAtual++];
    }
}
