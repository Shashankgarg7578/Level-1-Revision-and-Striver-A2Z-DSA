package _11_Dynamic_Programming._04_DP_on_Subsequences;

import java.util.Arrays;

public class _22_Coin_Change_2 {
	public static void main(String args[]) {

		// in this infinite same number we can take
		int arr[] = { 1, 2, 3 };
		int target = 4;
		int n = arr.length;

		// Call the countWaysToMakeChange function and print the result
		System.out.println("The total number of ways is " + countWaysToMakeChange01(arr, n, target));

		System.out.println("The total number of ways is " + countWaysToMakeChange02(arr, n, target));

		System.out.println("The total number of ways is " + countWaysToMakeChange03(arr, n, target));

		System.out.println("The total number of ways is " + countWaysToMakeChange04(arr, n, target));

	}

	// Recursion
	private static int countWaysToMakeChange01(int[] arr, int n, int target) {
		return countWaysToMakeChangeUtil01(arr, n - 1, target);
	}

	private static int countWaysToMakeChangeUtil01(int[] arr, int idx, int target) {

		if (idx == 0) {
			if (target % arr[0] == 0) {
				return 1;
			} else {
				return 0;
			}

		}

		int notTaken = countWaysToMakeChangeUtil01(arr, idx - 1, target);

		int take = 0;
		if (arr[idx] <= target) {
			take = countWaysToMakeChangeUtil01(arr, idx, target - arr[idx]);
		}

		return notTaken + take;
	}

	// Memoization
	private static int countWaysToMakeChange02(int[] arr, int n, int target) {

		int[][] dp = new int[n][target + 1];

		for (int[] it : dp) {
			Arrays.fill(it, -1);
		}

		return countWaysToMakeChangeUtil02(arr, n - 1, target, dp);
	}

	private static int countWaysToMakeChangeUtil02(int[] arr, int idx, int target, int[][] dp) {

		if (idx == 0) {
			if (target % arr[0] == 0) {
				return 1;
			} else {
				return 0;
			}

		}

		if (dp[idx][target] != -1) {
			return dp[idx][target];
		}

		int notTaken = countWaysToMakeChangeUtil02(arr, idx - 1, target, dp);

		int take = 0;
		if (arr[idx] <= target) {
			take = countWaysToMakeChangeUtil02(arr, idx, target - arr[idx], dp);
		}

		return dp[idx][target] = notTaken + take;
	}

	// Tabulation
	private static int countWaysToMakeChange03(int[] arr, int n, int target) {
		int[][] dp = new int[n][target + 1];

		for (int i = 0; i <= target; i++) {
			if (i % arr[0] == 0) {
				dp[0][i] = 1;
			}
		}

		for (int idx = 1; idx < n; idx++) {
			for (int t = 0; t <= target; t++) {
				int notTaken = dp[idx - 1][t];

				int take = 0;
				if (arr[idx] <= t && t - arr[idx] >= 0) {
					take = dp[idx][t - arr[idx]];
				}

				dp[idx][t] = notTaken + take;
			}
		}

		return dp[n - 1][target];
	}

	//Tabulation Space Optimization
	private static int countWaysToMakeChange04(int[] arr, int n, int target) {
		int[] prev = new int[target + 1];
		int[] curr = new int[target + 1];
		for (int i = 0; i <= target; i++) {
			if (i % arr[0] == 0) {
				prev[i] = 1;
			}
		}

		for (int idx = 1; idx < n; idx++) {
			for (int t = 0; t <= target; t++) {
				int notTaken = prev[t];

				int take = 0;
				if (arr[idx] <= t && t - arr[idx] >= 0) {
					take = curr[t - arr[idx]];
				}

				curr[t] = notTaken + take;
			}
			prev = curr;
		}

		return prev[target];
	}
}
