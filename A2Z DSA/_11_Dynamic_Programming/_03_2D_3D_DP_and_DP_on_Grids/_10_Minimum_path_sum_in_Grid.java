package _11_Dynamic_Programming._03_2D_3D_DP_and_DP_on_Grids;

public class _10_Minimum_path_sum_in_Grid {
	public static void main(String args[]) {
		// Define the matrix
		int matrix[][] = { { 5, 9, 6 }, 
				           { 11, 5, 2 } };

		int n = matrix.length;
		int m = matrix[0].length;

		// Calculate and print the minimum sum path in the matrix
		System.out.println(minSumPathByRecursion(n - 1, m - 1, matrix));

		int[][] dp = new int[n][m];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = -1;
			}
		}

		System.out.println(minSumPathByDpMemo(n - 1, m - 1, matrix, dp));
		System.out.println(minSumPathByDpTabu(n, m, matrix));
		System.out.println(minSumPathByDpTabuSpaceOpt(n, m, matrix));

	}

	// greedy(take min) not work here :- { { 10, 8, 7 }, { 10, 5, 100 }, { 1, 1, 2 }};
	//  ,so if question not having uniformality then we aren't able to use Greedy

	private static int minSumPathByRecursion(int i, int j, int[][] matrix) {
		if (i == 0 && j == 0) {
			return matrix[i][j];
		}

		if (i < 0 || j < 0) {
			return (int) Math.pow(10, 9);
		}

		int up = matrix[i][j] + minSumPathByRecursion(i - 1, j, matrix);
		int left = matrix[i][j] + minSumPathByRecursion(i, j - 1, matrix);

		return Math.min(up, left);
	}

	private static int minSumPathByDpMemo(int i, int j, int[][] matrix, int[][] dp) {
		if (i < 0 || j < 0) {
			return (int) Math.pow(10, 9);
		}

		if (i == 0 && j == 0) {
			return matrix[i][j];
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		int up = matrix[i][j] + minSumPathByRecursion(i - 1, j, matrix);
		int left = matrix[i][j] + minSumPathByRecursion(i, j - 1, matrix);

		return dp[i][j] = Math.min(up, left);
	}

	private static int minSumPathByDpTabu(int n, int m, int[][] maze) {
		int[][] dp = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (i == 0 && j == 0) {
					dp[i][j] = maze[i][j];
				} else {

					int up = maze[i][j];
					if (i > 0) {
						up += dp[i - 1][j];
					} else {
						up += (int) Math.pow(10, 9);
					}

					int left = maze[i][j];
					if (j > 0) {
						left += dp[i][j - 1];
					} else {
						left += (int) Math.pow(10, 9);
					}

					dp[i][j] = Math.min(up, left);
				}
			}
		}

		return dp[n - 1][m - 1];
	}

	private static int minSumPathByDpTabuSpaceOpt(int n, int m, int[][] maze) {
		int[] prev = new int[m];

		for (int i = 0; i < n; i++) {
			int[] temp = new int[m];
			for (int j = 0; j < m; j++) {

				if (i == 0 && j == 0) {
					temp[j] = maze[i][j];
				} else {

					int up = maze[i][j];
					if (i > 0) {
						up += prev[j];
					} else {
						up += (int) Math.pow(10, 9);
					}

					int left = maze[i][j];
					if (j > 0) {
						left += temp[j - 1];
					} else {
						left += (int) Math.pow(10, 9);
					}

					temp[j] = Math.min(up, left);
				}
			}

			prev = temp;
		}

		return prev[m - 1];
	}

}
