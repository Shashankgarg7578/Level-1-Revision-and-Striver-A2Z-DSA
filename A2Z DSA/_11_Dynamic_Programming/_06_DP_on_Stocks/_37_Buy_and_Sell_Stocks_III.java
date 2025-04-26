package _11_Dynamic_Programming._06_DP_on_Stocks;

import java.util.Arrays;

public class _37_Buy_and_Sell_Stocks_III {

	public static void main(String[] args) {
		int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
		
		// Here only 2 transactions allowed means 2 time buy & sell which can n't be overlapped

		// Calculate and print the maximum profit
		System.out.println("The maximum profit that can be generated is " + maxProfit01(prices));
		System.out.println("The maximum profit that can be generated is " + maxProfit02(prices));
		System.out.println("The maximum profit that can be generated is " + maxProfit03(prices));
		System.out.println("The maximum profit that can be generated is " + maxProfit04(prices));
		System.out.println("The maximum profit that can be generated is " + maxProfit05(prices));

	}

	// recursion
	static int maxProfit01(int[] prices) {

		int n = prices.length;

		return maxProfitUtils01(prices, n, 0, 1, 2);
	}

	private static int maxProfitUtils01(int[] prices, int n, int ind, int buy, int cap) {

		if (ind == n || cap == 0) {
			return 0;
		}

		int profit = 0;

		if (buy == 1) { // we can buy if it is 1

			profit = Math.max(-prices[ind] + maxProfitUtils01(prices, n, ind + 1, 0, cap),
					0 + maxProfitUtils01(prices, n, ind + 1, 1, cap));

		} else {// we can sell if it is 0
			profit = Math.max(prices[ind] + maxProfitUtils01(prices, n, ind + 1, 1, cap - 1),
					0 + maxProfitUtils01(prices, n, ind + 1, 0, cap));
		}

		return profit;
	}

	// Memoization
	// Time Complexity: O(N*2*3)
	// Space Complexity: O(N*2*3) + O(N)
	static int maxProfit02(int[] prices) {

		int n = prices.length;

		int[][][] dp = new int[n][2][3];

		for (int[][] first : dp) {
			for (int[] second : first) {
				Arrays.fill(second, -1);
			}
		}

		return maxProfitUtils02(prices, n, 0, 1, 2, dp);
	}

	private static int maxProfitUtils02(int[] prices, int n, int ind, int buy, int cap, int[][][] dp) {

		if (ind == n || cap == 0) {
			return 0;
		}

		if (dp[ind][buy][cap] != -1) {
			return dp[ind][buy][cap];
		}

		int profit = 0;

		if (buy == 1) { // we can buy if it is 1

			profit = Math.max(-prices[ind] + maxProfitUtils02(prices, n, ind + 1, 0, cap, dp),
					0 + maxProfitUtils02(prices, n, ind + 1, 1, cap, dp));

		} else {// we can sell if it is 0
			profit = Math.max(prices[ind] + maxProfitUtils02(prices, n, ind + 1, 1, cap - 1, dp),
					0 + maxProfitUtils02(prices, n, ind + 1, 0, cap, dp));
		}

		return dp[ind][buy][cap] = profit;
	}

	// Tabulation
	// Time Complexity: O(N*2*3)
	// Space Complexity: O(N*2*3)
	static int maxProfit03(int[] prices) {

		int n = prices.length;

		int[][][] dp = new int[n + 1][2][3];

		// both are base case
		for (int ind = 0; ind <= n - 1; ind++) {
			for (int buy = 0; buy <= 1; buy++) {
				dp[ind][buy][0] = 0;
			}
		}

		for (int buy = 0; buy <= 1; buy++) {
			for (int cap = 0; cap <= 2; cap++) {
				dp[n][buy][cap] = 0;
			}
		}

		for (int ind = n - 1; ind >= 0; ind--) {
			for (int buy = 0; buy <= 1; buy++) {
				for (int cap = 1; cap <= 2; cap++) {
					if (buy == 1) { // we can buy if it is 1

						dp[ind][buy][cap] = Math.max(-prices[ind] + dp[ind + 1][0][cap], 
								0 + dp[ind + 1][1][cap]);

					} else {// we can sell if it is 0
						dp[ind][buy][cap] = Math.max(prices[ind] + dp[ind + 1][1][cap - 1], 
								0 + dp[ind + 1][0][cap]);
					}

				}
			}
		}

		return dp[0][1][2];
	}

	// Tabulation Space Optimization
	// Time Complexity: O(N*2*3)
	// Space Complexity: O(N*2*3)
	static int maxProfit04(int[] prices) {

		int n = prices.length;

		int[][] ahead = new int[2][3];
		int[][] curr = new int[2][3];

		for (int ind = n - 1; ind >= 0; ind--) {
			for (int buy = 0; buy <= 1; buy++) {
				for (int cap = 1; cap <= 2; cap++) {
					if (buy == 1) { // we can buy if it is 1

						curr[buy][cap] = Math.max(-prices[ind] + ahead[0][cap], 
								0 + ahead[1][cap]);

					} else {// we can sell if it is 0
						curr[buy][cap] = Math.max(prices[ind] + ahead[1][cap - 1], 
								0 + ahead[0][cap]);
					}

				}
			}
			ahead = curr;
		}

		return ahead[1][2];
	}

	// recursion :- in this we are only use one integer value which define all buy and sell
	// transaction : 4 means (buy,sell,buy,sell)
	static int maxProfit05(int[] prices) {

		int n = prices.length;

		return maxProfitUtils05(prices, n, 0, 0);
	}

	private static int maxProfitUtils05(int[] prices, int n, int ind, int transaction) {

		if (ind == n || transaction == 4) {
			return 0;
		}

		int profit = 0;

		if (transaction % 2 == 0) { // we can buy if it is 1

			profit = Math.max(-prices[ind] + maxProfitUtils05(prices, n, ind + 1, transaction + 1),
					0 + maxProfitUtils05(prices, n, ind + 1, transaction));

		} else {// we can sell if it is 0
			profit = Math.max(prices[ind] + maxProfitUtils05(prices, n, ind + 1, transaction + 1),
					0 + maxProfitUtils05(prices, n, ind + 1, transaction));
		}

		return profit;
	}

}
