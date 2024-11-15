package Arrays._2_Medium;

//blog : https://takeuforward.org/data-structure/set-matrix-zero/
// Question : https://leetcode.com/problems/set-matrix-zeroes/
public class _23_Set_Matrix_Zeros {
	public static void main(String[] args) {
		int[][] matrix1 = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		int n1 = matrix1.length;
		int m1 = matrix1[0].length;

		int[][] ans1 = zeroMatrix(matrix1, n1, m1);

		System.out.println("brute force approach The Final matrix is: ");
		for (int[] row : ans1) {
			for (Integer ele : row) {
				System.out.print(ele + " ");
			}
			System.out.println();
		}

		int[][] matrix2 = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		int n2 = matrix2.length;
		int m2 = matrix2[0].length;

		int[][] ans2 = zeroMatrix2(matrix2, n2, m2);

		System.out.println("Better Approach The Final matrix is: ");
		for (int[] row : ans2) {
			for (Integer ele : row) {
				System.out.print(ele + " ");
			}
			System.out.println();
		}

//		int[][] matrix3 = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		int[][] matrix3 = { { 1, 0, 3 } };
		int n3 = matrix3.length;
		int m3 = matrix3[0].length;

		int[][] ans3 = zeroMatrix3(matrix3, n3, m3);

		System.out.println("Better Approach The Final matrix is: ");
		for (int[] row : ans3) {
			for (Integer ele : row) {
				System.out.print(ele + " ");
			}
			System.out.println();
		}
	}

	// Brute force
	// Time Complexity: O((N*M)*(N + M)) + O(N*M)
	// Space Complexity: O(1)
	private static int[][] zeroMatrix(int[][] matrix, int n, int m) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					setRow(matrix, i);
					setCol(matrix, j);
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == -1) {
					matrix[i][j] = 0;
				}
			}
		}

		return matrix;
	}

	private static void setRow(int[][] matrix, int i) {
		for (int j = 0; j < matrix.length; j++) {
			if (matrix[i][j] != 0) {
				matrix[i][j] = -1;
			}
		}
	}

	private static void setCol(int[][] matrix, int j) {
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][j] != 0) {
				matrix[i][j] = -1;
			}
		}
	}

	// Better approach
	// Time Complexity: O(2*(N*M))
	// Space Complexity: O(N) + O(M)
	private static int[][] zeroMatrix2(int[][] matrix, int n, int m) {

		boolean[] rowArr = new boolean[matrix.length]; // row array
		boolean[] colArr = new boolean[matrix[0].length];// col array

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					rowArr[i] = true;
					colArr[j] = true;
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (rowArr[i] || colArr[j]) {
					matrix[i][j] = 0;
				}
			}
		}

		return matrix;
	}

	// Optimal approach :- this is because of Space
	// Time Complexity: O(2*(N*M))
	// Space Complexity: O(1)
	private static int[][] zeroMatrix3(int[][] matrix, int n, int m) {

		int col0 = 1;

		// Step 1: Traverse the matrix and mark 1st row & col accordingly:
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {

				if (matrix[i][j] == 0) {
					// Mark i-th row:
					matrix[i][0] = 0;

					// Mark j-th column:
					if (j != 0) {
						matrix[0][j] = 0;
					} else {
						col0 = 0;
					}
				}

			}
		}

		// Step 2: Mark with 0 from (1,1) to (n-1, m-1):
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		// Step 3: Finally mark the 1st col & then 1st row:
		if (matrix[0][0] == 0) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[0][j] = 0;
			}
		}

		if (col0 == 0) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}

		return matrix;
	}

}
