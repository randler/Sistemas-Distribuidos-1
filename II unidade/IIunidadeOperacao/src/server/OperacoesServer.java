package server;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class OperacoesServer {



    public void rodaServidor() {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            Naming.bind("Operacoes", new Operacoes());
            System.out.println("O servidor esta rodando");   

        } catch (Exception e) {
            System.out.println("Problemas! Não foi possível inicializar o servidor!");
            e.printStackTrace();
        }
    }
    
}
