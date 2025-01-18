package _05_Graph._02_DFS_BFS_Problems;

import java.util.LinkedList;
import java.util.Queue;

public class _13_Number_of_Distinct_Islands_dfs_multisource {
	public static void main(String[] args) {
		char[][] grid = { { '0', '1', '1', '1', '0', '0', '0' }, 
				          { '0', '0', '1', '1', '0', '1', '0' } };

		System.out.println(numIslands(grid));
	}

	private static int numIslands(char[][] grid) {

		int n = grid.length;
		int m = grid[0].length;

		int[][] vis = new int[n][m];

		int cnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (vis[i][j] == 0) {
					cnt++;
					bfs(i, j, vis, grid);
				}
			}
		}

		return cnt;
	}

	//bfs traversal you can do with DFS traversal as well.
	private static void bfs(int i, int j, int[][] vis, char[][] grid) {

		int n = grid.length;
		int m = grid[0].length;

		Queue<Pair03> q = new LinkedList<Pair03>();
		vis[i][j] = 1;
		q.add(new Pair03(i, j));

		while (!q.isEmpty()) {
			int row = q.peek().first;
			int col = q.peek().second;

			q.remove();

			//for 8 directions
			for (int delrow = -1; delrow <= 1; delrow++) {
				for (int delcol = -1; delcol <= 1; delcol++) {

					int nrow = row + delrow;
					int ncol = col + delcol;

					if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && grid[i][j] == '1' && vis[nrow][ncol] == 0) {
						vis[nrow][ncol] = 1;
						q.add(new Pair03(nrow, ncol));
					}

				}
			}
		}

	}

}

class Pair03 {
	int first;
	int second;

	Pair03(int first, int second) {
		this.first = first;
		this.second = second;
	}
}
