import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

	public static void main(String[] args) {
		Calc calc;
		try {
			calc = (Calc) Naming.lookup("localhost");
			System.out.println("Client Progam is Running...");
			System.out.println("Sum is "+calc.sum(10, 5));
			System.out.println("Sub is "+calc.sub(10, 5));
			System.out.println("Mult is "+calc.mult(10, 5));
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		

	}

}
