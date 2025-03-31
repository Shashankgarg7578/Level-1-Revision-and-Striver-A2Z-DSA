package _10_Binary_Search._03_BS_on_2D_Arrays;

public class _27_Search_in_a_2_D_matrix {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		boolean result = searchMatrix(matrix, 8);
		System.out.println(result ? "true" : "false");

		boolean result2 = searchMatrix2(matrix, 8);
		System.out.println(result2 ? "true" : "false");

		boolean result3 = searchMatrix3(matrix, 8);
		System.out.println(result3 ? "true" : "false");

	}

	// Brute force
	// Time Complexity: O(N * M)
//	Space Complexity: O(1)
	private static boolean searchMatrix(int[][] matrix, int target) {

		int n = matrix.length;
		int m = matrix[0].length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == target)
					return true;
			}
		}
		return false;
	}

	// Better
//	Time Complexity: O(N + logM)
//	Space Complexity: O(1)
	private static boolean searchMatrix2(int[][] matrix, int target) {

		int n = matrix.length;
		int m = matrix[0].length;

		for (int i = 0; i < n; i++) {

			if (matrix[i][0] <= target && matrix[i][m - 1] >= target) {
				return binarySearch(matrix[i], target);
			}
		}
		return false;
	}

	private static boolean binarySearch(int[] matrix, int target) {

		int low = 0;

		int high = matrix.length - 1;

		while (low <= high) {
			int mid = low + high;

			if (matrix[mid] == target) {
				return true;
			} else if (target > matrix[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}

		}

		return false;
	}

	// Optimal :- Binary Search with little maths
	private static boolean searchMatrix3(int[][] matrix, int target) {

		int n = matrix.length;
		int m = matrix[0].length;

		int low = 0;
		int high = n * m - 1;// it is converted in a 1d matrix

		while (low <= high) {

			int mid = (low + high) / 2;

			int row = mid / m; // convert single array index to 2d array
			int col = mid % m;

			if (matrix[row][col] == target) {
				return true;
			} else if (matrix[row][col] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}

		}

		return false;
	}

}
