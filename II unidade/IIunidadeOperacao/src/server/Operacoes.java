package server;

import java.rmi.*;
import java.rmi.server.*;

public class Operacoes extends UnicastRemoteObject implements OperacoesRemote
{	
	public Operacoes() throws RemoteException{}

    @Override
    public int verificaOperacao(String op) throws RemoteException {
        int saida = 0, num1 = 0, num2 = 0;
        String operacao = "";
        boolean flag = true;
        
        for (int i = 0; i < op.length(); i++) {
            String temp = String.valueOf(op.charAt(i));
            
            if(isNumber(op.charAt(i))){
                if(flag){                    
                    num1 = Integer.parseInt(temp);
                    flag = false;
                }else{
                    num2 = Integer.parseInt(temp);
                } 
            }else{
                operacao = temp;
            }
        }
        
        System.out.println("num1: "+num1+"  num2: "+num2+"   operacao:"+operacao);
        
        if (operacao.equals("+"))
            saida = Mais(num1, num2);
        else if (operacao.equals("-"))
            saida = Menos(num1, num2);
        else if (operacao.equals("*"))
            saida = Multiplica(num1, num2);
        else if (operacao.equals("/"))
            saida = Divide(num1, num2);
        
        
        return saida;
    }
    
    
    private int Mais(int num1, int num2){
        return num1+num2;
    }
    
    private int Menos(int num1, int num2){        
        return num1-num2;
    }
    
    private int Divide(int num1, int num2){        
        return num1/num2;
    }
    
    private int Multiplica(int num1, int num2){        
        return num1*num2;
    }
       
    
    private boolean isNumber(char var){
    boolean saida= false;
    try{
        String temp = String.valueOf(var);
        Integer.parseInt(temp);
        saida = true;
    }catch(NumberFormatException e){
        saida = false;
    }
    return saida;
    
}
}