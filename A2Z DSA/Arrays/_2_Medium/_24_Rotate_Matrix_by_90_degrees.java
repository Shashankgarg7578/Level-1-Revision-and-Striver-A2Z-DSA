package Arrays._2_Medium;

//blog : https://takeuforward.org/data-structure/rotate-image-by-90-degree/
//Question : https://leetcode.com/problems/rotate-image/
public class _24_Rotate_Matrix_by_90_degrees {
	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int rotated[][] = rotate(arr);
		System.out.println("Rotated Image");
		for (int i = 0; i < rotated.length; i++) {
			for (int j = 0; j < rotated.length; j++) {
				System.out.print(rotated[i][j] + " ");
			}
			System.out.println();
		}

		int arr2[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int rotated2[][] = rotate2(arr2);
		System.out.println("Rotated Image");
		for (int i = 0; i < rotated2.length; i++) {
			for (int j = 0; j < rotated2.length; j++) {
				System.out.print(rotated2[i][j] + " ");
			}
			System.out.println();
		}

	}

	// Brute force
	// Time Complexity: O(N*N)
	// Space Complexity: O(N*N)
	private static int[][] rotate(int[][] arr) {

		int[][] ans = new int[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				ans[j][arr.length - 1 - i] = arr[i][j];
			}
		}

		return ans;
	}

	// Optimal :- because of extra space
	// Time Complexity: O(N*N) + O(N*N)
	// Space Complexity: O(1)
	private static int[][] rotate2(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr[0].length; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}

		for (int row = 0; row < arr.length; row++) {
			reverseRow(arr, row);
		}

		return arr;
	}

	private static void reverseRow(int[][] arr, int row) {
		int i = 0;
		int j = arr[row].length - 1;

		while (i < j) {
			int temp = arr[row][i];
			arr[row][i] = arr[row][j];
			arr[row][j] = temp;

			i++;
			j--;
		}

	}

}
