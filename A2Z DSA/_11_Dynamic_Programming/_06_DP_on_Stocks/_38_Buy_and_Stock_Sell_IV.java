package _11_Dynamic_Programming._06_DP_on_Stocks;

import java.util.Arrays;

public class _38_Buy_and_Stock_Sell_IV {

	public static void main(String[] args) {

		// Here only N transactions allowed means N time buy & sell which can n't be overlapped ,
		// it is same as previous question but here we are using N transactions.

		int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
		int n = prices.length;
		int k = 2;

		System.out.println("The maximum profit that can be generated is " + maximumProfit01(prices, n, k));
		System.out.println("The maximum profit that can be generated is " + maximumProfit02(prices, n, k));
		System.out.println("The maximum profit that can be generated is " + maximumProfit03(prices, n, k));
		System.out.println("The maximum profit that can be generated is " + maximumProfit04(prices, n, k));
		System.out.println("The maximum profit that can be generated is " + maximumProfit05(prices, n, k));

	}

	// Similar solution as previous question Q 37
	// Time Complexity: O(N*k)
	// Space Complexity: O(N*k)
	private static int maximumProfit01(int[] prices, int n, int k) {

		int[][] ahead = new int[k + 1][3];
		int[][] curr = new int[k + 1][3];

		for (int ind = n - 1; ind >= 0; ind--) {
			for (int buy = 0; buy <= 1; buy++) {
				for (int cap = 1; cap <= k; cap++) {
					if (buy == 1) { // we can buy if it is 1

						curr[buy][cap] = Math.max(-prices[ind] + ahead[0][cap], 0 + ahead[1][cap]);

					} else {// we can sell if it is 0
						curr[buy][cap] = Math.max(prices[ind] + ahead[1][cap - 1], 0 + ahead[0][cap]);
					}

				}
			}
			ahead = curr;
		}

		return ahead[1][k];

	}

	// recursion :- in this we are only use one integer value which define all buy and sell
	// transaction : 4 means (buy,sell,buy,sell)
	static int maximumProfit02(int[] prices, int n, int k) {

		return maximumProfitUtils02(prices, n, k, 0, 0);
	}

	private static int maximumProfitUtils02(int[] prices, int n, int k, int ind, int transaction) {

		if (ind == n || transaction == 2 * k) {
			return 0;
		}

		if (transaction % 2 == 0) { // we can buy if it is 1

			return Math.max(-prices[ind] + maximumProfitUtils02(prices, n, k, ind + 1, transaction + 1),
					0 + maximumProfitUtils02(prices, n, k, ind + 1, transaction));

		}

		// we can sell if it is 0
		return Math.max(prices[ind] + maximumProfitUtils02(prices, n, k, ind + 1, transaction + 1),
				0 + maximumProfitUtils02(prices, n, k, ind + 1, transaction));
	}
	
	// Memoization :- in this we are only use one integer value which define all buy and sell
	// transaction : 4 means (buy,sell,buy,sell)
	static int maximumProfit03(int[] prices, int n, int k) {

        // Creating a 3D array dp of size [n][2*k+1]
        int[][] dp = new int[n][2*k];
	
        // Initialize dp with -1 to mark states as not calculated yet
        for (int[] it :dp) {
                Arrays.fill(it, -1);
            
        }
        
		return maximumProfitUtils03(prices, n, k, 0, 0, dp);
	}

	private static int maximumProfitUtils03(int[] prices, int n, int k, int ind, int transaction, int[][] dp) {

		if (ind == n || transaction == 2 * k) {
			return 0;
		}

		if (dp[ind][transaction] != -1) {
			return dp[ind][transaction];
		}

		if (transaction % 2 == 0) { // we can buy if it is 1

			return dp[ind][transaction] = Math.max(-prices[ind] + maximumProfitUtils03(prices, n, k, ind + 1, transaction + 1, dp),
					0 + maximumProfitUtils03(prices, n, k, ind + 1, transaction, dp));

		}

		// we can sell if it is 0
		return dp[ind][transaction] = Math.max(prices[ind] + maximumProfitUtils03(prices, n, k, ind + 1, transaction + 1, dp),
				0 + maximumProfitUtils03(prices, n, k, ind + 1, transaction, dp));
	}
	
	// Tabulation
	// transaction : 4 means (buy,sell,buy,sell)
	static int maximumProfit04(int[] prices, int n, int k) {

		// Creating a 3D array dp of size [n][2*k+1]
		int[][] dp = new int[n + 1][2 * k + 1];

		for (int ind = n - 1; ind >= 0; ind--) {
			for (int tranNo = 2 * k - 1; tranNo >= 0; tranNo--) {
				if (tranNo % 2 == 0) { // we can buy if it is 1

					dp[ind][tranNo] = Math.max(-prices[ind] + dp[ind + 1][tranNo + 1], 0 + dp[ind + 1][tranNo]);

				} else
					// we can sell if it is 0
					dp[ind][tranNo] = Math.max(prices[ind] + dp[ind + 1][tranNo + 1], 0 + dp[ind + 1][tranNo]);
			}
		}

		return dp[0][0];
	}

	
	// Tabulation Space Optimization
	// transaction : 4 means (buy,sell,buy,sell)
	static int maximumProfit05(int[] prices, int n, int k) {

		// Creating a 2D array dp of size [n][2*k+1]
		int[] after = new int[2 * k + 1];
		int[] curr = new int[2 * k + 1];

		for (int ind = n - 1; ind >= 0; ind--) {
			for (int tranNo = 2 * k - 1; tranNo >= 0; tranNo--) {
				if (tranNo % 2 == 0) { // we can buy if it is 1

					curr[tranNo] = Math.max(-prices[ind] + after[tranNo + 1], 0 + after[tranNo]);

				} else
					// we can sell if it is 0
					curr[tranNo] = Math.max(prices[ind] + after[tranNo + 1], 0 + after[tranNo]);
			}
			after = curr;
		}

		return after[0];
	}
	
}
