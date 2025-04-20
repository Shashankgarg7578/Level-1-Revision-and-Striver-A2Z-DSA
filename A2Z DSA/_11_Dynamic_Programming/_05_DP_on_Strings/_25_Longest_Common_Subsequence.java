package _11_Dynamic_Programming._05_DP_on_Strings;

import java.util.Arrays;
//subsequence :-it means order can be contiguous or non-contiguous but maintain the order
//subsequence of "abc":- ["", a, b, c, ab, bc, ac, abc] 

//we have 2 Strings and we have to find longest 'same' subsequence.

public class _25_Longest_Common_Subsequence {

	public static void main(String args[]) {
		String s1 = "acd"; // "", a, c, d, ac, ad, cd, acd
		String s2 = "ced"; // "", c, e, d, ce, cd, ed, ced
							// ans :- cd

		// Call the lcs function and print the result
		System.out.println("The Length of Longest Common Subsequence is " + lcs01(s1, s2));
		System.out.println("The Length of Longest Common Subsequence is " + lcs02(s1, s2));
		System.out.println("The Length of Longest Common Subsequence is " + lcs03(s1, s2));
		System.out.println("The Length of Longest Common Subsequence is " + lcs04(s1, s2));
		System.out.println("The Length of Longest Common Subsequence is " + lcs05(s1, s2));

	}

	// recursion
	private static int lcs01(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();

		return lcsUtils01(s1, s2, n - 1, m - 1);
	}

	private static int lcsUtils01(String s1, String s2, int ind1, int ind2) {

		if (ind1 < 0 || ind2 < 0) {
			return 0;
		}

		if (s1.charAt(ind1) == s2.charAt(ind2)) {
			return 1 + lcsUtils01(s1, s2, ind1 - 1, ind2 - 1);
		}

		return Math.max(lcsUtils01(s1, s2, ind1, ind2 - 1), lcsUtils01(s1, s2, ind1 - 1, ind2));
	}

	// Memoiztion01 it is from 0th index
//	Time Complexity: O(N*M)
	// Space Complexity: O(N*M) + O(N+M)
	private static int lcs02(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();

		int[][] dp = new int[n][m];

		for (int[] it : dp) {
			Arrays.fill(it, -1);
		}

		return lcsUtils02(s1, s2, n - 1, m - 1, dp);
	}

	private static int lcsUtils02(String s1, String s2, int ind1, int ind2, int[][] dp) {

		if (ind1 < 0 || ind2 < 0) {
			return 0;
		}

		if (dp[ind1][ind2] != -1) {
			return dp[ind1][ind2];
		}

		if (s1.charAt(ind1) == s2.charAt(ind2)) {
			return 1 + lcsUtils02(s1, s2, ind1 - 1, ind2 - 1, dp);
		}

		return dp[ind1][ind2] = Math.max(lcsUtils02(s1, s2, ind1, ind2 - 1, dp),
				lcsUtils02(s1, s2, ind1 - 1, ind2, dp));
	}

	// Memoiztion02 it is from - negative index so we shift index to right means now
	// 0th index is for negative value and 1st index is for 0th index

//	Time Complexity: O(N*M)
	// Space Complexity: O(N*M) + O(N+M)
	private static int lcs03(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();

		int[][] dp = new int[n + 1][m + 1];

		for (int[] it : dp) {
			Arrays.fill(it, -1);
		}

		return lcsUtils03(s1, s2, n - 1, m - 1, dp);
	}

	private static int lcsUtils03(String s1, String s2, int ind1, int ind2, int[][] dp) {

		if (ind1 == 0 || ind2 == 0) {
			return 0;
		}

		if (dp[ind1][ind2] != -1) {
			return dp[ind1][ind2];
		}

		if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
			return 1 + lcsUtils02(s1, s2, ind1 - 1, ind2 - 1, dp);
		}

		return dp[ind1][ind2] = Math.max(lcsUtils03(s1, s2, ind1, ind2 - 1, dp),
				lcsUtils03(s1, s2, ind1 - 1, ind2, dp));
	}

	// Tabulation :- it is based on Memoization02
//	Time Complexity: O(N*M)
	// Space Complexity: O(N*M)
	private static int lcs04(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();

		int[][] dp = new int[n + 1][m + 1];

		// Initialize the dp array with -1 to indicate that subproblems are not solved
		// yet
		for (int[] it : dp) {
			Arrays.fill(it, -1);
		}

		// Initialize the first row and first column with zeros since LCS with an empty
		// string is zero
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 0;
		}

		for (int i = 0; i <= m; i++) {
			dp[0][i] = 0;
		}

		for (int ind1 = 1; ind1 <= n; ind1++) {
			for (int ind2 = 1; ind2 <= m; ind2++) {
				// If the characters at the current indices are the same, increment the LCS
				// length
				if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
					dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];

					// If the characters are different, choose the maximum LCS length by either
					// excluding a character in s1 or excluding a character in s2

				} else {
					dp[ind1][ind2] = Math.max(dp[ind1][ind2 - 1], dp[ind1 - 1][ind2]);
				}
			}
		}

		return dp[n][m];
	}

	// Tabulation Space Optimization:- it is based on Memoization02
//	Time Complexity: O(N*M)
	// Space Complexity: O(N)
	private static int lcs05(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();

		int[] prev = new int[m + 1];
		int[] curr = new int[m + 1];

		for (int ind1 = 1; ind1 <= n; ind1++) {
			for (int ind2 = 1; ind2 <= m; ind2++) {
				// If the characters at the current indices are the same, increment the LCS
				// length
				if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
					curr[ind2] = 1 + prev[ind2 - 1];

					// If the characters are different, choose the maximum LCS length by either
					// excluding a character in s1 or excluding a character in s2

				} else {
					curr[ind2] = Math.max(curr[ind2 - 1], prev[ind2]);
				}
			}
			prev = (int[]) curr.clone();
		}

		return prev[m];
	}

}
