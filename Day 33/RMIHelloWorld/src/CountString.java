import java.util.List;

public class CountString {

	public static void main(String[] args) {
		String name = "Rahul Raman Dash";
		int count=0;
		List<Integer> list;
		for(int i=0;i<name.length()-1;i++) {
			if(name.charAt(i)=='a') {
				count+=1;
				System.out.println("a is at Index : "+i);
			}
		}
		System.out.println("No of 'a' in Name is:   "+count);
	}

}