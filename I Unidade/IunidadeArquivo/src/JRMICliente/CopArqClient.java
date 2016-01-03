package JRMICliente;
import JRMIServidor.ICopArq;
import java.io.File;
import java.lang.Thread.State;
import java.net.MalformedURLException;
import java.rmi.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CopArqClient {
    private File[] files1;
    private File[] files2;
    private File[] files3;
    private String host1 = "//localhost/Copiar";
    private String host2 = "//localhost/Copiar";
    private String host3 = "//localhost/Copiar";
    private HashMap<String, String> listas = new HashMap<String, String>();
     
    
    public HashMap<String, String> runThreads() {
        try {
            final ICopArq maq1 = (ICopArq) Naming.lookup(host1);
            final ICopArq maq2 = (ICopArq) Naming.lookup(host2);
            final ICopArq maq3 = (ICopArq) Naming.lookup(host3);
             
            
            Thread t1, t2, t3;
            
            t1 = new Thread() {
                @Override
                public void run() {
                    try {
                       files1 = maq1.lerArquivo();
                    } catch (RemoteException ex) {
                        Logger.getLogger(CopArqClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            t1.start();
            
            
            t2 = new Thread() {
                @Override
                public void run() {
                    try {
                        files2 = maq2.lerArquivo();
                    } catch (RemoteException ex) {
                        Logger.getLogger(CopArqClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            t2.start();
            t3 = new Thread() {
                @Override
                public void run() {
                    try {
                        files3 = maq3.lerArquivo();
                    } catch (RemoteException ex) {
                        Logger.getLogger(CopArqClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            t3.start();

            while ((t1.getState() != State.TERMINATED) || (t2.getState() != State.TERMINATED) || (t3.getState() != State.TERMINATED)) {
            }
   
            listas = maq1.listaNomes(files1, files2, files3,host1,host2,host3);            
            

        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            System.out.println("Copiar arquivos exception:" + e);
            
        }
        return listas;        
    }
    public void copiarArquivo(final String arquivo, final String host){
        try {
            final ICopArq maq4 = (ICopArq) Naming.lookup(host);
            Thread t4;
            t4 = new Thread() {
                @Override
                public void run() {
                    try {
                       maq4.copArquivo(arquivo);
                    } catch (RemoteException ex) {
                        Logger.getLogger(CopArqClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            t4.start();
            while ((t4.getState() != State.TERMINATED)) {
            }
            
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(CopArqClient.class.getName()).log(Level.SEVERE, null, ex);
        }
               
    }
}
