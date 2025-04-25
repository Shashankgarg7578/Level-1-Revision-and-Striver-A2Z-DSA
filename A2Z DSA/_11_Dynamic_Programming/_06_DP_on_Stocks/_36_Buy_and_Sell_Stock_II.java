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
		System.out.println("The maximum profit that can be generated is " + getMaximumProfit05(Arr, n));

	}

	// Recursion
	// TC :- 2 power n
	// SC :- O(N)
	static long getMaximumProfit01(long[] Arr, int n) {

		if (n == 0) {
			return 0;
		}

		// Calculate the maximum profit using the recursive function
		//1 means we can buy
		//0 means we cann't buy means sell only
		long ans = getMaximumProfitUtil01(Arr, 0, 1, n);

		return ans;
	}

	static long getMaximumProfitUtil01(long[] arr, int ind, int buy, int n) {

		if (ind == n) {
			return 0;
		}

		long profit = 0;

		if (buy == 1) { // 1 means we can buy the stock
			profit = Math.max(-arr[ind] + getMaximumProfitUtil01(arr, ind + 1, 0, n), // take :- we buy
					0 + getMaximumProfitUtil01(arr, ind + 1, 1, n)); // notTake :- we don't buy move to next day
		} else {// 0 means we cann't buy the stock we sell only
			profit = Math.max(arr[ind] + getMaximumProfitUtil01(arr, ind + 1, 1, n),
					0 + getMaximumProfitUtil01(arr, ind + 1, 0, n));
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

		// Calculate the maximum profit using the recursive function
		//1 means we can buy
		//0 means we cann't buy means sell only
		long ans = getMaximumProfitUtil02(Arr, 0, 1, n, dp);

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

		if (buy == 1) { // 1 means we can buy the stock
			profit = Math.max(-arr[ind] + getMaximumProfitUtil01(arr, ind + 1, 0, n), // take :- we buy
					0 + getMaximumProfitUtil01(arr, ind + 1, 1, n)); // notTake :- we don't buy move to next day
		} else {// 0 means we cann't buy the stock we sell only
			profit = Math.max(arr[ind] + getMaximumProfitUtil01(arr, ind + 1, 1, n),
					0 + getMaximumProfitUtil01(arr, ind + 1, 0, n));
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
				if (buy == 1) { // 1 means we can buy the stock
					profit = Math.max(-arr[ind] + dp[ind + 1][0], // take
							0 + dp[ind + 1][1]); // notTake
				} else {// 0 means we cann't buy the stock only sell
					profit = Math.max(arr[ind] + dp[ind + 1][1], 0 + dp[ind + 1][0]);
				}
				dp[ind][buy] = profit;
			}
		}

		return dp[0][1];
	}

	// Tabulation + Space Optimization
	// Time Complexity: O(N*2)
	// Space Complexity: O(1)
	static long getMaximumProfit04(long[] arr, int n) {

		if (n == 0) {
			return 0;
		}

		long[] ahead = new long[2]; // 0th index is aheadNotBuy, 1st index is aheadBuy
		long[] curr = new long[2];// 0th index is currNotBuy, 1st index is currBuy

		for (int ind = n - 1; ind >= 0; ind--) {
			for (int buy = 0; buy <= 1; buy++) {
				long profit = 0;
				if (buy == 1) { // 1 means we can buy the stock
					profit = Math.max(-arr[ind] + ahead[0], // take
							0 + ahead[1]); // notTake
				} else {// 0 means we cann't buy the stock only sell
					profit = Math.max(arr[ind] + ahead[1], 0 + ahead[0]);
				}
				curr[buy] = profit;
			}
			ahead = curr;
		}

		return ahead[1];
	}

	// Tabulation + Space Optimization with only variables
	// Time Complexity: O(N*2)
	// Space Complexity: O(1)
	static long getMaximumProfit05(long[] arr, int n) {

		if (n == 0) {
			return 0;
		}

//		long[] ahead = new long[2]; // 0th index is aheadNotBuy, 1st index is aheadBuy
//		long[] curr = new long[2];// 0th index is currNotBuy, 1st index is currBuy

		long aheadNotBuy = 0, aheadBuy = 0;
		long currNotBuy = 0, currBuy = 0;

		for (int ind = n - 1; ind >= 0; ind--) {
			currBuy = Math.max(-arr[ind] + aheadNotBuy, // take
					0 + aheadBuy); // notTake

			currNotBuy = Math.max(arr[ind] + aheadBuy, 0 + aheadNotBuy);

			aheadBuy = currBuy;
			aheadNotBuy = currNotBuy;
		}

		return aheadBuy;
	}

}
