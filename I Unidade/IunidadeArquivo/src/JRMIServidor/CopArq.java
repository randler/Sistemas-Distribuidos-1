package JRMIServidor;
import java.io.File;
import java.io.FileFilter;
import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.server.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CopArq extends UnicastRemoteObject implements ICopArq
{
        private final HashMap<String, String> lista = new HashMap<>();
    public CopArq() throws RemoteException{}

    @Override
    public File[] lerArquivo() throws RemoteException {
        
        FileFilter filter;
            filter = new FileFilter() {
                @Override
                public boolean accept(File file) {
                    return file.getName().endsWith(".txt");
                }
            };        
        
        File dir = new File("src/files");
        File[] files = dir.listFiles(filter);
        
        return files;
    }

    @Override
    public void addArquivo() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void copArquivo(String caminho) throws RemoteException {
        System.out.println("Copiar arquivo: "+caminho);
    }

    @Override
    public HashMap<String, String> listaNomes(File[] f1, File[] f2, File[] f3, String host1, String host2, String host3) throws RemoteException {
        
        
            for (File f11 : f1) {
                lista.put(f11.getName(), host1);
            }
            for (File f21 : f2) {
                lista.put(f21.getName(), host2);
            }
            for (File f31 : f3) {
                lista.put(f31.getName(), host3);
            }        
        return lista;
        
    }

}