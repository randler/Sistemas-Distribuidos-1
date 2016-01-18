package JRMIServidor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.*;
import java.rmi.server.*;
import java.util.HashMap;

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
    public String addArquivo(String caminho) throws RemoteException {
   String linha="",texto="";
        try
		{
			BufferedReader in = new BufferedReader(new FileReader(caminho));
			try
			{				
				while(linha!=null)
				{
					linha = in.readLine();
					if(linha!=null)
						texto=texto+linha;
				}
				in.close();
			}
			catch( IOException e )
			{
				System.err.println(e);
				System.exit(1);
			}
		}
		catch(FileNotFoundException e)
		{
			texto = "Arquivo não encontrado";
		}
        return texto;
    }

    @Override
    public String copArquivo(String caminho) throws RemoteException {
        String linha="",texto="";
        try
		{
			BufferedReader in = new BufferedReader(new FileReader("src/files/"+caminho));
			try
			{				
				while(linha!=null)
				{
					linha = in.readLine();
					if(linha!=null)
						texto=texto+linha;
				}
				in.close();
			}
			catch( IOException e )
			{
				System.err.println(e);
				System.exit(1);
			}
		}
		catch(FileNotFoundException e)
		{
			texto = "Arquivo não encontrado";
		}
        return texto;
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