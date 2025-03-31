package _11_Dynamic_Programming._02_1D_DP;

public class _02_Climbing_Stars {
	public static void main(String args[]) {

		int n = 3;

		System.out.println("Recursion = " + fR(n));
		System.out.println("Tabulation = " + climbStairs(n));
	}

	// Same as fibonacci
	// Recursion
	private static int fR(int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;

		int left = fR(n - 1);
		int right = fR(n - 2);
		return left + right;
	}

	
	// Tabulation(Bottom Up)
	public static int climbStairs(int n) {

		if (n == 0) {
			return 1;
		}

		int[] dp = new int[n + 1];
		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			if (i == 1) {
				dp[i] = dp[i - 1];
			} else {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
		}

		return dp[n];
	}

}
