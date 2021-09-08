package jogo;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface MaoInterface extends Remote {
	
	public int getPontos() throws RemoteException;

	public ArrayList<int[]> getCardsIntArray() throws RemoteException;
	
	public int getAposta() throws RemoteException;
        
        public int getValor() throws RemoteException; 
	
}
