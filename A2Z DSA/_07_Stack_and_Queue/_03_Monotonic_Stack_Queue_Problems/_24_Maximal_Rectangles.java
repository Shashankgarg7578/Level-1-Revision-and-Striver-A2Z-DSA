package _07_Stack_and_Queue._03_Monotonic_Stack_Queue_Problems;

import java.util.Stack;

public class _24_Maximal_Rectangles {
	
	//maximum rectangle which can be form in below matrix
	public static void main(String[] args) {
		char[][] matrix = {{'1','0','1','0','0'},
				           {'1','0','1','1','1'},
				           {'1','1','1','1','1'},
				           {'1','0','0','1','0'}};
		
		System.out.println(maximalRectangle(matrix));
		
	}

	public static int maximalRectangle(char[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		int[][] preSum = new int[n][m];

		for (int j = 0; j < m; j++) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				 // Correct comparison to '1' instead of 0.
                if (matrix[i][j] == '1') {
                    sum += 1; // Convert '1' to 1 and add to sum.
                } else {
                    sum = 0; // Reset if we encounter a '0'.
                }
				preSum[i][j] = sum;
			}
		}

		int maxRect = 0;

		for (int i = 0; i < n; i++) {
			maxRect = Math.max(maxRect, largestarea(preSum[i], preSum[i].length));
		}

		return maxRect;
	}

	private static int largestarea(int[] arr, int n) {

		Stack<Integer> st = new Stack<Integer>();

		int maxArea = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {

			while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
				int nse = i;
				int element = arr[st.pop()];
				int pse = st.isEmpty() ? -1 : st.peek();

				maxArea = Math.max(maxArea, element * (nse - pse - 1));
			}

			st.push(i);
		}

		while (!st.isEmpty()) {
			int nse = arr.length;
			int element = arr[st.pop()];
			int pse = st.isEmpty() ? -1 : st.peek();

			maxArea = Math.max(maxArea, element * (nse - pse - 1));

		}

		return maxArea;
	}

}
