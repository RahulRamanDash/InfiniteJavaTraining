import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Server {
	public static void main(String[] args) {
		Hello obj;
		try {
			obj = new HelloImpl();
			Naming.rebind("localhost", obj);
			System.out.println("Server is Running...");
			System.out.println("Waiting For Clients");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}
}
