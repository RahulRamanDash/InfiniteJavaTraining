
public class StaticFinal {
	
	int score;
	
	public int calculateScore(int run) {
		if(run==4) {
			score+=run;
		}
		return score;
	}
	public static void main(String[] args) {
		StaticFinal obj = new StaticFinal();
		//obj.calculateScore(4);
		//final int finalScore = score;
		
		System.out.println("After one ball Score is "+obj.calculateScore(4));
		//System.out.println("After The Match Score is "+finalScore);
		
		

	}

}
