package _11_Dynamic_Programming._04_DP_on_Subsequences;

public class _16_Partition_Set_Into_2Subsets_With_Min_Absolute_Sum_Diff {

	// in this Question we have to use Q14 because here we have to tell the
	// minimum absolute difference between 2 subsets of array
	// so for this question we will use tabulation form of Q14

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		int n = arr.length;

		// Calculate and print the minimum absolute difference
		System.out.println("The minimum absolute difference is: " + minSubsetSumDifference(arr, n));
	}

	private static int minSubsetSumDifference(int[] arr, int n) {

		int totSum = 0;

		for (int i = 0; i < n; i++) {
			totSum += arr[i];
		}

		boolean[][] dp = new boolean[n][totSum + 1];

		// same code as Q14 tabulation
		for (int i = 0; i < n; i++) {
			dp[i][0] = true;
		}

		if (arr[0] <= totSum) {
			dp[0][totSum] = true;
		}

		for (int ind = 1; ind < n; ind++) {
			for (int target = 1; target <= totSum; target++) {

				boolean notTaken = dp[ind - 1][target];
				boolean taken = false;

				if (arr[ind] <= target) {
					taken = dp[ind - 1][target - arr[ind]];
				}

				dp[ind][target] = notTaken | taken;

			}
		}

		// new code
		int mini = Integer.MAX_VALUE;

		for (int s1 = 0; s1 <= totSum; s1++) {
			if (dp[n - 1][s1]) {

				int s2 = totSum - s1;
				int diff = Math.abs(s1 - s2);

				mini = Math.min(mini, diff);

			}
		}

		return mini;
	}

}
