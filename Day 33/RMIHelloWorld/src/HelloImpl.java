import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements Hello{
	protected HelloImpl() throws RemoteException {
		super();
	}
	
	@Override
	public String sayHello() throws RemoteException {
		// TODO Auto-generated method stub
		return "Welcome to RMI programming...Infinite...";
	}
	
}
