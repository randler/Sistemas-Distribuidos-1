package JRMIServidor;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CopArqServer{
	public static void main(String args[])
	{
		try{
                        Registry registry = LocateRegistry.createRegistry(1099); 
			Naming.bind("Copiar", new CopArq());
			System.out.println("O servidor esta rodando");
		}
		catch(Exception e){
			System.out.println("Problemas! Não foi possível inicializar o servidor!");
			e.printStackTrace();
		}
	}
}

