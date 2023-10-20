import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalcImpl extends UnicastRemoteObject implements Calc{
	protected CalcImpl() throws RemoteException {
		super();
	}

	@Override
	public int sum(int x, int y) throws RemoteException {
		return x+y;
	}

	@Override
	public int sub(int x, int y) throws RemoteException {
		return x-y;
	}

	@Override
	public int mult(int x, int y) throws RemoteException {
		return x*y;
	}
	
	

	
}
