package _11_Dynamic_Programming._02_1D_DP;

import java.util.Arrays;

public class _05_Maximum_sum_of_non_adjacent_elements {
	public static void main(String args[]) {
		// Input array with elements.
		int arr[] = { 2, 1, 4, 9 };

		// Get the length of the array.
		int n = arr.length;

		// Print the result.
		System.out.println(solveByRecursion(n - 1, arr));

		int[] dp = new int[n];
		Arrays.fill(dp, -1);
		System.out.println(solveByDpMemo(n - 1, arr, dp));

		Arrays.fill(dp, -1);
		System.out.println(solveByDpTabu(n, arr, dp));
		
		System.out.println(solveByDpTabuSpaceOpt(n, arr));
	}

	private static int solveByRecursion(int idx, int[] arr) {
		if (idx == 0) {
			return arr[idx];
		}
		if (idx < 0) {
			return 0;
		}

		int pick = arr[idx] + solveByRecursion(idx - 2, arr);
		int notPick = 0 + solveByRecursion(idx - 1, arr);

		return Math.max(pick, notPick);
	}

	private static int solveByDpMemo(int idx, int[] arr, int[] dp) {
		if (idx == 0) {
			return arr[idx];
		}
		if (idx < 0) {
			return 0;
		}

		if (dp[idx] != -1) {
			return dp[idx];
		}

		int pick = arr[idx] + solveByRecursion(idx - 2, arr);
		int notPick = 0 + solveByRecursion(idx - 1, arr);

		return dp[idx] = Math.max(pick, notPick);
	}

	private static int solveByDpTabu(int n, int[] arr, int[] dp) {
		dp[0] = arr[0];

		for (int i = 1; i < n; i++) {
			int pick = arr[i];

			//because everytime jump is greater then 1.
			if (i > 1) {
				pick += dp[i - 2];
			}

			int notPick = 0 + dp[i - 1];

			dp[i] = Math.max(pick, notPick);
		}

		return dp[n - 1];
	}

	private static int solveByDpTabuSpaceOpt(int n, int[] arr) {
		int prev1 = arr[0];
		int prev2 = 0;
		int curri = 0;

		for (int i = 1; i < n; i++) {
			int pick = arr[i];

			if (i > 1) {
				pick += prev2;
			}

			int notPick = 0 + prev1;

			curri = Math.max(pick, notPick);
			prev2 = prev1;
			prev1 = curri;
		}

		return prev1;
	}

}
