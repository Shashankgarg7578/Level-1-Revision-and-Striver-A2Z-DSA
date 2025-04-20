package _11_Dynamic_Programming._05_DP_on_Strings;

import java.util.Arrays;

//substring :-it means order can be contiguous only. it can't be non-contiguous.

public class _27_Longest_Common_Substring {
	public static void main(String args[]) {
		String s1 = "abcjklp";
		String s2 = "acjkp";

		// Call the lcs function and print the result
		System.out.println("The Length of Longest Common Substring is " + lcs(s1, s2));
		System.out.println("The Length of Longest Common Substring is " + lcs02(s1, s2));

	}

	// Tabulation
	// Time Complexity: O(N*M)
	// Space Complexity: O(N*M)
	private static int lcs(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();

		int[][] dp = new int[n + 1][m + 1];

		int ans = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				// If the characters at the current indices are the same, increment the LCS
				// length
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					int val = 1 + dp[i - 1][j - 1];
					dp[i][j] = val;
					ans = Math.max(ans, val);

				} else {
					dp[i][j] = 0;
				}
			}
		}
		return ans;
	}

	// Tabulation with Space Optimization
	// Time Complexity: O(N*M)
	// Space Complexity: O(M)
	private static int lcs02(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();

		int[] prev = new int[m + 1];
		int[] curr = new int[m + 1];

		int ans = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				// If the characters at the current indices are the same, increment the LCS
				// length
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					int val = 1 + prev[j - 1];
					curr[j] = val;
					ans = Math.max(ans, val);

				} else {
					curr[j] = 0;
				}
			}
			prev = curr.clone();
		}
		return ans;
	}
}
