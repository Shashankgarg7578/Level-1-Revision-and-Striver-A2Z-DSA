package _11_Dynamic_Programming._03_2D_3D_DP_and_DP_on_Grids;

import java.util.Arrays;

//variable star and variable end here 

public class _12_Minimum_Maximum_Falling_Path_Sum {
	public static void main(String args[]) {
		int matrix[][] = { { 1  , 2, 10, 4 }, 
				           { 100, 3, 2 , 1 }, 
				           { 1  , 1, 20, 2 }, 
				           { 1  , 2, 2 , 1 } };

		// Call the getMaxPathSum function and print the result
		System.out.println(getMaxPathSumByRecursion(matrix));

		System.out.println(getMaxPathSumByDpMemo(matrix));

		System.out.println(getMaxPathSumByDpTabu(matrix));

	}

	// n-1 to 0 , this is reverse of previous Question
	private static int getMaxPathSumByRecursion(int[][] matrix) {

		int n = matrix.length;
		int m = matrix[0].length;

		int maxi = Integer.MIN_VALUE;

		for (int j = 0; j < m; j++) {
			int ans = getMaxUtilRecusrionHelper(n - 1, j, m, matrix);
			maxi = Math.max(maxi, ans);
		}

		return maxi;
	}

	private static int getMaxUtilRecusrionHelper(int i, int j, int m, int[][] matrix) {

		if (j < 0 || j >= m) {
			return (int) Math.pow(-10, 9);
		}

		if (i == 0) {
			return matrix[i][j];
		}

		int up = matrix[i][j] + getMaxUtilRecusrionHelper(i - 1, j, m, matrix);
		int leftDiagonal = matrix[i][j] + getMaxUtilRecusrionHelper(i - 1, j - 1, m, matrix);
		int rightDiagonal = matrix[i][j] + getMaxUtilRecusrionHelper(i - 1, j + 1, m, matrix);

		return Math.max(up, Math.max(leftDiagonal, rightDiagonal));
	}

	// n-1 to 0 , this is reverse of previous Question
	private static int getMaxPathSumByDpMemo(int[][] matrix) {

		int n = matrix.length;
		int m = matrix[0].length;

		int[][] dp = new int[n][m];
		for (int row[] : dp) {
			Arrays.fill(row, -1);
		}

		int maxi = Integer.MIN_VALUE;

		for (int j = 0; j < m; j++) {
			int ans = getMaxPathSumByDpMemoHelper(n - 1, j, m, matrix, dp);
			maxi = Math.max(maxi, ans);
		}

		return maxi;
	}

	private static int getMaxPathSumByDpMemoHelper(int i, int j, int m, int[][] matrix, int[][] dp) {

		if (j < 0 || j >= m) {
			return (int) Math.pow(-10, 9);
		}

		if (i == 0) {
			return matrix[i][j];
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		int up = matrix[i][j] + getMaxPathSumByDpMemoHelper(i - 1, j, m, matrix, dp);
		int leftDiagonal = matrix[i][j] + getMaxPathSumByDpMemoHelper(i - 1, j - 1, m, matrix, dp);
		int rightDiagonal = matrix[i][j] + getMaxPathSumByDpMemoHelper(i - 1, j + 1, m, matrix, dp);

		return dp[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
	}

	// n-1 to 0 , this is reverse of previous Question
	private static int getMaxPathSumByDpTabu(int[][] matrix) {

		int n = matrix.length;
		int m = matrix[0].length;

		int[][] dp = new int[n][m];

		// copy first row
		for (int j = 0; j < m; j++) {
			dp[0][j] = matrix[0][j];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int up = matrix[i][j] + dp[i - 1][j];

				int leftDiagonal = matrix[i][j];
				if (j - 1 >= 0) {
					leftDiagonal += dp[i - 1][j - 1];
				} else {
					leftDiagonal += (int) Math.pow(-10, 9);
				}

				int rightDiagonal = matrix[i][j];
				if (j + 1 < m) {
					rightDiagonal += dp[i - 1][j + 1];
				} else {
					rightDiagonal += (int) Math.pow(-10, 9);
				}

				dp[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
			}
		}

		int maxi = Integer.MIN_VALUE;
		for (int j = 0; j < m; j++) {
			maxi = Math.max(maxi, dp[n - 1][j]);
		}

		return maxi;
	}

}
