package _11_Dynamic_Programming._05_DP_on_Strings;

//this question is dependent on previous question 
//as in previous Q we are finding the length here we have to give that subsequence string
public class _26_Print_Longest_Common_Subsequence {

	public static void main(String args[]) {
		String s1 = "abcde";
		String s2 = "bdgek";

		System.out.print("The Longest Common Subsequence is ");
		lcs(s1, s2);
	}

//	Time Complexity: O(N*M)
//	Space Complexity: O(N*M)
	private static void lcs(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();

		int dp[][] = new int[n + 1][m + 1];
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

		int len = dp[n][m];
		int i = n;
		int j = m;

		int index = len - 1;
		String str = "";
		for (int k = 1; k <= len; k++) {
			str += "$";
		}

		// for s1 string which given in Question
		StringBuilder ss = new StringBuilder(s1);

		// this is for ans
		StringBuilder strSb = new StringBuilder(str);

		while (i > 0 && j > 0) {
			if (ss.charAt(i - 1) == s2.charAt(j - 1)) {
				strSb.setCharAt(index, ss.charAt(i - 1));
				index--;
				i--;
				j--;
			} else if (ss.charAt(i - 1) > s2.charAt(j - 1)) {
				i--;
			} else {
				j--;
			}
		}

		System.out.println(strSb.toString());
	}

}
