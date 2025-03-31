package _11_Dynamic_Programming._03_2D_3D_DP_and_DP_on_Grids;

public class _08_Grid_Unique_Paths_DP_on_Grids {
	public static void main(String[] args) {
		int m = 3; // row
		int n = 2; // col

		// Call the countWays function and print the result
		System.out.println(countWaysByRecursion(m - 1, n - 1));

		int dp[][] = new int[m][n];

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = -1;
			}
		}

		System.out.println(countWaysByDpMemo(m - 1, n - 1, dp));
		System.out.println(countWaysByDpTabu(m, n, dp));
		System.out.println(countWaysByDpTabuSpaceOpt(m, n));

	}

	//Top Down
	private static int countWaysByRecursion(int m, int n) {
		if (m == 0 && n == 0) {
			return 1;
		}
		if (m < 0 || n < 0) {
			return 0;
		}

		int up = countWaysByRecursion(m - 1, n); // Up
		int left = countWaysByRecursion(m, n - 1);// left

		return up + left;
	}

	// top down
	private static int countWaysByDpMemo(int i, int j, int[][] dp) {
		if (i == 0 && j == 0) {
			return 1;
		}
		if (i < 0 || j < 0) {
			return 0;
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		int up = countWaysByDpMemo(i - 1, j, dp);
		int left = countWaysByDpMemo(i, j - 1, dp);

		return dp[i][j] = up + left;
	}

	// bottom up
	private static int countWaysByDpTabu(int m, int n, int[][] dp) {

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = 1;
					continue;
				}

				int up = 0, left = 0;

				if (i > 0) {
					up = dp[i - 1][j];
				}
				if (j > 0) {
					left = dp[i][j - 1];
				}

				dp[i][j] = up + left;
			}
		}

		return dp[m - 1][n - 1];
	}

	// if there is previous row or col then we can Space Optimize
	private static int countWaysByDpTabuSpaceOpt(int m, int n) {

		int[] prev = new int[n];

		for (int i = 0; i < prev.length; i++) {
			prev[i] = 0;
		}

		for (int i = 0; i < m; i++) {

			int[] temp = new int[n];

			for (int j = 0; j < n; j++) {

				// base case
				if (i == 0 && j == 0) {
					temp[j] = 1;
					continue;
				}

				int up = 0, left = 0;

				if (i > 0) {
					up = prev[j];
				}
				if (j > 0) {
					left = temp[j - 1];
				}

				temp[j] = up + left;
			}

			prev = temp;
		}

		return prev[n - 1];
	}

}
