package _11_Dynamic_Programming._07_DP_on_LIS;

import java.util.Arrays;

public class _47_Number_of_Longest_Increasing_Subsequences {

	public static void main(String args[]) {

		// In this we have to tell the numbers of longest increasing subsequence
		// for example :- {1, 3, 5, 4, 7}
		// LIS :- {1, 3, 4, 7} , {1, 3, 5, 7}
		// ANS :- 2 means we have 2 same longest length subsequence

		int[] arr = { 1, 5, 4, 3, 2, 6, 7, 2 };

		System.out.println("The count of LIS is " + findNumberOfLIS(arr));

	}

	private static int findNumberOfLIS(int[] nums) {

		int n = nums.length;

		int[] dp = new int[n]; // for longest subsequence for each index
		int[] cnt = new int[n];// number of longest subsequence for each index

		// Initially all indexes have 1 longest subsequence and 1 cnt.
		Arrays.fill(dp, 1);
		Arrays.fill(cnt, 1);

		int maxi = 1;

		for (int i = 0; i < n; i++) {
			for (int prevInd = 0; prevInd <= i - 1; prevInd++) {
				if (nums[prevInd] < nums[i] && dp[prevInd] + 1 > dp[i]) {
					dp[i] = dp[prevInd] + 1;
					cnt[i] = cnt[prevInd];
				} else if (nums[prevInd] < nums[i] && dp[prevInd] + 1 == dp[i]) {
					cnt[i] = cnt[i] + cnt[prevInd];
				}
			}
			maxi = Math.max(maxi, dp[i]);
		}

		// Now find number of longest subsequence length
		int nos = 0;
		for (int i = 0; i <= n - 1; i++) {
			if (dp[i] == maxi)
				nos += cnt[i];
		}

		return nos;
	}

}
