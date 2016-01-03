package JRMIServidor;
import java.awt.List;
import java.io.File;
import java.io.FileFilter;
import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CopArq extends UnicastRemoteObject implements ICopArq
{
        private HashMap<String, String> lista = new HashMap<String, String>();
    public CopArq() throws RemoteException{}

    @Override
    public File[] lerArquivo() throws RemoteException {
        
        FileFilter filter = new FileFilter() {
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
    public HashMap<String, String> listaNomes(File[] f1, File[] f2, File[] f3) throws RemoteException {
        
        for (int i = 0; i < f1.length; i++) {
            lista.put(f1[i].getName(), f1[i].getAbsoluteFile().toURI().toString());
        }
        for (int i = 0; i < f2.length; i++) {
            lista.put(f2[i].getName(), f2[i].getAbsoluteFile().toURI().toString());
        }
        for (int i = 0; i < f3.length; i++) {
            lista.put(f3[i].getName(), f3[i].getAbsoluteFile().toURI().toString());
        }        
        return lista;
        
    }

}