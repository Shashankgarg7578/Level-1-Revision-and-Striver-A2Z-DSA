package _01_Arrays._2_Medium;

//blog : https://takeuforward.org/data-structure/stock-buy-and-sell/
//Question : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class _19_Stock_Buy_and_Sell {
	public static void main(String[] args) {
		int arr[] = { 7, 1, 5, 3, 6, 4 };
		int maxPro = maxProfit(arr);
		System.out.println("Max profit is: " + maxPro);

		int maxPro2 = maxProfit2(arr);
		System.out.println("Max profit is: " + maxPro2);

	}

	// Brute force
//	Time complexity: O(n^2)
//	Space Complexity: O(1)
	private static int maxProfit(int[] arr) {

		int maxProfit = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					maxProfit = Math.max(maxProfit, arr[j] - arr[i]);
				}
			}
		}
		return maxProfit;
	}

	// Optimal
//	Time complexity: O(n)
//	Space Complexity: O(1)
	private static int maxProfit2(int[] arr) {

		int maxProfit = 0;
		int minVal = arr[0];

		for (int i = 0; i < arr.length; i++) {

			maxProfit = Math.max(maxProfit, arr[i] - minVal);

			minVal = Math.min(minVal, arr[i]);

		}
		return maxProfit;
	}

}
