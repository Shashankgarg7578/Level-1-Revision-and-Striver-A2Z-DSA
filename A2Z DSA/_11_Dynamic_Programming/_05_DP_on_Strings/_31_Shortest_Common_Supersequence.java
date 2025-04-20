package _11_Dynamic_Programming._05_DP_on_Strings;

public class _31_Shortest_Common_Supersequence {

	// in this Q we have given 2 Strings and we have to make one string which have all char including both string
	// but that from that answer we are able to form both strings in same sequence of char

	// for this question we have to know Q25 Longest Common Subsequence and Q26 print Longest Common Subsequence

	// for example :- str1 = "brute" , str2 = "groot"
	// ans :- "bgruoote" (code can generate in diffrent form)

	public static void main(String args[]) {

		String s1 = "brute";
		String s2 = "groot";

		System.out.println("The Longest Common Supersequence is " + shortestSupersequence(s1, s2));
	}

	private static String shortestSupersequence(String s1, String s2) {

		int n = s1.length();
		int m = s2.length();

		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i <= m; i++) {
			dp[0][i] = 0;
		}

		for (int ind1 = 1; ind1 <= n; ind1++) {
			for (int ind2 = 1; ind2 <= m; ind2++) {
				if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
					dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
				else
					dp[ind1][ind2] = 0 + Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
			}
		}

		// now we have to make dp table and backtrack for ans making

		String ans = "";

		int len = dp[n][m]; // the answer size which came from dp array
		int i = n;
		int j = m;

		int index = len - 1;

		while (i > 0 && j > 0) {

			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
				ans += s1.charAt(i - 1);
				index--;
				i--;
				j--;
			} else if (dp[i - 1][j] > dp[i][j - 1]) {
				ans += s1.charAt(i - 1);
				i--;
			} else {
				ans += s2.charAt(j - 1);
				j--;
			}

		}

		while (i > 0) {
			ans += s1.charAt(i - 1);
			i--;
		}

		while (j > 0) {
			ans += s2.charAt(j - 1);
			j--;
		}

		// reverse the ans for correct ans.
		String ans2 = new StringBuilder(ans).reverse().toString();

		return ans2;
	}
}
