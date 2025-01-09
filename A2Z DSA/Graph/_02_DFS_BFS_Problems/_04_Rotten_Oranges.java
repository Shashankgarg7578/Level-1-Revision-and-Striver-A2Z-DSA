package Graph._02_DFS_BFS_Problems;

import java.util.LinkedList;
import java.util.Queue;

public class _04_Rotten_Oranges {
	public static void main(String args[]) {
		int arr[][] = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		int rotting = orangesRotting(arr);
		System.out.println("Minimum Number of Minutes Required " + rotting);
	}

	static class Pair {
		int row;
		int col;
		int tm;

		public Pair(int row, int col, int tm) {
			this.row = row;
			this.col = col;
			this.tm = tm;
		}

	}

	// BFS level wise traversal
	private static int orangesRotting(int[][] grid) {

		if (grid == null || grid.length == 0) {
			return 0;
		}

		int rows = grid.length;
		int cols = grid[0].length;

		Queue<Pair> queue = new LinkedList<Pair>();

		//for visited nodes
		int[][] vis = new int[rows][cols];
		//count fresh oranges in grid
		int cntFresh = 0;

		//countFrash orange , and also add in queue which have 2 num
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 2) {
					queue.add(new Pair(i, j, 0));
					vis[i][j] = 2;
				} else {
					vis[i][j] = 0;
				}

				if (grid[i][j] == 1) {
					cntFresh++;
				}
			}
		}

		int tm = 0; // total minutes
		int cnt = 0; // count total visited oranges
		// for traverse in 4 directions (up, right, down, left)
		int[] drow = { -1, 0, 1, 0 }; 
		int[] dcol = { 0, 1, 0, -1 };
		while (!queue.isEmpty()) {
			int r = queue.peek().row;
			int c = queue.peek().col;
			int t = queue.peek().tm;

			// take only max
			tm = Math.max(tm, t);
			queue.poll();

			//loop for 4 directions
			for (int i = 0; i < 4; i++) {
				//first calculate which direction
				int nrow = r + drow[i];
				int ncol = c + dcol[i];

				if (nrow >= 0 && ncol >= 0 && nrow < rows && ncol < cols && vis[nrow][ncol] == 0
						&& grid[nrow][ncol] == 1) {
					queue.add(new Pair(nrow, ncol, t + 1));
					vis[nrow][ncol] = 2;
					cnt++;
				}

			}
		}

		//because in some case not all 1's are changed
		if (cnt != cntFresh)
			return -1;

		return tm;
	}
}
