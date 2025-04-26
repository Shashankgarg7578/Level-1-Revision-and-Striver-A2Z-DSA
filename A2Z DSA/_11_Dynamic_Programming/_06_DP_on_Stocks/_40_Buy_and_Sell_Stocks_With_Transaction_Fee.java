package _11_Dynamic_Programming._06_DP_on_Stocks;

public class _40_Buy_and_Sell_Stocks_With_Transaction_Fee {
	public static void main(String args[]) {

		// give me total profit
		// you can buy and sell any number of times.
		// but the thing is first if you buy the you have to sell then only you are able to buy again.

		// Note :- this Q is same as Q36 with infinite transaction.
		//         but here every time we sell we have too give fee

		int prices[] = { 1, 3, 2, 8, 4, 9 };
		int n = prices.length;
		int fee = 2;

		System.out.println("The maximum profit that can be generated is " + getMaximumProfit01(prices, fee, n));
		System.out.println("The maximum profit that can be generated is " + getMaximumProfit05(prices, fee, n));

	}
	
	// Recursion
	// TC :- 2 power n
	// SC :- O(N)
	static long getMaximumProfit01(int[] Arr, int fee, int n) {

		if (n == 0) {
			return 0;
		}

		// Calculate the maximum profit using the recursive function
		// 1 means we can buy
		// 0 means we cann't buy means sell only
		int ans = getMaximumProfitUtil01(Arr, 0, 1, n, fee);

		return ans;
	}

	static int getMaximumProfitUtil01(int[] arr, int ind, int buy, int n, int fee) {

		if (ind == n) {
			return 0;
		}

		int profit = 0;

		if (buy == 1) { // 1 means we can buy the stock
			profit = Math.max(-arr[ind] + getMaximumProfitUtil01(arr, ind + 1, 0, n, fee), // take :- we buy
					0 + getMaximumProfitUtil01(arr, ind + 1, 1, n, fee)); // notTake :- we don't buy move to next day
		} else {// 0 means we cann't buy the stock we sell only
			profit = Math.max(arr[ind] - fee + getMaximumProfitUtil01(arr, ind + 1, 1, n, fee),
					0 + getMaximumProfitUtil01(arr, ind + 1, 0, n, fee));
		}

		return profit;
	}
	
    static int getMaximumProfit05(int[] arr, int fee, int n) {

		if (n == 0) {
			return 0;
		}

//		long[] ahead = new long[2]; // 0th index is aheadNotBuy, 1st index is aheadBuy
//		long[] curr = new long[2];// 0th index is currNotBuy, 1st index is currBuy

		int aheadNotBuy = 0, aheadBuy = 0;
		int currNotBuy = 0, currBuy = 0;

		for (int ind = n - 1; ind >= 0; ind--) {
			currBuy = Math.max(-arr[ind] + aheadNotBuy, // take
					0 + aheadBuy); // notTake

			currNotBuy = Math.max(arr[ind] - fee + aheadBuy, 0 + aheadNotBuy);

			aheadBuy = currBuy;
			aheadNotBuy = currNotBuy;
		}

		return aheadBuy;
	}
}
