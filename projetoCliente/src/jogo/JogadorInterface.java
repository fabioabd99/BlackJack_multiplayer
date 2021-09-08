package jogo;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface JogadorInterface extends Remote {

    public void desconectado() throws RemoteException;

    public void start(int aposta) throws RemoteException;

    public boolean isMinhaVez() throws RemoteException;

    public void stand() throws RemoteException;

    public void hit() throws RemoteException;

    public String getUsername() throws RemoteException;

    public int getQuantia() throws RemoteException;

    public int getId() throws RemoteException;

    public boolean isStarted() throws RemoteException;

    public MaoInterface getMao(int index) throws RemoteException;

    public ArrayList<MaoInterface> getMaos() throws RemoteException;
}
