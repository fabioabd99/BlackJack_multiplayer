package jogo;

import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

public interface GerirListener {

    public void jogadorDesconectado(ActionEvent e);

    public void jogadorComecouJogo(ActionEvent e) throws RemoteException;

}
