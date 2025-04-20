package _11_Dynamic_Programming._05_DP_on_Strings;

import java.util.Arrays;

public class _29_Minimum_insertions_to_make_string_palindrome {

	// for Solve this Q we have to know about Q25 and Q28

	// Steps :- 1. first found longest palindromic subsequence
	// 2. subtract Given String length with longest palindromic subsequence String
	// length

	// here we have some example for better understanding.
	// Exmaple :- 1. "abcaa"
//	              longest palindromic subsequence :- aaa
//	              5 - 3 = 2 is min char required to make palindrome

	public static void main(String args[]) {
		String s = "abcaa";
		System.out.println("The Minimum insertions required to make the string palindrome: " + minInsertion(s));
	}

//	Time Complexity: O(N*N)
//	Space Complexity: O(N*N)
	private static int minInsertion(String s) {
		int n = s.length();

		int k = longestPalindromeSubsequence(s);

		return n - k;
	}

	// Q28
//	Time Complexity: O(N*N)
//	Space Complexity: O(N*N)
	private static int longestPalindromeSubsequence(String s) {
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		return lcs04(s, sb.toString());
	}

	// it is from Q25
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

}
