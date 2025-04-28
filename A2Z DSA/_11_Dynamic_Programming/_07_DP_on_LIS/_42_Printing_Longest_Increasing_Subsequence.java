package _11_Dynamic_Programming._07_DP_on_LIS;

import java.util.ArrayList;
import java.util.Arrays;

public class _42_Printing_Longest_Increasing_Subsequence {
	public static void main(String args[]) {

		// this question is extension of previous question 
		// also here we are doing with another approach.

		int arr[] = { 10, 9, 2, 5, 3, 7, 101, 18 };

		int n = arr.length;

		System.out.println("The length of the longest increasing subsequence is " + longestIncreasingSubsequence(arr, n));

		System.out.println("The length of the longest increasing subsequence is " + longestIncreasingSubsequence02(arr, n));

	}

	// Space Optimized
//	Time Complexity: O(N*N)
//	Space Complexity: O(N)
	private static int longestIncreasingSubsequence(int[] arr, int n) {

		int dp[] = new int[n];
		Arrays.fill(dp, 1);

		int maxi = 1; // we are taking 1 because for all index atleast 1 longest is possible.

		for (int i = 0; i < n; i++) {
			for (int prev = 0; prev < i; prev++) {
				if (arr[prev] < arr[i]) {
					dp[i] = Math.max(dp[i], 1 + dp[prev]);
				}
			}
			maxi = Math.max(maxi, dp[i]);
		}

		return maxi;
	}

	//
	// Space Optimized :- print subsequence too
//	Time Complexity: O(N*N)
//	Space Complexity: O(N)
	private static int longestIncreasingSubsequence02(int[] arr, int n) {

		int dp[] = new int[n];
		Arrays.fill(dp, 1);

		int hash[] = new int[n];
		Arrays.fill(hash, 1);

		int maxi = 1; // we are taking 1 because for all index atleast 1 longest is possible.
		int lastIndex = 0;
		for (int i = 0; i < n; i++) {
			hash[i] = i;
			for (int prev = 0; prev < i; prev++) {

				if (arr[prev] < arr[i] && 1 + dp[prev] > dp[i]) {

					dp[i] = 1 + dp[prev];
					hash[i] = prev;

				}

			}
			if (dp[i] > maxi) {
				maxi = dp[i];
				lastIndex = i;
			}
		}

		
		//Backtrack and find the ans
		ArrayList<Integer> temp = new ArrayList<>();

		temp.add(arr[lastIndex]);

		while (hash[lastIndex] != lastIndex) {
			lastIndex = hash[lastIndex];
			temp.add(arr[lastIndex]);
		}

		// reverse the array

		System.out.print("The subsequence elements are ");

		for (int i = temp.size() - 1; i >= 0; i--) {
			System.out.print(temp.get(i) + " ");
		}
		System.out.println();

		return maxi;
	}

}
