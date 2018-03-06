import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test {
	
	public static void main (String[] args) {
		
		//Given ArrayLists
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
		ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(5, 6, 10, 500, 12, 13, 14));
		System.out.println("ArrayList A: " + A);
		System.out.println("ArrayList B: " + B);
		
		//Union, Intersection, and Set Difference
		System.out.println("\nUnion, Intersection, and Set Difference: ");
		System.out.println("A ∪ B: " + union(A, B));
		A = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
		System.out.println("A ∩ B: " + intersection(A, B));
		System.out.println("A - B: " + setDifference(A, B));
		System.out.println("B - A: " + setDifference(B, A));
		
		//Limit Of Infinite Geometric Series
		System.out.println("\nInfinite Geometric Series: ");
		System.out.println(infGeoLimit(0, 0.5));
		System.out.println(infGeoLimit(1,3));
		
		//L'Hopitals Rule
		System.out.println("\nL'Hopitals Rule: ");
		System.out.println(lHopital(0.001, 4));
		System.out.println(lHopital(0.002, 28));
		
		//Standard Deviation
		System.out.println("\nStandard Deviation (with ArrayLists A and B): ");
		System.out.println(sd(A));
		System.out.println(sd(B));
		
		//Binomial Coefficent
		System.out.println("\nBinomial Coefficent: ");
		System.out.println(bc(4, 2));
		System.out.println(bc(11, 8));

	}
/*
 * UNION
 * A union is a variable that can change object types when its value is changed. For example, a union declared as the 3 can
 * change to 5.0 if it is reassigned, changing from the primitive type of an int to a double
 * 
*/

	public static ArrayList<Integer> union (ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Collections.sort(arr1);
		Collections.sort(arr2);
		arr1.addAll(arr2);
		for (int i = 0; i < arr1.size(); i++) {
			if (!(result.contains(arr1.get(i)))) {
				result.add(arr1.get(i));
			}
		}
		return result;
	}
	
	
/*
 * INTERSECTION
 * An intersection is a the combination of values that the sets in question contain. For example, if one set goes from
 * 0 to 3, and the other set goes from 2 to 6, then the intersection would be 2 to 3, since those are values that both sets
 * have.
 */
	public static ArrayList<Integer> intersection (ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i: arr1) {
			if (arr2.contains(i)) {
				if (!(result.contains(i))) {
					result.add(i);
				}
			}
		}
		Collections.sort(result);
		return result;
	}
	
/*
 * SET DIFFERENCE
 * Everything that is one set but is not in another.
 */
	
	public static ArrayList<Integer> setDifference (ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i: arr1) {
			if (!arr2.contains(i)) {
				if (!(result.contains(i))) {
					result.add(i);
				}
			}
		}
		Collections.sort(result);
		return result;
	}
/*
 * LIMIT
 * The result that an infinite sequence is reaching towards,  but never gets to. It converges if that end result, or limit
 * if a finite value, and diverges if that limit is positive or negative infinity. The method below applied to infinite
 * geometric sequences
*/
	public static String infGeoLimit(int a1, double ratio) {
		String result = "With a = " + a1 + " and ratio = " + ratio + ", the equation ";
		if (Math.abs(ratio) > 1) {
			result += ("diverges (limit of -∞ or +∞)");
		} else if (ratio == 1) {
			result += ("converges to zero");
		} else if (Math.abs(ratio) < 1) {
			result +=("converges to " + a1/(1-ratio));
		}
		return result;
	}

/* L'HOPITAL'S RULE
 * The rule used to divide one function by another, using derivatives. I pre-determined the two functions used as to allow
 * for the rule to be explained.
 */ 
	//pre-determined function of x^2 - 16
	public static double f(double x) {
		return (double)Math.pow(x, 2) - 16;
	}
	
	//pre-determined function of x - 4
	public static double g(double x) {
		return (double)x-4;
	}
	
	public static String lHopital(double x, double a) {
		String result = ("When x = " + x + " and  a = " + a + ", ");
		double t = f(a + x) - f(a);
		double b = g(a + x) - g(a);
		double output = t/b;
		result += ("the result is " + output);
		return result;
	}
/*
 * STANDARD DEVIATION
 * Finds the mean, and uses that to find the variance. Then, you square root the variance, to find the standard deviation
 * The last method acts as a main method and runs the program, while returning the String result to be printed
 */
	
	//finds the mean *assume all positive numbers*
	public static double findMean(ArrayList<Integer> arr) {
		int sum = 0;
		for(int i : arr) { sum += i; }
		return (double)sum/arr.size();
	}

	//finds the variance
	public static double variance(ArrayList<Integer> arr) {
		double m = findMean(arr);
		int length = arr.size();
		int total = 0;
		for(int i : arr) { total += Math.pow(((double)i - m), 2); }
		return (double)total/length;
	}

	//roots the variance
	public static String sd(ArrayList<Integer> arr) {
		return "Given the numbers: " + arr + ", the standard deviation is " + Math.sqrt(variance(arr));
	}
/*
 * BINOMIAL COEFFICCENT
 * Returns the choose function result of two numbers, on pascal's triangle, said as __ choose __ (ex: 4 choose 2).
 * The formula used was n!/(k!)(n-k)!
 * The first method finds the result of a factorial, while the bc or binomial coefficent method uses the factorial method
 * to compute the formula
 */
	//factorial helper method
	public static int factorial(int n) {
		 if (n == 0) return 1;
		 return n * factorial(n - 1);
	}
	
	//binomial coefficent method
	public static String bc(int n, int k) {
		if (k == 0) return "1";
		if (k < 0 || n < 1 || k > n) {
			return ("Error.");
		}
		int integer = factorial(n)/(factorial(k)*(factorial(n-k)));
		return ("With n = " + n + " and k = " + k + ", the binomial coefficient is " + integer);
	}

	
}
