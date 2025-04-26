package _11_Dynamic_Programming._06_DP_on_Stocks;

import java.util.Arrays;

public class _39_Buy_and_Sell_Stocks_With_Cooldown {

    public static void main(String args[]) {
    	
    	//Similiar to Q36 but here we have to cooldown for 1 day
    	// give me total profit
    	// you can buy and sell any number of times.
    	// but the thing is first if you buy the you have to sell then only you are able to buy again.
    	
    	//Note :- cooldown  means if we sell then next day we are not able to buy.
    	//        even we can buy after 1 day.
    	
        int prices[] = {4, 9, 0, 4, 10};

        System.out.println("The maximum profit that can be generated is " + stockProfit01(prices));
        System.out.println("The maximum profit that can be generated is " + stockProfit02(prices));
        System.out.println("The maximum profit that can be generated is " + stockProfit03(prices));
        System.out.println("The maximum profit that can be generated is " + stockProfit04(prices));

    }
    
	// recursion
	static int stockProfit01(int[] arr) {
		return stockProfitUtils01(arr, 0, 1);
	}

	private static int stockProfitUtils01(int[] arr, int ind, int buy) {
		if (ind >= arr.length) {
			return 0;
		}

		if (buy == 1) { // 1 means we can buy the stock
			
			return Math.max(-arr[ind] + stockProfitUtils01(arr, ind + 1, 0), // take :- we buy
					0 + stockProfitUtils01(arr, ind + 1, 1)); // notTake :- we don't buy move to next day
		} else {// 0 means we cann't buy the stock we sell only
			
			return Math.max(arr[ind] + stockProfitUtils01(arr, ind + 2, 1),
					0 + stockProfitUtils01(arr, ind + 1, 0));
		}
	}
	
	// Memoization
	static int stockProfit02(int[] arr) {
		int[][] dp = new int[arr.length][2];

		// Initialize dp array with -1 to mark states as not calculated yet
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return stockProfitUtils02(arr, 0, 1, dp);
	}

	private static int stockProfitUtils02(int[] arr, int ind, int buy, int[][] dp) {
		if (ind >= arr.length) {
			return 0;
		}

		if(dp[ind][buy] != -1) {
			return dp[ind][buy];
		}
		
		if (buy == 1) { // 1 means we can buy the stock
			
			return dp[ind][buy] = Math.max(-arr[ind] + stockProfitUtils02(arr, ind + 1, 0, dp), // take :- we buy
					0 + stockProfitUtils02(arr, ind + 1, 1, dp)); // notTake :- we don't buy move to next day
		} else {// 0 means we cann't buy the stock we sell only
			
			return dp[ind][buy] = Math.max(arr[ind] + stockProfitUtils02(arr, ind + 2, 1, dp),
					0 + stockProfitUtils02(arr, ind + 1, 0, dp));
		}
	}

	// Tabulation
	static int stockProfit03(int[] arr) {
		int n = arr.length;
		int[][] dp = new int[n + 2][2];

		for (int ind = n - 1; ind >= 0; ind--) {
			for (int buy = 0; buy <= 1; buy++) {
				if (buy == 1) { // 1 means we can buy the stock

					dp[ind][buy] = Math.max(-arr[ind] + dp[ind + 1][0], // take :- we buy
							0 + dp[ind + 1][1]); // notTake :- we don't buy move to next day
				} else {// 0 means we cann't buy the stock we sell only

					dp[ind][buy] = Math.max(arr[ind] + dp[ind + 2][1], 0 + dp[ind + 1][0]);
				}
			}
		}

		return dp[0][1];
	}
	
	// Tabulation :- with little optimization
	static int stockProfit04(int[] arr) {
		int n = arr.length;
		int[][] dp = new int[n + 2][2];

		for (int ind = n - 1; ind >= 0; ind--) {
			// 1 means we can buy the stock
			dp[ind][1] = Math.max(-arr[ind] + dp[ind + 1][0], // take :- we buy
					0 + dp[ind + 1][1]); // notTake :- we don't buy move to next day

			// 0 means we cann't buy the stock we sell only
			dp[ind][0] = Math.max(arr[ind] + dp[ind + 2][1], 0 + dp[ind + 1][0]);

		}

		return dp[0][1];
	}
	
}
