package _11_Dynamic_Programming._04_DP_on_Subsequences;

import java.util.Arrays;

//infinite supply of coins , but in previous question we have only once
public class _20_Minimum_Coins {

	public static void main(String args[]) {
		int arr[] = { 2, 5, 10, 1 };
		int T = 27;

		// Call the minimumElements function and print the result
		System.out
				.println("The minimum number of coins required to form the target sum is " + minimumElements01(arr, T));
		System.out
				.println("The minimum number of coins required to form the target sum is " + minimumElements02(arr, T));
		System.out
				.println("The minimum number of coins required to form the target sum is " + minimumElements03(arr, T));
		System.out
				.println("The minimum number of coins required to form the target sum is " + minimumElements04(arr, T));

	}

	// Recursion
	private static int minimumElements01(int[] arr, int target) {

		int n = arr.length;

		return minimumElementsUtils01(arr, n - 1, target);
	}

	private static int minimumElementsUtils01(int[] arr, int idx, int target) {

		if (idx == 0) {
			if (target % arr[idx] == 0) {
				return target / arr[idx];
			} else {
				return (int) 1e9;
			}
		}

		int notTake = 0 + minimumElementsUtils01(arr, idx - 1, target);

		// here if we pick we have to be on same index
		int take = (int) 1e9;
		if (target >= arr[idx]) {
			take = 1 + minimumElementsUtils01(arr, idx, target - arr[idx]);
		}

		return Math.min(notTake, take);
	}

	// Memoization
	private static int minimumElements02(int[] arr, int target) {

		int n = arr.length;
		int[][] dp = new int[n][target + 1];

		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		int ans = minimumElementsUtils02(arr, n - 1, target, dp);
		if (ans >= (int) Math.pow(10, 9)) {
			return -1;
		}

		return ans;
	}

	private static int minimumElementsUtils02(int[] arr, int idx, int target, int[][] dp) {

		if (idx == 0) {
			if (target % arr[idx] == 0) {
				return target / arr[idx];
			} else {
				return (int) Math.pow(10, 9);
			}
		}

		if (dp[idx][target] != -1) {
			return dp[idx][target];
		}

		int notTake = 0 + minimumElementsUtils02(arr, idx - 1, target, dp);

		// here if we pick we have to be on same index
		int take = (int) Math.pow(10, 9);
		if (target >= arr[idx]) {
			take = 1 + minimumElementsUtils02(arr, idx, target - arr[idx], dp);
		}

		return dp[idx][target] = Math.min(notTake, take);
	}

	// Tabulation
	private static int minimumElements03(int[] arr, int target) {

		int n = arr.length;
		int[][] dp = new int[n][target + 1];

		// for base condition for 0th row
		for (int t = 0; t <= target; t++) {
			if (t % arr[0] == 0) {
				dp[0][t] = t / arr[0];
			} else {
				dp[0][t] = (int) Math.pow(10, 9);
			}
		}

		// for 1st row to last row
		for (int ind = 1; ind < n; ind++) {
			for (int t = 0; t <= target; t++) {

				int notTake = 0 + dp[ind - 1][t];

				// here if we pick we have to be on same index
				int take = (int) Math.pow(10, 9);
				if (t >= arr[ind]) {
					take = 1 + dp[ind][t - arr[ind]];
				}

				dp[ind][t] = Math.min(notTake, take);

			}
		}

		int ans = dp[n - 1][target];

		if (ans >= Math.pow(10, 9)) {
			return -1;
		}

		return ans;
	}

	// Tabulation + Space Optimization
	private static int minimumElements04(int[] arr, int target) {

		int n = arr.length;
		int[] prev = new int[target + 1];
		int[] curr = new int[target + 1];

		// for base condition for 0th row
		for (int t = 0; t <= target; t++) {
			if (t % arr[0] == 0) {
				prev[t] = t / arr[0];
			} else {
				prev[t] = (int) Math.pow(10, 9);
			}
		}

		// for 1st row to last row
		for (int ind = 1; ind < n; ind++) {
			for (int t = 0; t <= target; t++) {

				int notTake = 0 + prev[t];

				// here if we pick we have to be on same index
				int take = (int) Math.pow(10, 9);
				if (t >= arr[ind]) {
					take = 1 + curr[t - arr[ind]];
				}

				curr[t] = Math.min(notTake, take);

			}
			prev = curr;
		}

		int ans = prev[target];

		if (ans >= Math.pow(10, 9)) {
			return -1;
		}

		return ans;
	}

}
