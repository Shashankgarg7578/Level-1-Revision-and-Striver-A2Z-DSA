package _11_Dynamic_Programming._05_DP_on_Strings;

import java.util.Arrays;

public class _30_Minimum_Insertions_Deletions_to_Convert_String {

//	here we have to given 2 strings we have to do below opeation on Str1 and make str2:-
//	1.Delete any number of characters from string str1.
//	2.Insert any number of characters in string str1.

	// str1 = "abcd" , str2 = "anc"

//	we have to do 2 deletion and 1 insertion in str1

	// str1 = "abcd" --> delete bc = "ac" --> add n = "anc" --> "anc"

	// Note :- we can make any str1 to str2 becuase we can delete all elements of
	// str1 and insert all elements of str2 in str1
	public static void main(String args[]) {
		String str1 = "abcd";
		String str2 = "anc";
		System.out.println("The Minimum operations required to convert str1 to str2: " + canYouMake(str1, str2));
	}

//	Time Complexity: O(N*M)
//	Space Complexity: O(N*M)
	private static int canYouMake(String str1, String str2) {

		int n = str1.length();
		int m = str2.length();

		int k = lcs04(str1, str2);

		return (n - k) + (m - k);
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
