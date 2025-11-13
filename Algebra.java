// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,44));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(-1,-1));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(-5,4));      // 5^3
   		System.out.println(pow(0,0));      // 3^5
   		System.out.println(div(12,4));   // 12 / 3    
   		System.out.println(div(-5,5));    // 5 / 5  
   		System.out.println(div(-25,7));   // 25 / 7
		System.out.println(div(-25,0));
		System.out.println(div(0,7));
		System.out.println(div(2,-7));
		System.out.println(div(-7,-7));
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int first = x1;
		int second = x2;
		if (second >= 0) {
		for (int i = 0; i < second; i++ ){
			first++;
		}
		} else {
			for (int i = 0; i > second; i-- ){
				first--;
			}
		}
		return first;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int first = x1;
		int second = x2;
		if (second >= 0) {
		for (int i = 0; i < second; i++ ){
			first--;
		}
		} else {
			for (int i = 0; i > second; i-- ){
				first++;
			}
		}
		return first;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int first = x1;
		int newNum = x1;
		int second = x2;
		if (first == 0 || second == 0) {
			return 0;
		} else if (first > 0 && second > 0 || first < 0 && second > 0) {
			for (int i = 1; i < second; i++ ){
				newNum = plus(newNum, first);
			}
		} else if (first > 0 && second < 0 || first < 0 && second < 0) {
			for (int i = 1; i > second; i-- ){
				newNum = minus(newNum, first);
			}
		}
		return newNum;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int first = x;
		int newNum = x;
		int second = n;
		if (first == 0) {
			return 0;
		} else if (second == 0) {
			return 1;
		} else {
			for (int i = 1; i < second; i++) {
				newNum = times (newNum, first);
			}
		} 
		return newNum;
		
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int first = x1;
		int newNum = 0;
		int second = x2;
		 int minuser = 0;
		if (first == -second) {
			return -1;
		} else if (first == second) {
			return 1;
		} else if (first > 0 && second > 0) {
			if (first < second) {
				return 0;
			}
			int count = 0;
			for (int i = 1; newNum <= first; i++) {
				count = i;
				newNum = plus (newNum, second);
			}
			if (newNum > first) {
				count--;
			}
			return count;
		} else if (first < 0 && second < 0) {
			first = -first;
			second = -second;
			if (first < second) {
				return 0;
			}
			int count = 0;
			for (int i = 1; newNum <= first; i++) {
				count = i;
				newNum = plus (newNum, second);
			}
			if (newNum > first) {
				count--;
			}
			return count;
		} else if (first < 0 && second > 0 || first > 0 && second < 0) {
			if (first < 0) {
				first = -first;
			} else if (second < 0) {
				second = -second;
			}
			if (first < second) {
				return 0;
			}
			int count = 0;
			for (int i = 1; newNum <= first; i++) {
				count = i;
				newNum = plus (newNum, second);
			}
			if (newNum > first) {
				count--;
			}
			return -count;
		}
		return 0;
        
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int first = x1;
		int second = x2;
		int devision = div (first, second);
		int newNum = times (devision, second);
		if (newNum == first) {
			return 0;
		} else {
			int ret = minus (first, newNum);
			if (ret < 0) {
				ret = -ret;
			}
			return ret;
		}
		
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int num = x;
		if (num < 0) {
			return -1;
		}
		int result = 0;
		int r = 0;
		for (int i = 0; result < num; i++) {
			r = i;
			result = times (r, r);
		}
		if (result > num) {
			return (r-1);
		}
		return r;
	}	  	  
}