package _11_Dynamic_Programming._04_DP_on_Subsequences;

import java.util.Arrays;

public class _17_Count_Subsets_with_Sum_K {

	// This Question similar to Q14 just here we need to count total subsets

	public static void main(String args[]) {
		int arr[] = { 1, 2, 2, 3 };
		int k = 3;

		// Calculate and print the number of subsets that sum up to k
		System.out.println("The number of subsets found are " + findWays(arr, arr.length - 1, k));

		System.out.println("The number of subsets found are " + findWays2(arr, arr.length - 1, k));

		System.out.println("The number of subsets found are " + findWays3(arr, arr.length - 1, k));

		System.out.println("The number of subsets found are " + findWays4(arr, arr.length - 1, k));

		System.out.println("The number of subsets found are " + findWays5(arr, arr.length - 1, k));

	}

	// Recursion
//	Time Complexity: O(2^n)
//	Space Complexity: O(N)
	private static int findWays(int[] arr, int idx, int target) {

		if (target == 0) {
			return 1;
		}

		if (idx == 0) {
			return arr[0] == target ? 1 : 0;
		}

		int notTake = findWays(arr, idx - 1, target);

		int take = 0;
		if (arr[idx] <= target) {
			take = findWays(arr, idx - 1, target - arr[idx]);
		}

		return take + notTake;
	}

	// Memoization
//	Time Complexity: O(N*K)
//	Space Complexity: O(N*K) + O(N)
	private static int findWays2(int[] arr, int idx, int target) {

		int n = arr.length;

		int dp[][] = new int[n][target + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return findWaysUtil2(arr, n - 1, target, dp);
	}

	private static int findWaysUtil2(int[] arr, int idx, int target, int dp[][]) {

		if (target == 0) {
			return 1;
		}

		if (idx == 0) {
			return arr[0] == target ? 1 : 0;
		}

		if (dp[idx][target] != -1) {
			return dp[idx][target];
		}

		int notTake = findWays(arr, idx - 1, target);

		int take = 0;
		if (arr[idx] <= target) {
			take = findWays(arr, idx - 1, target - arr[idx]);
		}

		return dp[idx][target] = take + notTake;
	}

	// Tabulation :- go in tuf docs
//	Time Complexity: O(N*K)
//	Space Complexity: O(N*K)
	private static int findWays3(int[] arr, int idx, int k) {

		int n = arr.length;

		// Create a 2D DP array to store the number of ways to achieve each target sum
		int dp[][] = new int[n][k + 1];

		// Initialize the first row of the DP array
		for (int i = 0; i < n; i++) {
			dp[i][0] = 1;
		}

		// Initialize the first column of the DP array
		if (arr[0] <= k) {
			dp[0][arr[0]] = 1;
		}

		// Fill in the DP array using bottom-up dynamic programming
		for (int ind = 1; ind < n; ind++) {
			for (int target = 1; target <= k; target++) {
				// Calculate the number of ways when the current element is not taken
				int notTake = dp[ind - 1][target];

				// Calculate the number of ways when the current element is taken
				int take = 0;
				if (arr[ind] <= target) {
					take = dp[ind - 1][target - arr[ind]];
				}

				// Update the DP array for the current element and target sum
				dp[ind][target] = take + notTake;
			}
		}

		return dp[n - 1][k];
	}

	// Tabulation Space Optimization
//	Time Complexity: O(N*K)
//	Space Complexity: O(N*K)
	private static int findWays4(int[] arr, int idx, int k) {

		int n = arr.length;

		int prev[] = new int[k + 1];

		prev[0] = 1;

		if (arr[0] <= k) {
			prev[arr[0]] = 1;
		}

		for (int ind = 1; ind < n; ind++) {
			int curr[] = new int[k + 1];
			curr[0] = 1;
			for (int target = 1; target <= k; target++) {
				int notTake = prev[target];

				int take = 0;
				if (arr[ind] <= target) {
					take = prev[target - arr[ind]];
				}

				curr[target] = take + notTake;
			}
			prev = curr;
		}

		return prev[k];
	}

	// Memoization
//	Time Complexity: O(N*K)
//	Space Complexity: O(N*K) + O(N)
	// this is for if Q is {0,0,1} then ans is 4 but in previous that is giving 1.
	private static int findWays5(int[] arr, int idx, int target) {

		int n = arr.length;

		int dp[][] = new int[n][target + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return findWaysUtil5(arr, n - 1, target, dp);
	}

	private static int findWaysUtil5(int[] arr, int idx, int target, int dp[][]) {

		if (idx == 0) {
			if (target == 0 && arr[0] == 0)
				return 2;
			if (target == 0 || arr[0] == target)
				return 1;
			return 0;
		}

		if (dp[idx][target] != -1) {
			return dp[idx][target];
		}

		int notTake = findWays(arr, idx - 1, target);

		int take = 0;
		if (arr[idx] <= target) {
			take = findWays(arr, idx - 1, target - arr[idx]);
		}

		return dp[idx][target] = take + notTake;

	}

}
