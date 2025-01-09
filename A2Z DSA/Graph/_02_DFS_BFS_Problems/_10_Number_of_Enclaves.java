package Graph._02_DFS_BFS_Problems;

import java.util.LinkedList;
import java.util.Queue;

public class _10_Number_of_Enclaves {
	// same as previous but here we are solving through BFS
	public static void main(String[] args) {
		int grid[][] = { { 0, 0, 0, 0 }, 
				         { 1, 0, 1, 0 }, 
				         { 0, 1, 1, 0 }, 
				         { 0, 0, 0, 0 } };

		int ans = numberOfEnclaves(grid);
		System.out.println(ans);
	}

	private static int numberOfEnclaves(int[][] grid) {

		int n = grid.length;
		int m = grid[0].length;

		int[][] vis = new int[n][m];

		Queue<Pair> q = new LinkedList<Pair>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// for add only border elements
				if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {

					if (grid[i][j] == 1) {
						q.add(new Pair(i, j));
						vis[i][j] = 1;
					}
				}
			}
		}

		// for traverse in 4 directions (up, right, down, left)
		int[] drow = { -1, 0, 1, 0 };
		int[] dcol = { 0, 1, 0, -1 };

		while (!q.isEmpty()) {
			int row = q.peek().first;
			int col = q.peek().second;
			q.remove();

			for (int i = 0; i < 4; i++) {
				int nrow = row + drow[i];
				int ncol = col + dcol[i];

				if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m 
						&& grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
					vis[nrow][ncol] = 1;
					q.add(new Pair(nrow, ncol));
				}

			}

		}

		// count unvisited land which are not changed
		int countLands = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (vis[i][j] == 0 && grid[i][j] == 1) {
					countLands++;
				}
			}
		}

		return countLands;
	}
}

class Pair {
	int first; // row index
	int second;// col index

	Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
}
