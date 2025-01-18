package _05_Graph._02_DFS_BFS_Problems;

public class _05_Flood_fill {
	public static void main(String[] args) {
		int[][] image = { { 1, 1, 1 }, 
				          { 1, 1, 0 }, 
				          { 1, 0, 1 } };

		// sr = 1, sc = 1, newColor = 2
		int[][] ans = floodFill(image, 1, 1, 2);
		
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[i].length; j++)
				System.out.print(ans[i][j] + " ");
			System.out.println();
		}
	}

	// Same as Q4_RottenOranges but now we solve by DFS, you can solve by BFS as well.
	private static int[][] floodFill(int[][] image, int sr, int sc, int newColour) {

		int iniColor = image[sr][sc];
		int[][] ans = image;

		int[] delRow = { -1, 0, 1, 0 };
		int[] delCol = { 0, 1, 0, -1 };

		dfs(sr, sc, image, ans, newColour, delRow, delCol, iniColor);

		return ans;
	}

	private static void dfs(int sr, int sc, int[][] image, int[][] ans, int newColour, int[] delRow, int[] delCol,
			int iniColor) {

		// fill new color first
		ans[sr][sc] = newColour;

		int n = image.length;
		int m = image[0].length;

		// for traverse in 4 directions (up, right, down, left)
		for (int i = 0; i < 4; i++) {
			int nRow = sr + delRow[i];
			int nCol = sc + delCol[i];

			if (nRow >= 0 && nCol >= 0 && nRow < n && nCol < m && image[nRow][nCol] == iniColor
					&& ans[nRow][nCol] != newColour) {
				dfs(nRow, nCol, image, ans, newColour, delRow, delCol, iniColor);
			}

		}
	}
}
