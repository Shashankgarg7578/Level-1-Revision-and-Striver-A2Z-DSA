package _11_Dynamic_Programming._02_1D_DP;

import java.util.Arrays;

public class _04_Frog_Jump_with_k_distances {
	public static void main(String args[]) {
		int height[] = { 30, 10, 60, 10, 60, 50 };
		int n = height.length;
		int k = 2;

		int[] dp = new int[n];
		Arrays.fill(dp, -1); // Initialize a memoization array to store calculated results
		System.out.println(solveByDpMemo(n - 1, height, dp, k)); // Print the result of the solve function

		Arrays.fill(dp, -1);
		System.out.println(solveByDpTabu(n, height, dp, k));
	}

	private static int solveByDpMemo(int idx, int[] height, int[] dp, int k) {
		if (idx == 0) {
			return 0;
		}
		if (dp[idx] != -1) {
			return dp[idx];
		}

		int mmSteps = Integer.MAX_VALUE;

		for (int j = 1; j <= k; j++) {
			if (idx - j >= 0) {
				int jump = solveByDpMemo(idx - j, height, dp, k) + Math.abs(height[idx] - height[idx - j]);
				mmSteps = Math.min(mmSteps, jump);
			}
		}

		return dp[idx] = mmSteps;
	}

	private static int solveByDpTabu(int n, int[] height, int[] dp, int k) {

		dp[0] = 0;

		for (int i = 1; i < n; i++) {
			int mmSteps = Integer.MAX_VALUE;
			for (int j = 1; j <= k; j++) {

				if (i - j >= 0) {
					int jumpOne = dp[i - j] + Math.abs(height[i] - height[i - j]);
					mmSteps = Math.min(mmSteps, jumpOne);
				}
			}

			dp[i] = mmSteps;

		}
		return dp[n - 1];
	}

}
