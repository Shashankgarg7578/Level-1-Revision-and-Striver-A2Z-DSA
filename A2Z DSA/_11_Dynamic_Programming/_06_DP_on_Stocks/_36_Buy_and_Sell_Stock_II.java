package _11_Dynamic_Programming._06_DP_on_Stocks;

import java.util.Arrays;

public class _36_Buy_and_Sell_Stock_II {

	// give me total profit
	// you can buy and sell any number of times.
	// but the thing is first if you buy the you have to sell then only you are able
	// to buy again.

	public static void main(String[] args) {
		int n = 6;
		long[] Arr = { 7, 1, 5, 3, 6, 4 };

		// Calculate and print the maximum profit
		System.out.println("The maximum profit that can be generated is " + getMaximumProfit01(Arr, n));
		System.out.println("The maximum profit that can be generated is " + getMaximumProfit02(Arr, n));
		System.out.println("The maximum profit that can be generated is " + getMaximumProfit03(Arr, n));
		System.out.println("The maximum profit that can be generated is " + getMaximumProfit04(Arr, n));

	}

	// Recursion
	// TC :- 2 power n
	// SC :- O(N)
	static long getMaximumProfit01(long[] Arr, int n) {

		if (n == 0) {
			return 0;
		}

		// Calculate the maximum profit using the recursive function
		long ans = getMaximumProfitUtil01(Arr, 0, 0, n);

		return ans;
	}

	static long getMaximumProfitUtil01(long[] arr, int ind, int buy, int n) {

		if (ind == n) {
			return 0;
		}

		long profit = 0;

		if (buy == 0) { // 0 means we can buy the stock
			profit = Math.max(-arr[ind] + getMaximumProfitUtil01(arr, ind + 1, 1, n), // take
					0 + getMaximumProfitUtil01(arr, ind + 1, 0, n)); // notTake
		} else {// 1 means we can buy the stock
			profit = Math.max(arr[ind] + getMaximumProfitUtil01(arr, ind + 1, 0, n),
					0 + getMaximumProfitUtil01(arr, ind + 1, 1, n));
		}

		return profit;
	}

	// Memoization
	// Time Complexity: O(N*2)
	// Space Complexity: O(N*2) + O(N)
	static long getMaximumProfit02(long[] Arr, int n) {

		if (n == 0) {
			return 0;
		}

		long[][] dp = new long[n][2];
		for (long[] it : dp) {
			Arrays.fill(it, -1);
		}

		// Calculate the maximum profit using the recursive function
		long ans = getMaximumProfitUtil02(Arr, 0, 0, n, dp);

		return ans;
	}

	static long getMaximumProfitUtil02(long[] arr, int ind, int buy, int n, long[][] dp) {

		if (ind == n) {
			return 0;
		}

		if (dp[ind][buy] != -1) {
			return dp[ind][buy];
		}

		long profit = 0;

		if (buy == 0) { // 0 means we can buy the stock
			profit = Math.max(-arr[ind] + getMaximumProfitUtil02(arr, ind + 1, 1, n, dp), // take
					0 + getMaximumProfitUtil02(arr, ind + 1, 0, n, dp)); // notTake
		} else {// 1 means we can buy the stock
			profit = Math.max(arr[ind] + getMaximumProfitUtil02(arr, ind + 1, 0, n, dp),
					0 + getMaximumProfitUtil02(arr, ind + 1, 1, n, dp));
		}

		return dp[ind][buy] = profit;
	}

	// Tabulation
	// Time Complexity: O(N*2)
	// Space Complexity: O(N*2)
	static long getMaximumProfit03(long[] arr, int n) {

		if (n == 0) {
			return 0;
		}

		long[][] dp = new long[n + 1][2];
		for (long[] it : dp) {
			Arrays.fill(it, -1);
		}

		dp[n][0] = 0;
		dp[n][1] = 0;

		for (int ind = n - 1; ind >= 0; ind--) {
			for (int buy = 0; buy <= 1; buy++) {
				long profit = 0;
				if (buy == 0) { // 0 means we can buy the stock
					profit = Math.max(-arr[ind] + dp[ind + 1][1], // take
							0 + dp[ind + 1][0]); // notTake
				} else {// 1 means we can buy the stock
					profit = Math.max(arr[ind] + dp[ind + 1][0], 0 + dp[ind + 1][1]);
				}
				dp[ind][buy] = profit;
			}
		}

		return dp[0][0];
	}

	// Tabulation
	// Time Complexity: O(N*2)
	// Space Complexity: O(1)
	static long getMaximumProfit04(long[] arr, int n) {

		if (n == 0) {
			return 0;
		}

		long[] ahead = new long[2];
		long[] curr = new long[2];

		for (int ind = n - 1; ind >= 0; ind--) {
			for (int buy = 0; buy <= 1; buy++) {
				long profit = 0;
				if (buy == 0) { // 0 means we can buy the stock
					profit = Math.max(-arr[ind] + ahead[1], // take
							0 + ahead[0]); // notTake
				} else {// 1 means we can buy the stock
					profit = Math.max(arr[ind] + ahead[0], 0 + ahead[1]);
				}
				curr[buy] = profit;
			}
			ahead = curr;
		}

		return curr[0];
	}

}
