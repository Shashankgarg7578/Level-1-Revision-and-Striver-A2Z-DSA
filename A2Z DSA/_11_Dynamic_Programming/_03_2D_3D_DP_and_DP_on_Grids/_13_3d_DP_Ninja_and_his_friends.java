package _11_Dynamic_Programming._03_2D_3D_DP_and_DP_on_Grids;

import java.util.Arrays;

//This Question related to 3d DP which is slightly different from previous problems ,here we have fixed start but variable end,
//also if both ninja choose same column at same time then count that column only once.
public class _13_3d_DP_Ninja_and_his_friends {
	public static void main(String args[]) {
		int matrix[][] = { { 2, 3, 1, 2 }, { 3, 4, 2, 2 }, { 5, 6, 3, 5 } };
		int n = matrix.length;
		int m = matrix[0].length;

		// Call the maximumChocolates function and print the result
		System.out.println(maximumChocolates1(n, m, matrix));

		System.out.println(maximumChocolates2(n, m, matrix));

		System.out.println(maximumChocolates3(n, m, matrix));

	}

	// Brute Force
	private static int maximumChocolates1(int n, int m, int[][] matrix) {
		return maxChocoUtil1(0, 0, m - 1, n, m, matrix);
	}

	// Function to find the maximum number of chocolates using dynamic programming
	static int maxChocoUtil1(int i, int j1, int j2, int n, int m, int[][] matrix) {

		if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) {
			return (int) (Math.pow(-10, 9));
		}

		if (i == n - 1) {
			if (j1 == j2) {
				return matrix[i][j1];
			} else {
				return matrix[i][j1] + matrix[i][j2];
			}
		}

		int maxi = Integer.MIN_VALUE;

		for (int di = -1; di <= 1; di++) {
			for (int dj = -1; dj <= 1; dj++) {

				int ans;

				if (j1 == j2) {
					ans = matrix[i][j1] + maxChocoUtil1(i + 1, j1 + di, j2 + dj, n, m, matrix);
				} else {
					ans = matrix[i][j1] + matrix[i][j2] + maxChocoUtil1(i + 1, j1 + di, j2 + dj, n, m, matrix);
				}

				maxi = Math.max(maxi, ans);
			}
		}

		return maxi;
	}

	// Better by Memoization
	private static int maximumChocolates2(int n, int m, int[][] matrix) {

		int[][][] dp = new int[n][m][m];

		for (int[][] row1 : dp) {
			for (int[] row2 : row1) {
				Arrays.fill(row2, -1);
			}
		}

		return maxChocoUtil2(0, 0, m - 1, n, m, matrix, dp);
	}

	// Function to find the maximum number of chocolates using dynamic programming
	static int maxChocoUtil2(int i, int j1, int j2, int n, int m, int[][] matrix, int[][][] dp) {

		if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) {
			return (int) (Math.pow(-10, 9));
		}

		if (i == n - 1) {
			if (j1 == j2) {
				return matrix[i][j1];
			} else {
				return matrix[i][j1] + matrix[i][j2];
			}
		}

		if (dp[i][j1][j2] != -1) {
			return dp[i][j1][j2];
		}

		int maxi = Integer.MIN_VALUE;

		for (int di = -1; di <= 1; di++) {
			for (int dj = -1; dj <= 1; dj++) {

				int ans;

				if (j1 == j2) {
					ans = matrix[i][j1] + maxChocoUtil2(i + 1, j1 + di, j2 + dj, n, m, matrix, dp);
				} else {
					ans = matrix[i][j1] + matrix[i][j2] + maxChocoUtil2(i + 1, j1 + di, j2 + dj, n, m, matrix, dp);
				}

				maxi = Math.max(maxi, ans);
			}
		}

		return dp[i][j1][j2] = maxi;
	}

	// Optimal by Tabulation
	private static int maximumChocolates3(int n, int m, int[][] matrix) {

		int[][][] dp = new int[n][m][m];

		// Base case for last row because last row is variable
		for (int j1 = 0; j1 < m; j1++) {
			for (int j2 = 0; j2 < m; j2++) {
				if (j1 == j2) {
					dp[n - 1][j1][j2] = matrix[n - 1][j1];
				} else {
					dp[n - 1][j1][j2] = matrix[n - 1][j1] + matrix[n - 1][j2];
				}
			}
		}

		for (int i = n - 2; i >= 0; i--) {
			for (int j1 = 0; j1 < m; j1++) {
				for (int j2 = 0; j2 < m; j2++) {
					int maxi = Integer.MIN_VALUE;

					for (int di = -1; di <= 1; di++) {
						for (int dj = -1; dj <= 1; dj++) {
							int ans;

							if (j1 == j2) {
								ans = matrix[i][j1];
							} else {
								ans = matrix[i][j1] + matrix[i][j2];
								;
							}

							if ((j1 + di < 0 || j1 + di >= m) || (j2 + dj < 0 || j2 + dj >= m)) {
								ans += (int) Math.pow(-10, 9);
							} else {
								ans += dp[i + 1][j1 + di][j2 + dj];
							}

							maxi = Math.max(maxi, ans);

						}
					}

					dp[i][j1][j2] = maxi;

				}
			}
		}

		return dp[0][0][m - 1];
	}

}
