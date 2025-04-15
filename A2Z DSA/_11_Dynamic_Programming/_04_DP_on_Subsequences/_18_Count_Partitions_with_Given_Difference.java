package _11_Dynamic_Programming._04_DP_on_Subsequences;

import java.util.Arrays;
import java.util.List;

// we have to find how many subsets we have which have (s1 - s2 = D) and it follows (S1 > S2)

// S1 = totalSum - S2

// totalSum - S2 - S2 = D //put s1 value in 1st equation
// totalSum - D = 2 * S2
// S2 = (totalSum - D) / 2  //it is same Q. 17

public class _18_Count_Partitions_with_Given_Difference {

	public static void main(String[] args) {

//		countPartitions(mod, mod, null);
	}

	private static int countPartitions(int n, int d, int[] arr) {

		int totSum = 0;

		for (int it : arr) {
			totSum += it;
		}

		// this is for negative check and odd value check
		if (totSum - d < 0 || (totSum - d) % 2 == 1) {
			return 0; // mean false
		}

		return findWays5(arr, (totSum - d) / 2);
	}

	// it is from Q. 17
	private static int findWays5(int[] arr, int target) {

		int n = arr.length;

		int dp[][] = new int[n][target + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return findWaysUtil5(arr, n - 1, target, dp);
	}

	static int mod = (int) 1e9;

	private static int findWaysUtil5(int[] arr, int idx, int target, int dp[][]) {

		if (idx == 0) {
			if (target == 0 && arr[0] == 0)
				return 2;
			if (target == 0 || arr[0] == target)
				return 1;
			return 0;
		}

		if (dp[idx][target] != -1) {
			return dp[idx][target];
		}

		int notTake = findWaysUtil5(arr, idx - 1, target, dp);

		int take = 0;
		if (arr[idx] <= target) {
			take = findWaysUtil5(arr, idx - 1, target - arr[idx], dp);
		}

		return dp[idx][target] = (take + notTake) % mod;

	}

}
