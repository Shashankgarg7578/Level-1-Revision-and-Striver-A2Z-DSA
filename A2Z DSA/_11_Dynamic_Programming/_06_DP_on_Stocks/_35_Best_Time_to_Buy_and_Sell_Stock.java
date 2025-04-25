package _11_Dynamic_Programming._06_DP_on_Stocks;

public class _35_Best_Time_to_Buy_and_Sell_Stock {

	// give the max result if we buy then sell only 1 time.
	// only thing is we have to buy from previous days of sell...

	public static void main(String args[]) {

		int[] Arr = { 7, 1, 5, 3, 6, 4 };

		System.out.println("The maximum profit by selling the stock is " + maximumProfit(Arr));
	}

	// Time Complexity: O(N)
	// Space Complexity: O(1)
	private static int maximumProfit(int[] arr) {

		int maxProfit = 0;

		int mini = arr[0];

		for (int i = 1; i < arr.length; i++) {
			int currProfit = arr[i] - mini;

			maxProfit = Math.max(maxProfit, currProfit);

			mini = Math.min(mini, arr[i]);

		}

		return maxProfit;
	}

}
