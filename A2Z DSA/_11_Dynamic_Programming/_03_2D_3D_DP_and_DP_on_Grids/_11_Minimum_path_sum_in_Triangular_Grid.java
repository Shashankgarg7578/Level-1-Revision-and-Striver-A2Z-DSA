package _11_Dynamic_Programming._03_2D_3D_DP_and_DP_on_Grids;

//here we start variable starting point and variable ending points on grid
//this question having variable ending points

public class _11_Minimum_path_sum_in_Triangular_Grid {
	public static void main(String args[]) {
		int triangle[][] = { { 1 }, { 2, 3 }, { 3, 6, 7 }, { 8, 9, 6, 10 } };

		int n = triangle.length;

		// Call the minimumPathSum function and print the result
		System.out.println(minimumPathSumByRecursion(0, 0, triangle, n));

		int[][] dp = new int[n][n];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = -1;
			}
		}

		System.out.println(minimumPathSumByDpMemo(0, 0, triangle, n, dp));

		System.out.println(minimumPathSumByDpTabu(triangle, n));
		System.out.println(minimumPathSumByDpTabuSpaceOpt(triangle, n));

	}
	//this Q not having uniformality so we are not able to use Greedy

	// it goes form 0 to n-1 , in previous question we go in reverse 0 to n-1
	private static int minimumPathSumByRecursion(int i, int j, int[][] triangle, int n) {

		if (i == n - 1) {
			return triangle[i][j];
		}

		int down = triangle[i][j] + minimumPathSumByRecursion(i + 1, j, triangle, n);
		int diagonal = triangle[i][j] + minimumPathSumByRecursion(i + 1, j + 1, triangle, n);

		return Math.min(down, diagonal);
	}

	// it goes form 0 to n-1 , in previous question we go in reverse
	private static int minimumPathSumByDpMemo(int i, int j, int[][] triangle, int n, int[][] dp) {

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		if (i == n - 1) {
			return triangle[i][j];
		}

		int down = triangle[i][j] + minimumPathSumByDpMemo(i + 1, j, triangle, n, dp);
		int diagonal = triangle[i][j] + minimumPathSumByDpMemo(i + 1, j + 1, triangle, n, dp);

		return dp[i][j] = Math.min(down, diagonal);
	}

	// it goes form n-1 to 0 because it is reverse from recursion, in previous
	// question we go in reverse
	private static int minimumPathSumByDpTabu(int[][] triangle, int n) {

		int[][] dp = new int[n][n];

		// copy last row because that is base case
		for (int j = 0; j < n; j++) {
			dp[n - 1][j] = triangle[n - 1][j];
		}

		for (int i = n - 2; i >= 0; i--) {

			for (int j = i; j >= 0; j--) {

				int down = triangle[i][j] + dp[i + 1][j];
				int diagonal = triangle[i][j] + dp[i + 1][j + 1];

				dp[i][j] = Math.min(down, diagonal);
			}
		}

		return dp[0][0];
	}

	// it goes form n-1 to 0 because it is reverse from recursion, in previous
	// question we go in reverse
	private static int minimumPathSumByDpTabuSpaceOpt(int[][] triangle, int n) {

		int[] front = new int[n];

		// copy last row because that is base case
		for (int j = 0; j < n; j++) {
			front[j] = triangle[n - 1][j];
		}

		for (int i = n - 2; i >= 0; i--) {
			int[] crr = new int[n];
			for (int j = i; j >= 0; j--) {

				int down = triangle[i][j] + front[j];
				int diagonal = triangle[i][j] + front[j + 1];

				crr[j] = Math.min(down, diagonal);
			}
			front = crr;
		}

		return front[0];
	}

}
