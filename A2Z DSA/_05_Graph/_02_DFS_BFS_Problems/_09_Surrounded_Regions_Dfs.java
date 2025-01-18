package _05_Graph._02_DFS_BFS_Problems;

//same as Q08:- 0/1 matrix but for better understanding we are solving through dfs
public class _09_Surrounded_Regions_Dfs {
	public static void main(String[] args) {
		char mat[][] = { { 'X', 'X', 'X', 'X' }, 
				         { 'X', 'O', 'X', 'X' }, 
				         { 'X', 'O', 'O', 'X' }, 
				         { 'X', 'O', 'X', 'X' },
				         { 'X', 'X', 'O', 'O' } };

		// n = 5, m = 4
		char[][] ans = fill(mat.length, mat[0].length, mat);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static char[][] fill(int row, int col, char[][] mat) {
		int n = mat.length;
		int m = mat[0].length;

		// for traverse in 4 directions (up, right, down, left)
		int[] drow = { -1, 0, 1, 0 };
		int[] dcol = { 0, 1, 0, -1 };

		int[][] vis = new int[n][m];

		// traverse first row and last row
		for (int j = 0; j < m; j++) {
			// for first row
			if (vis[0][j] == 0 && mat[0][j] == 'O') {
				dfs(0, j, vis, mat, drow, dcol);
			}
			// for Last row
			if (vis[n - 1][j] == 0 && mat[n - 1][j] == 'O') {
				dfs(n - 1, j, vis, mat, drow, dcol);
			}
		}

		// traverse first Col and last Col
		for (int i = 0; i < n; i++) {
			// for first Col
			if (vis[i][0] == 0 && mat[i][0] == 'O') {
				dfs(i, 0, vis, mat, drow, dcol);
			}
			// for Last Col
			if (vis[i][m - 1] == 0 && mat[i][m - 1] == 'O') {
				dfs(i, m - 1, vis, mat, drow, dcol);
			}
		}

		// put ans in same matrix
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (vis[i][j] == 0 && mat[i][j] == 'O') {
					mat[i][j] = 'X';
				}
			}
		}

		return mat;
	}

	private static void dfs(int i, int j, int[][] vis, char[][] mat, int[] drow, int[] dcol) {

		vis[i][j] = 1;

		int n = mat.length;
		int m = mat[0].length;

		for (int dir = 0; dir < 4; dir++) {
			int nrow = i + drow[dir];
			int ncol = j + dcol[dir];

			if (nrow >= 0 && nrow < n && ncol >= 0  && ncol < m && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 'O') {
				dfs(nrow, ncol, vis, mat, drow, dcol);
			}

		}

	}
}
