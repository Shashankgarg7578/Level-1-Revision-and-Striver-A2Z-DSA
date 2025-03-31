package _11_Dynamic_Programming._01_Introduction_to_DP;

import java.util.Arrays;

public class _01_fibonacci_number {
	public static void main(String args[]) {

		int n = 697;

		// Step1 :- declare always n+1 array.
		int dp[] = new int[n + 1];
		Arrays.fill(dp, -1);
		System.out.println("Memoization = " + fM(n, dp));
		System.out.println("Tabulation = " + fT(n, dp));
		System.out.println("Tabulation Space Optimization = " + fTS(n));
	}

	// Memoization(Top Down)
//	Step 1 :- make DP[] array for remember the sub-problem answers.
//	Step 2 :- check if curr sub problem is already solve with DP[] array before recursion call.
	// Time Complexity: O(N)
	// Space Complexity: O(N)
	private static int fM(int n, int[] dp) {
		if (n <= 1) {
			return n;
		}

		if (dp[n] != -1) {
			return dp[n];
		}

		return dp[n] = fM(n - 1, dp) + fM(n - 2, dp);
	}

	// Tabulation (Bottom Up)
//	Step 1 :- make DP[] array for remember the sub-problem answers.
//	Step 2 :- convert base case to fill the base cases in DP array	
//	Step 3 :- change recursion calls with DP array, so that we can get value from DP array
	// Time Complexity:
	// Space Complexity:
	private static int fT(int n, int[] dp) {
		if (n <= 1) {
			return n;
		}

		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n];
	}

	// Space Optimization from Tabulation
//	Step 1 :- make DP[] array for remember the sub-problem answers.
//	Step 2 :- fill the base cases in DP array	
//	Step 3 :- change recursion calls with DP array, so that we can get value from DP array
	// Time Complexity:
	// Space Complexity:
	private static int fTS(int n) {

		if (n <= 1) {
			return n;
		}

		int prev2 = 0;
		int prev1 = 1;

		int curri = 0;

		for (int i = 2; i <= n; i++) {
			curri = prev1 + prev2;

			prev2 = prev1;
			prev1 = curri;
		}

		return curri;
	}

}
