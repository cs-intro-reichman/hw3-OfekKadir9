/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I yj a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Raddgffdfd came")); // true
		System.out.println(isAnagram("","")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String newString1 = preProcess(str1);
		String newString2 = preProcess(str2);
		String exString2 = "";
		if (newString1.length() == newString2.length()) {
			
			char s1 ='r';
			char s2 ='l';
			String newString222 = preProcess(str2);
			for (int i = 0; i < newString1.length(); i++) {
				if (newString1.equals (newString2)){
					return true;
				}
				s1 = newString1.charAt(i);
				exString2 = "";
				int count = 0;
				for (int f = 0; f < newString222.length(); f++) {
					s2 = newString222.charAt(f);
					if (s1 == s2) {
						count++;
					} else if (s1 != s2 || count > 0) {
						exString2 = exString2 + s2;
					} 
				}
				newString222 = exString2;
			}
			if (newString222.equals ("")){
				return true;
			}
		}
		
		return false;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String newOne = "";
		char s = 's';
		for (int i = 0; i < str. length(); i++ ){
			if (str.charAt (i) > 64 && str.charAt (i) < 91 || str.charAt (i) > 96 && str.charAt (i) < 123) {
				s = str.charAt (i);
				if (s >= 65 && s <= 90) {
					s = (char) (s + 32);
				}
				newOne = newOne + s; 
			}
		}
		return newOne;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String newString = "";
		String redString = str;
		int count = 0;
		while (count < str.length()) {
			char ch = redString.charAt ((int) (Math.random() * (redString.length() - 1)));
			if (redString.indexOf(ch) == 0) {
				redString = redString.substring(1);
			} else if (redString.indexOf(ch) == redString.length()-1){
				redString = redString.substring(0,redString.indexOf(ch));
			} else {
				redString = redString.substring(0,redString.indexOf(ch)) + redString.substring(redString.indexOf(ch) + 1);
			}
			newString = newString + ch;
			count++;
			
		}
		return newString;
	}
}
