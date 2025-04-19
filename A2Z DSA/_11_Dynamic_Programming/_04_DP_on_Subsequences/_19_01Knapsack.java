package _11_Dynamic_Programming._04_DP_on_Subsequences;

import java.util.Arrays;

public class _19_01Knapsack {
	public static void main(String args[]) {
		int wt[] = { 1, 2, 4, 5 };
		int val[] = { 5, 4, 8, 6 };
		int W = 5; // bag weight
		int n = wt.length; // items in room

		// Calculate and print the maximum value of items the thief can steal
		System.out.println("The Maximum value of items the thief can steal is : " + knapsack01(wt, val, n, W));
		System.out.println("The Maximum value of items the thief can steal is : " + knapsack02(wt, val, n, W));
		System.out.println("The Maximum value of items the thief can steal is : " + knapsack03(wt, val, n, W));
		System.out.println("The Maximum value of items the thief can steal is : " + knapsack04(wt, val, n, W));
		System.out.println("The Maximum value of items the thief can steal is : " + knapsack05(wt, val, n, W));

	}

	// Recursion
	// Time Complexity: O(N*W)
	// Space Complexity: O(N*W) + O(N)
	private static int knapsack01(int[] wt, int[] val, int n, int W) {
		return knapSackUtil01(wt, val, n - 1, W);
	}

	private static int knapSackUtil01(int[] wt, int[] val, int idx, int W) {

		if (idx == 0) {
			if (wt[idx] <= W) {
				return val[idx];
			} else {
				return 0;
			}
		}

		// not taking current idx value
		int notTake = 0 + knapSackUtil01(wt, val, idx - 1, W);

		// taking current idx value
		int take = Integer.MIN_VALUE;
		if (wt[idx] <= W) {
			take = val[idx] + knapSackUtil01(wt, val, idx - 1, W - wt[idx]);
		}

		return Math.max(notTake, take);
	}

	// Memoization
	// Time Complexity: O(N*W)
	// Space Complexity: O(N*W) + O(N)
	private static int knapsack02(int[] wt, int[] val, int n, int W) {
		int[][] dp = new int[n][W + 1]; // on the basis of index because index end on n-1

		for (int[] itArr : dp) {
			Arrays.fill(itArr, -1);
		}

		return knapSackUtil02(wt, val, n - 1, W, dp);
	}

	private static int knapSackUtil02(int[] wt, int[] val, int idx, int W, int[][] dp) {

		// base condition
		if (idx == 0) {
			if (wt[idx] <= W) {
				return val[idx];
			} else {
				return 0;
			}
		}

		if (dp[idx][W] != -1) {
			return dp[idx][W];
		}

		// not taking current idx value
		int notTake = 0 + knapSackUtil01(wt, val, idx - 1, W);

		// taking current idx value
		int take = Integer.MIN_VALUE;
		if (wt[idx] <= W) {
			take = val[idx] + knapSackUtil01(wt, val, idx - 1, W - wt[idx]);
		}

		dp[idx][W] = Math.max(notTake, take);

		return dp[idx][W];
	}

	// Tabulation
	// Time Complexity: O(N*W)
	// Space Complexity: O(N*W)
	private static int knapsack03(int[] wt, int[] val, int n, int W) {
		int[][] dp = new int[n][W + 1]; // on the basis of index because index end on n-1

		for (int i = wt[0]; i <= W; i++) {
			dp[0][i] = val[0];
		}

		for (int idx = 1; idx < n; idx++) {
			for (int cap = 0; cap <= W; cap++) {
				int notTake = dp[idx - 1][cap];

				int take = Integer.MIN_VALUE;
				if (wt[idx] <= cap) {
					take = val[idx] + dp[idx - 1][cap - wt[idx]];
				}
				dp[idx][cap] = Math.max(notTake, take);
			}
		}

		return dp[n - 1][W];
	}

	// Space optimization
	// Time Complexity: O(N*W)
	// Space Complexity: O(N)
	private static int knapsack04(int[] wt, int[] val, int n, int W) {
		int[] prev = new int[W + 1]; // on the basis of index because index end on n-1

		int[] curr = new int[W + 1];
		for (int i = wt[0]; i <= W; i++) {
			prev[i] = val[0];
		}

		for (int idx = 1; idx < n; idx++) {
			for (int cap = 0; cap <= W; cap++) {
				int notTake = prev[cap];

				int take = Integer.MIN_VALUE;
				if (wt[idx] <= cap) {
					take = val[idx] + prev[cap - wt[idx]];
				}
				curr[cap] = Math.max(notTake, take);
			}

			prev = curr;
		}

		return prev[W];
	}

	// Space optimization
	// Time Complexity: O(N*W)
	// Space Complexity: O(W)
	private static int knapsack05(int[] wt, int[] val, int n, int W) {
		int[] prev = new int[W + 1]; // on the basis of index because index end on n-1

		for (int i = wt[0]; i <= W; i++) {
			prev[i] = val[0];
		}

		for (int idx = 1; idx < n; idx++) {
			for (int cap = W; cap >= 0; cap--) {
				int notTake = prev[cap];

				int take = Integer.MIN_VALUE;
				if (wt[idx] <= cap) {
					take = val[idx] + prev[cap - wt[idx]];
				}
				prev[cap] = Math.max(notTake, take);
			}
		}

		return prev[W];
	}

}
