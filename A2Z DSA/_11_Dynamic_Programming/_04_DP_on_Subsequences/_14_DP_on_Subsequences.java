package _11_Dynamic_Programming._04_DP_on_Subsequences;

import java.util.Arrays;

//DP Subsequence(contiguous or non-contiguous) / Subset

//Subsequence :- it have to follow the order.
//Subsquence(subarray) Example :- [1,3,2] = {1,2} or {3,2}

//subset :- it may be OR may not be follow the exact order.

public class _14_DP_on_Subsequences {
	public static void main(String args[]) {
		int arr[] = { 1, 2, 3, 4 };
		int k = 4; // target
		int n = arr.length;

		// Check if there exists a subset with the given target sum
		if (subsetSumToK(n, k, arr)) {
			System.out.println("Subset with the given target found");
		} else {
			System.out.println("Subset with the given target not found");
		}

		if (subsetSumToK2(n, k, arr)) {
			System.out.println("Subset with the given target found");
		} else {
			System.out.println("Subset with the given target not found");
		}

		if (subsetSumToK3(n, k, arr)) {
			System.out.println("Subset with the given target found");
		} else {
			System.out.println("Subset with the given target not found");
		}

		if (subsetSumToK4(n, k, arr)) {
			System.out.println("Subset with the given target found");
		} else {
			System.out.println("Subset with the given target not found");
		}
	}

	// By Recursion
	private static boolean subsetSumToK(int n, int k, int[] arr) {
		return subsetSumUtil(n - 1, k, arr);
	}

	private static boolean subsetSumUtil(int idx, int target, int[] arr) {

		if (target == 0) {
			return true;
		}

		if (idx == 0) {
			return arr[0] == target;
		}

		boolean notTaken = subsetSumUtil(idx - 1, target, arr);

		boolean taken = false;
		if (arr[idx] <= target) {
			taken = subsetSumUtil(idx - 1, target - arr[idx], arr);
		}

		return notTaken || taken;
	}

	// By Memoization
	private static boolean subsetSumToK2(int n, int k, int[] arr) {

		int[][] dp = new int[n][k + 1];

		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return subsetSumUtil2(n - 1, k, arr, dp);
	}

	private static boolean subsetSumUtil2(int idx, int target, int[] arr, int[][] dp) {

		if (target == 0) {
			return true;
		}

		if (idx == 0) {
			return arr[0] == target;
		}

		boolean notTaken = subsetSumUtil2(idx - 1, target, arr, dp);

		boolean taken = false;
		if (arr[idx] <= target) {
			taken = subsetSumUtil2(idx - 1, target - arr[idx], arr, dp);
		}

		dp[idx][target] = notTaken || taken ? 1 : 0;

		return notTaken || taken;
	}

	// By Tabulation
	private static boolean subsetSumToK3(int n, int k, int[] arr) {

		boolean[][] dp = new boolean[n][k + 1];

		// Initialize the first row of the DP table
		for (int i = 0; i < n; i++) {
			dp[i][0] = true;
		}

		// Initialize the first column of the DP table
		if (arr[0] <= k) {
			dp[0][arr[0]] = true;
		}

		for (int ind = 1; ind < n; ind++) {
			for (int target = 1; target <= k; target++) {

				boolean notTaken = dp[ind - 1][target];
				boolean taken = false;

				if (arr[ind] <= target) {
					taken = dp[ind - 1][target - arr[ind]];
				}

				dp[ind][target] = notTaken | taken;

			}
		}

		return dp[n - 1][k];
	}

	// By Tabulation Space Optimization
	private static boolean subsetSumToK4(int n, int k, int[] arr) {

		boolean[] prev = new boolean[k + 1];

		// Initialize the first row of the DP table
		prev[0] = true;

		// Initialize the first column of the DP table
		if (arr[0] <= k) {
			prev[arr[0]] = true;
		}

		for (int ind = 1; ind < n; ind++) {
			boolean[] curr = new boolean[k + 1];
			curr[0] = true;
			for (int target = 1; target <= k; target++) {

				boolean notTaken = prev[target];

				boolean taken = false;
				if (arr[ind] <= target) {
					taken = prev[target - arr[ind]];
				}

				curr[target] = notTaken || taken;

			}
			prev = curr;
		}

		return prev[k];
	}

}
