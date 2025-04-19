package _11_Dynamic_Programming._04_DP_on_Subsequences;

import java.util.Arrays;

public class _24_Rod_Cutting_Problem {

	public static void main(String args[]) {

		// In this we have to cut the rod for different weights
		// and get the maximize value
//we can cut rod in same weights too so this problem related to unbound knapsack

		int price[] = { 1, 6, 8, 9, 10, 19, 7, 20 };
		int N = 8; // this is rod

		// Call the unboundedKnapsack function and print the result
		System.out.println("The Maximum value of when we cut the rod : " + RodCutting01(price, N));
		System.out.println("The Maximum value of when we cut the rod : " + RodCutting02(price, N));
		System.out.println("The Maximum value of when we cut the rod : " + RodCutting03(price, N));
		System.out.println("The Maximum value of when we cut the rod : " + RodCutting04(price, N));

	}

	// recursion
	private static int RodCutting01(int price[], int n) {
		return RodCuttingUtils01(n - 1, n, price);
	}

	private static int RodCuttingUtils01(int idx, int N, int price[]) {

		if (idx == 0) {
			return N * price[0]; // for whatever rod we left we make price
		}

		int notTake = 0 + RodCuttingUtils01(idx - 1, N, price);

		int take = Integer.MIN_VALUE;
		int rodLength = idx + 1; // taking index for rod price
		if (rodLength <= N) {
			take = price[idx] + RodCuttingUtils01(idx, N - rodLength, price);
		}

		return Math.max(take, notTake);
	}

	// Memoization
	private static int RodCutting02(int price[], int n) {

		int[][] dp = new int[n][n + 1];

		for (int[] it : dp) {
			Arrays.fill(it, -1);
		}
		return RodCuttingUtils02(n - 1, n, price, dp);
	}

	private static int RodCuttingUtils02(int idx, int N, int price[], int[][] dp) {

		if (idx == 0) {
			return N * price[0]; // for whatever rod we left we make price
		}

		if (dp[idx][N] != -1) {
			return dp[idx][N];
		}

		int notTake = 0 + RodCuttingUtils02(idx - 1, N, price, dp);

		int take = Integer.MIN_VALUE;
		int rodLength = idx + 1; // taking index for rod price
		if (rodLength <= N) {
			take = price[idx] + RodCuttingUtils02(idx, N - rodLength, price, dp);
		}

		return dp[idx][N] = Math.max(take, notTake);
	}

	// Tabulation
	private static int RodCutting03(int price[], int n) {

		int[][] dp = new int[n][n + 1];

		for (int N = 0; N <= n; N++) {
			dp[0][N] = N * price[0];
		}

		for (int idx = 1; idx < n; idx++) {
			for (int N = 0; N <= n; N++) {

				int notTake = 0 + dp[idx - 1][N];

				int take = Integer.MIN_VALUE;
				int rodLength = idx + 1; // taking index for rod price
				if (rodLength <= N) {
					take = price[idx] + dp[idx][N - rodLength];
				}

				dp[idx][N] = Math.max(take, notTake);
			}
		}

		return dp[n - 1][n];
	}

	// Tabulation
	private static int RodCutting04(int price[], int n) {

		int[] prev = new int[n + 1];
		int[] curr = new int[n + 1];
		for (int N = 0; N <= n; N++) {
			prev[N] = N * price[0];
		}

		for (int idx = 1; idx < n; idx++) {
			for (int N = 0; N <= n; N++) {

				int notTake = 0 + prev[N];

				int take = Integer.MIN_VALUE;
				int rodLength = idx + 1; // taking index for rod price
				if (rodLength <= N) {
					take = price[idx] + curr[N - rodLength];
				}

				curr[N] = Math.max(take, notTake);
			}
			prev = curr;
		}

		return prev[n];
	}

}
