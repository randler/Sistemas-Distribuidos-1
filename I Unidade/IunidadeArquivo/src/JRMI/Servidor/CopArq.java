package JRMI.Servidor;
import JRMI.Servidor.ICopArq;
import java.rmi.*;
import java.rmi.server.*;

public class CopArq extends UnicastRemoteObject implements ICopArq
{                      
	 
        
	public CopArq() throws RemoteException{}
	public double op1(int inicial ) throws RemoteException
	{
            int fim = inicial+125000;
            double saida=0;
            double potencia;
           
            
            for (int i = inicial; i <= fim; i++) {               
                potencia =Math.pow(-1, i);
                saida+= potencia * 4/(1+(2*i));                
            }
//            
//            int size=a.length;
//            int li=0;//limite inferior
//            int ls=(int)Math.abs(size*0.25);
//            for(int i=li;i<ls;i++)
//            {
//                a[i]=(int)Math.abs(Math.random()*valor_random);
//                a[i]*=5;
//            }

            
            return saida;
	}
        
    @Override
    public double merge(double a, double b, double c, double d) throws RemoteException {    
        return a+b+c+d;
    }
}