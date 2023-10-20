import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calc extends Remote{
	int sum(int x, int y) throws RemoteException;
	int sub(int x, int y) throws RemoteException;
	int mult(int x, int y) throws RemoteException;
}
