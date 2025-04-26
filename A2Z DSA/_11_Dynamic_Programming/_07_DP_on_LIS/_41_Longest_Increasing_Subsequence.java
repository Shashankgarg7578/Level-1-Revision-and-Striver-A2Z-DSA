package _11_Dynamic_Programming._07_DP_on_LIS;

import java.util.Arrays;

public class _41_Longest_Increasing_Subsequence {
	public static void main(String args[]) {

		// In this we have to get the longest subsequence which not have duplicate
		// In below example :- {2, 3 , 7, 101} OR {2, 3 , 7, 18}

		// Note :- {8,8,8} in this question ans is 1 because we have all same

		int arr[] = { 10, 9, 2, 5, 3, 7, 101, 18 };

		int n = arr.length;

		System.out
				.println("The length of the longest increasing subsequence is " + longestIncreasingSubsequence(arr, n));
		System.out.println(
				"The length of the longest increasing subsequence is " + longestIncreasingSubsequence02(arr, n));

		System.out.println(
				"The length of the longest increasing subsequence is " + longestIncreasingSubsequence03(arr, n));

		System.out.println(
				"The length of the longest increasing subsequence is " + longestIncreasingSubsequence04(arr, n));

	}

	// Recursion
	private static int longestIncreasingSubsequence(int[] arr, int n) {

		return lisUtils01(0, -1, arr, n);
	}

	private static int lisUtils01(int ind, int prevInd, int[] arr, int n) {

		if (ind == n) {
			return 0;
		}

		// not-take
		int len = 0 + lisUtils01(ind + 1, prevInd, arr, n);

		// take
		if (prevInd == -1 || arr[ind] > arr[prevInd]) {
			len = Math.max(len, 1 + lisUtils01(ind + 1, ind, arr, n));
		}

		return len;
	}

	// Memoization
	private static int longestIncreasingSubsequence02(int[] arr, int n) {

		int[][] dp = new int[n][n + 1];

		for (int[] it : dp) {
			Arrays.fill(it, -1);
		}

		return lisUtils02(0, -1, arr, n, dp);
	}

	private static int lisUtils02(int ind, int prevInd, int[] arr, int n, int[][] dp) {

		if (ind == n) {
			return 0;
		}

		if (dp[ind][prevInd + 1] != -1) {
			return dp[ind][prevInd + 1];
		}

		// not-take
		int len = 0 + lisUtils02(ind + 1, prevInd, arr, n, dp);

		// take
		if (prevInd == -1 || arr[ind] > arr[prevInd]) {
			len = Math.max(len, 1 + lisUtils02(ind + 1, ind, arr, n, dp));
		}

		return dp[ind][prevInd + 1] = len;
	}

	// Tabulation
	private static int longestIncreasingSubsequence03(int[] arr, int n) {

		int[][] dp = new int[n + 1][n + 1];

		for (int ind = n - 1; ind >= 0; ind--) {
			for (int prevInd = ind - 1; prevInd >= -1; prevInd--) {

				// Not take
				int len = 0 + dp[ind + 1][prevInd + 1];

				// take
				if (prevInd == -1 || arr[ind] > arr[prevInd]) {
					len = Math.max(len, 1 + dp[ind + 1][ind + 1]);
				}

				dp[ind][prevInd + 1] = len;
			}

		}

		return dp[0][0];
	}

	// Tabulation Space Optimization
	private static int longestIncreasingSubsequence04(int[] arr, int n) {

		int[] after = new int[n + 1];
		int[] curr = new int[n + 1];

		for (int ind = n - 1; ind >= 0; ind--) {
			for (int prevInd = ind - 1; prevInd >= -1; prevInd--) {

				// Not take
				int len = 0 + after[prevInd + 1];

				// take
				if (prevInd == -1 || arr[ind] > arr[prevInd]) {
					len = Math.max(len, 1 + after[ind + 1]);
				}

				curr[prevInd + 1] = len;
			}
			after = curr;
		}

		return curr[0];
	}
}
