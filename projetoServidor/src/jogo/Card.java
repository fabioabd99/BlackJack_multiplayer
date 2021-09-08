package jogo;

public class Card {

    protected int nipe;
    protected int valor;
    public boolean visivel = true;

    
    public Card(int nipe, int valor) {
        if (nipe >= 0 && nipe <= 3 && valor >= 1 && valor <= 13) {
            this.nipe = nipe;
            this.valor = valor;
        } else {
            System.out.println("Carta invalida");
        }
    }

    public int getPontos() {
        if (valor < 10) {
            return valor;
        } else {
            return 10;
        }
    }

    public int getNipe() {
        return this.nipe;
    }

    public int getValor() {
        return this.valor;
    }

    public boolean isVisivel() {
        return this.visivel;
    }

    public int[] toIntArray() {
        int[] intArray = new int[2];
        if (this.visivel) {
            intArray[0] = this.getNipe();
            intArray[1] = this.getValor();
        } else {
            intArray[0] = -1;
            intArray[1] = -1;
        }
        return intArray;
    }
}
