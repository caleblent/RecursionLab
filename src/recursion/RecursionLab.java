package recursion;

/**
 * Template for recursion Lab Remember: NO LOOPING ALLOWED FOR THIS ASSIGNMENT
 * 
 * @author Nathan Gossett
 * @author Caleb Lent
 * @version Fall 2020
 *
 */
public class RecursionLab {
	
	/**
	 * Implement this method for part 1 of the assignment 
	 * Plain recursive calculation of binomial coefficients
	 * 
	 * @param N
	 * @param k
	 * @return The number of ways to choose k items from a set of N items
	 * @throws IllegalArgumentException if k > N or k is negative
	 */
	public static long rec_C(int N, int k) throws IllegalArgumentException {
		// 1. Check to see if k is less than N or negative
		if (k > N)
			throw new IllegalArgumentException("k cannot be greater than N");
		if (k < 0)
			throw new IllegalArgumentException("k cannot be negative");
		
		// 2. Check base case scenario (either N == k OR k == 0)
		if (k == 0)
			return 1;
		if (k == N)
			return 1;
		
		// 3. Then (N, k) = (N - 1, k) + (N - 1, k - 1)
		return rec_C(N-1,k) + rec_C(N-1, k-1);
	}

	/**
	 * Implement this method for part 2 of the assignment 
	 * Recursive method to find decimal equivalent of binary number
	 * 
	 * @param binNumber An String of 0s and 1s representing a binary number
	 * @return The decimal equivalent of input string
	 * @throws IllegalArgumentException if input string is more than 31 bits or if
	 *                                  any 'bit' is something other than a '0' or
	 *                                  '1'
	 */
	public static int binToDec(String binNumber) throws IllegalArgumentException {
		// Now check the rightmost bit of the string
		int length = binNumber.length();
		char lastBit = binNumber.charAt(binNumber.length()-1);
		
		// Check to ensure binNumber is 31 bits or shorter
		if (length >= 32)
			throw new IllegalArgumentException("binary string provided cannot be more than 32 bits");
		
		// If binNumber has a length of 0
		if (length == 0 || binNumber.isBlank() || binNumber.isEmpty() || binNumber == null) 
			throw new IllegalArgumentException("Binary string cannot be empty");
		
		// If binNumber has a length of 1
		if (length == 1) {
			if (lastBit == '0')
				return 0;
			if (lastBit == '1')
				return 1;
		}
		
		// If length > 1 ...
		// If lastBit is 0, return 2 * num
		if (lastBit == '0')
			return 2 * binToDec(binNumber.substring(0, length-1));
		
		// If lastBit is 1, return 2 * num + 1
		if (lastBit == '1')
			return 2 * binToDec(binNumber.substring(0, length-1)) + 1;
		
		// If the lastBit is anything else, then the string does NOT contain
		// strictly 1s and 0s and so throws an exception
		throw new IllegalArgumentException("binary string provided must only be composed of 1s and 0s");
	}



}