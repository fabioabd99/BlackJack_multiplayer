package jogo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CallBackInterface extends Remote {

    public void mensagem(String mensagem, GerirInterface session) throws RemoteException;

}
