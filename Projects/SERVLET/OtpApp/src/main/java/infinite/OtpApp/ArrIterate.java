package infinite.OtpApp;

import java.util.*;

public class ArrIterate {

	public static void main(String[] args) {
		List arr = new ArrayList();
		arr.add("rahul");
		arr.add("Ayush");
		arr.add("Ganesh");
		
		System.out.println(arr.size());
		for (int i=0; i< arr.size();i++) {
			System.out.println(arr.get(i));
		}
		

	}

}
