package JRMI.Servidor;
import java.rmi.*;

public interface ICopArq extends Remote
{
	public double op1(int inicial) throws RemoteException;

	public double merge(double a, double b, double c, double d) throws RemoteException;
}
