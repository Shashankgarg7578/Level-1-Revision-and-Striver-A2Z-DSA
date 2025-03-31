package _10_Binary_Search._03_BS_on_2D_Arrays;

//https://leetcode.com/problems/search-a-2d-matrix-ii/description/
public class _28_Search_in_a_row_and_column_wise_sorted_matrix {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 4, 7, 11, 15 }, 
				           { 2, 5, 8, 12, 19 }, 
				           { 3, 6, 9, 16, 22 }, 
				           { 10, 13, 14, 17, 24 },
				           { 18, 21, 23, 26, 30 } };

		int[] result = searchElement(matrix, 8);
		System.out.println(result[0] + " " + result[1]);

		int[] result2 = searchElement2(matrix, 8);
		System.out.println(result2[0] + " " + result2[1]);
		
		int[] result3 = searchElement3(matrix, 8);
		System.out.println(result3[0] + " " + result3[1]);
		
	}

	private static int[] searchElement(int[][] matrix, int target) {
		int n = matrix.length;
		int m = matrix[0].length;

		// traverse the matrix:
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == target)
					return new int[] { i, j };
			}
		}

		return new int[] { -1, -1 };
	}
	
	// Better
//		Time Complexity: O(N + logM)
//		Space Complexity: O(1)
	private static int[] searchElement2(int[][] matrix, int target) {

		int n = matrix.length;

		int ind = -1;
		
		for (int i = 0; i < n; i++) {
			ind = binarySearch(matrix[i], target);
			
			if (ind != -1) {
				return new int[]{i,ind};
			}
		}
		return new int[]{-1,-1};
	}

	private static int binarySearch(int[] matrix, int target) {

		int low = 0;

		int high = matrix.length - 1;

		while (low <= high) {
			int mid = low + high;

			if (matrix[mid] == target) {
				return mid; // true
			} else if (target > matrix[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}

		}

		return -1; // false
	}

//	Time Complexity: O(N+M)
	private static int[] searchElement3(int[][] matrix, int target) {

		int n = matrix.length;
		int m = matrix[0].length;

		int row = 0;
		int col = m - 1;

		while (row < n && col >= 0) {

			if (matrix[row][col] == target) {
				return new int[] { row, col }; // true
			} else if (matrix[row][col] < target) {
				row++;
			} else {
				col--;
			}

		}

		return new int[] { -1, -1 }; // false
	}

}
