package _11_Dynamic_Programming._02_1D_DP;

import java.util.Arrays;

public class _03_Frog_Jump {

	public static void main(String args[]) {

//		if frog can jump so we have to reach to end with the min energy

		int height[] = { 30, 10, 60, 10, 60, 50 };
		int n = height.length;

		System.out.println(solveByRecursion(n - 1, height));

		int dp[] = new int[n];
		Arrays.fill(dp, -1);

		System.out.println(solveByDpMemo(n - 1, height, dp));

		Arrays.fill(dp, -1);
		System.out.println(solveByDpTabu(n, height, dp));

		Arrays.fill(dp, -1);
		System.out.println(solveByDpTabuSpaceOpt(n, height, dp));
	}

	// we are now able to solve by Greedy (always take smaller element) 
//	because 30, 10 , 60, 10, 60 , 50

	//do all stuff on index
	//take min form all stuff
	// f(n-1) min energy required to reach n-1 to 0
	
	
	private static int solveByRecursion(int idx, int[] height) {

		if (idx == 0) {
			return 0;
		}

//		              check for index-1 to 0             for index to index-1 cost
		int left = solveByRecursion(idx - 1, height) + Math.abs(height[idx] - height[idx - 1]);

		int right = Integer.MAX_VALUE;
		if (idx > 1) {
//                       check for index-2 to 0             for index to index-2 cost
			right = solveByRecursion(idx - 2, height) + Math.abs(height[idx] - height[idx - 2]);
		}

		return Math.min(left, right);
	}

	// top down :- look at parameter which is changing
	private static int solveByDpMemo(int idx, int[] height, int[] dp) {

		if (idx == 0) {
			return 0;
		}

		if (dp[idx] != -1) {
			return dp[idx];
		}

		int left = solveByDpMemo(idx - 1, height, dp) + Math.abs(height[idx] - height[idx - 1]);

		int right = Integer.MAX_VALUE;
		if (idx > 1) {
			right = solveByDpMemo(idx - 2, height, dp) + Math.abs(height[idx] - height[idx - 2]);
		}

		return dp[idx] = Math.min(left, right);
	}

	// bottom up
	private static int solveByDpTabu(int n, int[] height, int[] dp) {

		dp[0] = 0;

		for (int i = 1; i < n; i++) {

			int jumpOne = dp[i - 1] + Math.abs(height[i] - height[i - 1]);

			int jumpTwo = Integer.MAX_VALUE;
			if (i > 1) {
				jumpTwo = dp[i - 2] + Math.abs(height[i] - height[i - 2]);
			}

			dp[i] = Math.min(jumpOne, jumpTwo);

		}
		return dp[n - 1];
	}

	// bottom up with Space Optimization
	private static int solveByDpTabuSpaceOpt(int n, int[] height, int[] dp) {

		int prev1 = 0;
		int prev2 = 0;
		int curri = 0;

		for (int i = 1; i < n; i++) {

			int jumpOne = prev1 + Math.abs(height[i] - height[i - 1]);

			int jumpTwo = Integer.MAX_VALUE;
			if (i > 1) {
				jumpTwo = prev2 + Math.abs(height[i] - height[i - 2]);
			}

			curri = Math.min(jumpOne, jumpTwo);

			prev2 = prev1;
			prev1 = curri;

		}
		return prev1;
	}
}
