package jogo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GerirInterface extends Remote {

    public JogadorInterface login(CallBackInterface callback, String name) throws RemoteException;

    public String[] getNomes() throws RemoteException;

    public int[] getQuantias() throws RemoteException;

    public JogadorInterface[] getJogadores() throws RemoteException;

    public JogadorInterface getDealer() throws RemoteException;

}
