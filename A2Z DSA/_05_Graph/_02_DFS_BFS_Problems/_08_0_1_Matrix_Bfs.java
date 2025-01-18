package _05_Graph._02_DFS_BFS_Problems;

import java.util.LinkedList;
import java.util.Queue;

public class _08_0_1_Matrix_Bfs {
	public static void main(String[] args) {
//		int[][] grid = { { 0, 1, 1, 0 }, 
//				         { 1, 1, 0, 0 }, 
//				         { 0, 0, 1, 1 } };
		int[][] grid = {{0,0,0},
				        {0,1,0},
				        {0,0,0}};
		int[][] ans = nearest(grid);
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[i].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}

	//Time Complexity: O(NxM + NxMx4) ~ O(N x M)
	//Space Complexity: O(N x M) + O(N x M) + O(N x M) ~ O(N x M)
	private static int[][] nearest(int[][] grid) {

		int n = grid.length;
		int m = grid[0].length;

		int[][] vis = new int[n][m];
		int[][] dist = new int[n][m];

		Queue<Node01> q = new LinkedList<Node01>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					q.add(new Node01(i, j, 0));
					vis[i][j] = 1;
				} else {
					vis[i][j] = 0;
				}
			}
		}

		// for traverse in 4 directions (up, right, down, left)
		int[] drow = { -1, 0, 1, 0 };
		int[] dcol = { 0, 1, 0, -1 };

		while (!q.isEmpty()) {
			int row = q.peek().first;
			int col = q.peek().second;
			int dis = q.peek().third;
			q.remove();
			dist[row][col] = dis;

			for (int i = 0; i < 4; i++) {
				int nrow = row + drow[i];
				int ncol = col + dcol[i];

				if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && vis[nrow][ncol] == 0) {
					vis[nrow][ncol] = 1;
					q.add(new Node01(nrow, ncol, dis + 1));
				}
			}
		}

		return dist;
	}

}

class Node01 {
	int first; // row index
	int second;// col index
	int third; // dist

	Node01(int first, int second, int third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}

}