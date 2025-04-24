package _11_Dynamic_Programming._05_DP_on_Strings;

import java.util.Arrays;

public class _33_Edit_Distance {

	// In this question we can do 3 things in s1 string which are
//	1. Insert
//	2. delete
//	3. replace

	// we have to do minimum number of operation in s1 string with these 3 things
	// and make s2.

	public static void main(String args[]) {
		String s1 = "horse";
		String s2 = "ros";

		System.out.println("The minimum number of operations required is: " + editDistance(s1, s2));
		System.out.println("The minimum number of operations required is: " + editDistance02(s1, s2));
		System.out.println("The minimum number of operations required is: " + editDistance03(s1, s2));
		System.out.println("The minimum number of operations required is: " + editDistance04(s1, s2));
		System.out.println("The minimum number of operations required is: " + editDistance05(s1, s2));

	}

	// Recursion
	private static int editDistance(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		return editDistanceUtil(s1, s2, n - 1, m - 1);
	}

	private static int editDistanceUtil(String s1, String s2, int i, int j) {

		if (i < 0) {
			// if first string s1 is all gone but we still have s2 left
			return j + 1;
		}
		if (j < 0) {
			// if second string s2 is all gone but we still have s1 left

			return i + 1;
		}

		// If the characters at the current positions match, no edit is needed
		if (s1.charAt(i) == s2.charAt(j)) {
			return 0 + editDistanceUtil(s1, s2, i - 1, j - 1);
		} else {
			// Minimum of three choices:
			// 1. Replace the character in S1 with the character in S2. :- editDistanceUtil(s1, s2, i - 1, j - 1)
			// 2. Delete the character in S1. :- editDistanceUtil(s1, s2, i - 1, j)
			// 3. Insert the character from S2 into S1. :- editDistanceUtil(s1, s2, i, j - 1)

			return 1 + Math.min(editDistanceUtil(s1, s2, i - 1, j - 1),
					Math.min(editDistanceUtil(s1, s2, i - 1, j), editDistanceUtil(s1, s2, i, j - 1)));
		}

	}

	// Memoization01
	private static int editDistance02(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();

		int[][] dp = new int[n][m];
		for (int[] it : dp) {
			Arrays.fill(it, -1);
		}
		return editDistanceUtil02(s1, s2, n - 1, m - 1, dp);
	}

	private static int editDistanceUtil02(String s1, String s2, int i, int j, int[][] dp) {

		if (i < 0) {
			// if first string s1 is all gone but we still have s2 left
			return j + 1;
		}
		if (j < 0) {
			// if second string s2 is all gone but we still have s1 left
			return i + 1;
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		// If the characters at the current positions match, no edit is needed
		if (s1.charAt(i) == s2.charAt(j)) {
			return dp[i][j] = 0 + editDistanceUtil02(s1, s2, i - 1, j - 1, dp);
		} else {
			// Minimum of three choices:
			// 1. Replace the character in S1 with the character in S2. :- editDistanceUtil(s1, s2, i - 1, j - 1)
			// 2. Delete the character in S1. :- editDistanceUtil(s1, s2, i - 1, j)
			// 3. Insert the character from S2 into S1. :- editDistanceUtil(s1, s2, i, j - 1)

			return dp[i][j] = 1 + Math.min(editDistanceUtil02(s1, s2, i - 1, j - 1, dp),
					Math.min(editDistanceUtil02(s1, s2, i - 1, j, dp), editDistanceUtil02(s1, s2, i, j - 1, dp)));
		}

	}

	// Memoization02 :- with 0th index is for - negative calumn for both row and column
	private static int editDistance03(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();

		int[][] dp = new int[n + 1][m + 1];
		for (int[] it : dp) {
			Arrays.fill(it, -1);
		}
		return editDistanceUtil03(s1, s2, n, m, dp);
	}

	private static int editDistanceUtil03(String s1, String s2, int i, int j, int[][] dp) {

		if (i == 0) {
			// if first string s1 is all gone but we still have s2 left
			return j;
		}
		if (j == 0) {
			// if second string s2 is all gone but we still have s1 left
			return i;
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		// If the characters at the current positions match, no edit is needed
		if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
			return dp[i][j] = 0 + editDistanceUtil03(s1, s2, i - 1, j - 1, dp);
		} else {
			// Minimum of three choices:
			// 1. Replace the character in S1 with the character in S2. :- editDistanceUtil(s1, s2, i - 1, j - 1)
			// 2. Delete the character in S1. :- editDistanceUtil(s1, s2, i - 1, j)
			// 3. Insert the character from S2 into S1. :- editDistanceUtil(s1, s2, i, j - 1)

			return dp[i][j] = 1 + Math.min(editDistanceUtil03(s1, s2, i - 1, j - 1, dp),
					Math.min(editDistanceUtil03(s1, s2, i - 1, j, dp), editDistanceUtil03(s1, s2, i, j - 1, dp)));
		}
	}

	// Tabulation Memoization02 :- with 0th index is for - negative column for both row and column
	private static int editDistance04(String s1, String s2) {

		int n = s1.length();
		int m = s2.length();

		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			dp[i][0] = i;
		}

		for (int i = 0; i <= m; i++) {
			dp[0][i] = i;
		}

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= m; j++) {
				// If the characters at the current positions match, no edit is needed
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 0 + dp[i - 1][j - 1];
				} else {
					// Minimum of three choices:
					// 1. Replace the character in S1 with the character in S2. :- editDistanceUtil(s1, s2, i - 1, j - 1)
					// 2. Delete the character in S1. :- editDistanceUtil(s1, s2, i - 1, j)
					// 3. Insert the character from S2 into S1. :- editDistanceUtil(s1, s2, i, j - 1)

					dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
				}

			}
		}

		return dp[n][m];
	}

	//dont use this one this is not correct for some cases
	// Tabulation Space Optimization Memoization02 :- with 0th index is for - negative column for both row and column
	private static int editDistance05(String s1, String s2) {

		int n = s1.length();
		int m = s2.length();

		int[] prev = new int[m + 1];
		int[] curr = new int[m + 1];
		
		for (int j = 0; j <= m; j++) {
			prev[j] = j;
		}

		for (int i = 1; i <= n; i++) {
			curr[0] = i; // it is for because every-time curr 0th index is equal to i.
			for (int j = 1; j <= m; j++) {
				// If the characters at the current positions match, no edit is needed
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					curr[j] = 0 + prev[j - 1];
				} else {
					// Minimum of three choices:
					// 1. Replace the character in S1 with the character in S2. :- editDistanceUtil(s1, s2, i - 1, j - 1)
					// 2. Delete the character in S1. :- editDistanceUtil(s1, s2, i - 1, j)
					// 3. Insert the character from S2 into S1. :- editDistanceUtil(s1, s2, i, j - 1)

					curr[j] = 1 + Math.min(prev[j - 1], Math.min(prev[j], curr[j - 1]));
				}
			}
			 // Update prev array to store the current values
            prev = curr.clone();
		}

		return curr[m];
	}

}
