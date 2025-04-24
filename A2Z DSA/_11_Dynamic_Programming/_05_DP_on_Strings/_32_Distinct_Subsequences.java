package _11_Dynamic_Programming._05_DP_on_Strings;

import java.util.Arrays;

public class _32_Distinct_Subsequences {
	public static void main(String args[]) {

		// this is little different from previous problem.
        //here we have to find out how many times s2 will occour in s1
		String s1 = "babgbag";
		String s2 = "bag";

		System.out.println(
				"The Count of Distinct Subsequences is " + subsequenceCounting01(s1, s2, s1.length(), s2.length()));
		System.out.println(
				"The Count of Distinct Subsequences is " + subsequenceCounting02(s1, s2, s1.length(), s2.length()));
		System.out.println(
				"The Count of Distinct Subsequences is " + subsequenceCounting03(s1, s2, s1.length(), s2.length()));
		System.out.println(
				"The Count of Distinct Subsequences is " + subsequenceCounting04(s1, s2, s1.length(), s2.length()));
		System.out.println(
				"The Count of Distinct Subsequences is " + subsequenceCounting05(s1, s2, s1.length(), s2.length()));
		System.out.println(
				"The Count of Distinct Subsequences is " + subsequenceCounting06(s1, s2, s1.length(), s2.length()));

	}

	// recursion
	private static int subsequenceCounting01(String s1, String s2, int s1Length, int s2Length) {
		return subsequenceCountingUtils01(s1, s2, s1Length - 1, s2Length - 1);
	}

	private static int subsequenceCountingUtils01(String s1, String s2, int ind1, int ind2) {

		// If we have exhausted s2, there's one valid subsequence (empty string) in s1.
		if (ind2 < 0) {
			return 1;
		}

		// If we have exhausted s1 but not s2, there are no valid subsequences.
		if (ind1 < 0) {
			return 0;
		}

		// If the characters at the current positions match, we can either leave one
		// character from s1
		// or continue to the next character in s1 while staying at the same character
		// in s2.
		if (s1.charAt(ind1) == s2.charAt(ind2)) {
			return subsequenceCountingUtils01(s1, s2, ind1 - 1, ind2 - 1)
					+ subsequenceCountingUtils01(s1, s2, ind1 - 1, ind2);
		} else {
			// If the characters don't match, we can only continue to the next character in
			// s1.
			return subsequenceCountingUtils01(s1, s2, ind1 - 1, ind2);
		}
	}

	// Memoization 01 without negative handle in dp array
	private static int subsequenceCounting02(String s1, String s2, int s1Length, int s2Length) {

		int[][] dp = new int[s1Length][s2Length];

		for (int[] it : dp) {
			Arrays.fill(it, -1);
		}

		return subsequenceCountingUtils02(s1, s2, s1Length - 1, s2Length - 1, dp);
	}

	private static int subsequenceCountingUtils02(String s1, String s2, int ind1, int ind2, int[][] dp) {

		// If we have exhausted s2, there's one valid subsequence (empty string) in s1.
		if (ind2 < 0) {
			return 1;
		}

		// If we have exhausted s1 but not s2, there are no valid subsequences.
		if (ind1 < 0) {
			return 0;
		}

		if (dp[ind1][ind2] != -1) {
			return dp[ind1][ind2];
		}

		// If the characters at the current positions match, we can either leave one
		// character from s1
		// or continue to the next character in s1 while staying at the same character
		// in s2.
		if (s1.charAt(ind1) == s2.charAt(ind2)) {
			return dp[ind1][ind2] = subsequenceCountingUtils02(s1, s2, ind1 - 1, ind2 - 1, dp)
					+ subsequenceCountingUtils02(s1, s2, ind1 - 1, ind2, dp);
		} else {
			// If the characters don't match, we can only continue to the next character in
			// s1.
			return dp[ind1][ind2] = subsequenceCountingUtils02(s1, s2, ind1 - 1, ind2, dp);
		}
	}

	// Memoization02 without negative handle in dp array
	private static int subsequenceCounting03(String s1, String s2, int s1Length, int s2Length) {

		// when we cover - negative case as well we will put that case in to the 0th
		// index
//		thats why we will make +1 
		int[][] dp = new int[s1Length + 1][s2Length + 1];

		for (int[] it : dp) {
			Arrays.fill(it, -1);
		}

		return subsequenceCountingUtils03(s1, s2, s1Length, s2Length, dp);
	}

	private static int subsequenceCountingUtils03(String s1, String s2, int ind1, int ind2, int[][] dp) {

		// If we have exhausted s2, there's one valid subsequence (empty string) in s1.
		if (ind2 == 0) {
			return 1;
		}

		// If we have exhausted s1 but not s2, there are no valid subsequences.
		if (ind1 == 0) {
			return 0;
		}

		if (dp[ind1][ind2] != -1) {
			return dp[ind1][ind2];
		}

		// If the characters at the current positions match, we can either leave one
		// character from s1
		// or continue to the next character in s1 while staying at the same character
		// in s2.
		if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
			return dp[ind1][ind2] = subsequenceCountingUtils03(s1, s2, ind1 - 1, ind2 - 1, dp)
					+ subsequenceCountingUtils03(s1, s2, ind1 - 1, ind2, dp);
		} else {
			// If the characters don't match, we can only continue to the next character in
			// s1.
			return dp[ind1][ind2] = subsequenceCountingUtils03(s1, s2, ind1 - 1, ind2, dp);
		}
	}

	// Tabulation  by Memoization02
	private static int subsequenceCounting04(String s1, String s2, int s1Length, int s2Length) {

		// when we cover - negative case as well we will put that case in to the 0th
		// index thats why we will make +1
		int[][] dp = new int[s1Length + 1][s2Length + 1];

		for (int i = 0; i < s1Length + 1; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i < s1Length + 1; i++) {
			for (int j = 1; j < s2Length + 1; j++) {
				// If the characters at the current positions match, we can either leave one
				// character from s1
				// or continue to the next character in s1 while staying at the same character
				// in s2.
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				} else {
					// If the characters don't match, we can only continue to the next character in
					// s1.
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[s1Length][s2Length];
	}

	// Tabulation by Memoization02- Space Optimization
	private static int subsequenceCounting05(String s1, String s2, int s1Length, int s2Length) {

		// when we cover - negative case as well we will put that case in to the 0th
		// index thats why we will make +1
		int[] prev = new int[s2Length + 1];
		int[] curr = new int[s2Length + 1];

		prev[0] = 1;
		curr[0] = 1;

		for (int i = 1; i <= s1Length ; i++) {
			for (int j = 1; j <= s2Length; j++) {
				// If the characters at the current positions match, we can either leave one
				// character from s1
				// or continue to the next character in s1 while staying at the same character
				// in s2.
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					curr[j] = prev[j - 1] + prev[j];
				} else {
					// If the characters don't match, we can only continue to the next character in
					// s1.
					curr[j] = prev[j];
				}
			}
			//it make new copy and assign to prev
			prev = curr.clone();
		}

		return prev[s2Length];
	}
	
	// Tabulation  by Memoization02 - More Space Optimization
	private static int subsequenceCounting06(String s1, String s2, int s1Length, int s2Length) {

		// when we cover - negative case as well we will put that case in to the 0th
		// index thats why we will make +1
		int[] prev = new int[s2Length + 1];

		prev[0] = 1;

		for (int i = 1; i <= s1Length ; i++) {
			for (int j = s2Length; j >= 1; j--) {
				// If the characters at the current positions match, we can either leave one
				// character from s1
				// or continue to the next character in s1 while staying at the same character
				// in s2.
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					prev[j] = (prev[j - 1] + prev[j]);
				} else {
					// If the characters don't match, we can only continue to the next character in
					// s1.
					prev[j] = prev[j];
				}
			}
		}

		return prev[s2Length];
	}

}
