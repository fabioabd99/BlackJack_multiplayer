package jogo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CallBack extends UnicastRemoteObject implements CallBackInterface {

    private MainFrame mainFrame;

    public CallBack() throws RemoteException {
        super();
    }

    public void setMainFrame(MainFrame frame) {
        this.mainFrame = frame;
    }

    @Override
    public void mensagem(String mensagem, GerirInterface session) throws RemoteException {
        System.out.println(mensagem);
        mainFrame.refresh(session, mensagem);

    }
}
