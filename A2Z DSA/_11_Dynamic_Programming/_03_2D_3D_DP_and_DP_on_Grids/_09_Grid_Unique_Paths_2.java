package _11_Dynamic_Programming._03_2D_3D_DP_and_DP_on_Grids;

public class _09_Grid_Unique_Paths_2 {
	public static void main(String args[]) {
		// Define the maze, same as previous just having -1 here.
		int[][] maze = { { 0,  0, 0 }, 
				         { 0, -1, 0 }, 
				         { 0,  0, 0 } };

		int n = maze.length;
		int m = maze[0].length;

		// Calculate and print the number of paths through the maze
		System.out.println(mazeObstaclesByRecursion(n - 1, m - 1, maze));

		int[][] dp = new int[m][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dp[i][j] = -1;
			}
		}

		System.out.println(mazeObstaclesByDpMemo(n - 1, m - 1, maze, dp));

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dp[i][j] = -1;
			}
		}

		System.out.println(mazeObstaclesByDpTabu(n, m, maze, dp));
		System.out.println(countWaysByDpTabuSpaceOpt(n, m, maze));


	}

	private static int mazeObstaclesByRecursion(int i, int j, int[][] maze) {

		if (i >= 0 && j >= 0 && maze[i][j] != 0) {
			return 0;
		}

		if (i == 0 && j == 0) {
			return 1;
		}

		if (i < 0 || j < 0) {
			return 0;
		}

		int left = mazeObstaclesByRecursion(i - 1, j, maze);
		int right = mazeObstaclesByRecursion(i, j - 1, maze);

		return left + right;
	}

	private static int mazeObstaclesByDpMemo(int i, int j, int[][] maze, int[][] dp) {

		if (i >= 0 && j >= 0 && maze[i][j] != 0) {
			return 0;
		}

		if (i == 0 && j == 0) {
			return 1;
		}
		if (i < 0 || j < 0) {
			return 0;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		int left = mazeObstaclesByDpMemo(i - 1, j, maze, dp);
		int right = mazeObstaclesByDpMemo(i, j - 1, maze, dp);

		return dp[i][j] = left + right;
	}

	private static int mazeObstaclesByDpTabu(int n, int m, int[][] maze, int[][] dp) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (i >= 0 && j >= 0 && maze[i][j] != 0) {
					dp[i][j] = 0;
				} else if (i == 0 && j == 0) {
					dp[i][j] = 1;
				} else {

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
		}

		return dp[n - 1][m - 1];
	}

	// if there is previous row or col then we can Space Optimize
	private static int countWaysByDpTabuSpaceOpt(int m, int n, int[][] maze) {

		int[] prev = new int[n];

		for (int i = 0; i < prev.length; i++) {
			prev[i] = 0;
		}

		for (int i = 0; i < m; i++) {

			int[] temp = new int[n];

			for (int j = 0; j < n; j++) {

				if (i >= 0 && j >= 0 && maze[i][j] != 0) {
					temp[j] = 0;
					continue;
				}

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
