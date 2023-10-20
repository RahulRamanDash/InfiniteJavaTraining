package com.java.regex;

import java.util.regex.Pattern;

public class RegEx1 {

	public static void main(String[] args) {

		System.out.println("1. " +Pattern.matches("..h", "mgh"));

		System.out.println("2. "+Pattern.matches("..f..i..", "infinite"));

		

		System.out.println("3. "+Pattern.matches("[aeiou]" , "a"));

		System.out.println("4. "+Pattern.matches("[aeiou]" , "b"));

		

		System.out.println("5. "+Pattern.matches("[^aeiou]" , "a"));//^ symbol acts as negation

		System.out.println("6. "+Pattern.matches("[^aeiou]" , "b"));

		

		System.out.println("7. "+Pattern.matches("[abcd]", "aabbccdd"));

		System.out.println("8. "+Pattern.matches("[abcd]+", "aabbccdd"));

		System.out.println("9. "+Pattern.matches("[abcd]+", "xyz"));

		

		System.out.println("10. "+Pattern.matches("[a-zA-Z]", "Hello"));

		System.out.println("11. "+Pattern.matches("[a-zA-Z]+", "Prasanna"));

		System.out.println("12. "+Pattern.matches("[a-zA-Z]", "xyz123"));

		//

		System.out.println("13. "+Pattern.matches("[0-9]", "1234567"));

		System.out.println("14. "+Pattern.matches("[0-9]{10}", "1234567"));

		System.out.println("15. "+Pattern.matches("[0-9]{10}", "1234567890"));

		System.out.println("16. "+Pattern.matches("[0-9]{10}", "ABC1234567"));

 

		//validate aadhar no

		System.out.println("17. "+Pattern.matches("[0-9]{4}\\s[0-9]{4}\\s[0-9]{4}", "1234 1234 1234"));

		System.out.println("18. "+Pattern.matches("[0-9]{4}\\s[0-9]{4}\\s[0-9]{4}", "1234-1234-1234"));

		System.out.println("19. "+Pattern.matches("[0-9]{4}\\S[0-9]{4}\\S[0-9]{4}", "1234-1234-1234"));

		System.out.println("20. "+Pattern.matches("[0-9]{4}\\s[0-9]{4}\\s[0-9]{4}", "123412341234"));

 

		//validate mobile no.

		System.out.println("21. "+Pattern.matches("[+][9][1]-[0-9]{10}", "+91-7894245680"));

		

		System.out.println("22. "+Pattern.matches("\\d{5}", "12345"));

		System.out.println("23. "+Pattern.matches("\\D+", "12345"));

		System.out.println("24. "+Pattern.matches("\\D+", "ansal@49#$&"));

		

		

		System.out.println("25. "+Pattern.matches("\\S+", "Good Morng"));

		System.out.println("26. "+Pattern.matches("\\S+", "Good-Morng"));

		System.out.println("27. "+Pattern.matches("\\S+", "GoodMorng"));

		

		

		

		String regex = "^(?=.*[0-9])"

                    + "(?=.*[a-z])(?=.*[A-Z])"

                    + "(?=.*[@#$%^&+=])"

                    + "(?=\\S+$).{8,20}";

		

		

		

		System.out.println("28. "+Pattern.matches(regex, "ansaLp49@gmail.com") );
	}

}