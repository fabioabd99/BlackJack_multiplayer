package jogo;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {

    public static void main(String[] args) throws RemoteException {

        GerirInterface gerir = Gerir.getGerir();
        Registry reg = LocateRegistry.createRegistry(1099);
        reg.rebind("blackjack", gerir);
        System.out.println("Server start!");

    }
}
