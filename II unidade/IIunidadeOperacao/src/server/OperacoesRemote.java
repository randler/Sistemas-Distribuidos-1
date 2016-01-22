package server;


import java.rmi.*;

public interface OperacoesRemote extends Remote
{
	public int verificaOperacao(String op) throws RemoteException;

}
