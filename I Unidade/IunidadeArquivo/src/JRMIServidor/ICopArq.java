package JRMIServidor;
import java.io.File;
import java.rmi.*;
import java.util.HashMap;

public interface ICopArq extends Remote
{
	public File[] lerArquivo() throws RemoteException;
	public void addArquivo() throws RemoteException;
        public void copArquivo(String caminho) throws RemoteException;
        public HashMap<String, String> listaNomes(File[] f1, File[] f2, File[] f3, String host1, String host2, String host3) throws RemoteException;
        
}
