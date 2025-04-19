package _11_Dynamic_Programming._04_DP_on_Subsequences;

import java.util.Arrays;

public class _23_Unbounded_Knapsack {
	public static void main(String args[]) {

		// this program is same as knapsack01 but here we allow to take same wt infinite
		// time.

		int wt[] = { 2, 4, 6 };
		int val[] = { 5, 11, 13 };
		int W = 10;

		int n = wt.length;

		// Call the unboundedKnapsack function and print the result
		System.out.println("The Maximum value of items, the thief can steal is " + unboundedKnapsack01(n, W, val, wt));
		System.out.println("The Maximum value of items, the thief can steal is " + unboundedKnapsack02(n, W, val, wt));
		System.out.println("The Maximum value of items, the thief can steal is " + unboundedKnapsack03(n, W, val, wt));
		System.out.println("The Maximum value of items, the thief can steal is " + unboundedKnapsack04(n, W, val, wt));

	}

	// reursion
	private static int unboundedKnapsack01(int n, int W, int[] val, int[] wt) {
		return unboundedKnapsackUtils01(n - 1, W, val, wt);
	}

	private static int unboundedKnapsackUtils01(int ind, int W, int[] val, int[] wt) {

		if (ind == 0) {
			return ((int) (W / wt[0])) * val[0];
		}

		int notTake = 0 + unboundedKnapsackUtils01(ind - 1, W, val, wt);

		int take = Integer.MIN_VALUE;
		if (wt[ind] <= W) {
			take = val[ind] + unboundedKnapsackUtils01(ind, W - wt[ind], val, wt);
		}
		return Math.max(notTake, take);
	}

	// Memoization
	private static int unboundedKnapsack02(int n, int W, int[] val, int[] wt) {
		int[][] dp = new int[n][W + 1];

		for (int[] it : dp) {
			Arrays.fill(it, -1);
		}

		return unboundedKnapsackUtils02(n - 1, W, val, wt, dp);
	}

	private static int unboundedKnapsackUtils02(int ind, int W, int[] val, int[] wt, int[][] dp) {

		if (ind == 0) {
			return ((int) (W / wt[0])) * val[0];
		}

		if (dp[ind][W] != -1) {
			return dp[ind][W];
		}

		int notTake = 0 + unboundedKnapsackUtils02(ind - 1, W, val, wt, dp);

		int take = Integer.MIN_VALUE;
		if (wt[ind] <= W) {
			take = val[ind] + unboundedKnapsackUtils02(ind, W - wt[ind], val, wt, dp);
		}
		return dp[ind][W] = Math.max(notTake, take);
	}

	// tabulation
	private static int unboundedKnapsack03(int n, int W, int[] val, int[] wt) {
		int[][] dp = new int[n][W + 1];

		for (int i = wt[0]; i <= W; i++) {
			dp[0][i] = ((int) (i / wt[0])) * val[0];
		}

		for (int idx = 1; idx < n; idx++) {
			for (int cap = 0; cap <= W; cap++) {

				int notTake = 0 + dp[idx - 1][cap];

				int take = Integer.MIN_VALUE;
				if (wt[idx] <= cap && cap - wt[idx] >= 0) {
					take = val[idx] + dp[idx][cap - wt[idx]];
				}
				dp[idx][cap] = Math.max(notTake, take);
			}
		}

		return dp[n - 1][W];
	}

	// tabulation Space Optimization
	private static int unboundedKnapsack04(int n, int W, int[] val, int[] wt) {
		int[] prev = new int[W + 1];
		int[] curr = new int[W + 1];

		for (int i = wt[0]; i <= W; i++) {
			prev[i] = ((int) (i / wt[0])) * val[0];
		}

		for (int idx = 1; idx < n; idx++) {
			for (int cap = 0; cap <= W; cap++) {

				int notTake = 0 + prev[cap];

				int take = Integer.MIN_VALUE;
				if (wt[idx] <= cap && cap - wt[idx] >= 0) {
					take = val[idx] + curr[cap - wt[idx]];
				}
				curr[cap] = Math.max(notTake, take);
			}
			prev = curr;
		}

		return prev[W];
	}

}
