package _07_Stack_and_Queue._4_Implementation_Problems;

public class _28_The_Celebrity_Problem {

	// every row is called a person and we have to return that person
	// who doesn't know anyone but all theres know him
	public static void main(String[] args) {
		int[][] matrix = { { 0, 1, 1, 0 }, 
				           { 0, 0, 0, 0 }, 
				           { 0, 1, 0, 0 }, 
				           { 1, 1, 0, 0 } };

		System.out.println(celebrityProblem(matrix));
		System.out.println(celebrityProblem2(matrix));

	}

	// Brute force
	// TC : O(N*N) + O(N)
	// SC : O(2N)
	private static int celebrityProblem(int[][] matrix) {

		int n = matrix.length;

		int[] knowMe = new int[n];
		int[] iKnow = new int[n];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 1) {
					knowMe[j]++;
					iKnow[i]++;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (knowMe[i] == n - 1 && iKnow[i] == 0) {
				return i;
			}
		}

		return -1;
	}

	// Optimal with 2 pointers on rows
	//TC: O(2N)
	//SC : O(1)
	private static int celebrityProblem2(int[][] matrix) {
		int n = matrix.length;

		int top = 0;
		int down = n - 1;

		while (top < down) {

			if (matrix[top][down] == 1) {
				top = top + 1;
			} else if (matrix[down][top] == 1) {
				down = down - 1;
			} else {
				top++;
				down--;
			}
		}

		// if it exceed means we don't have celebrity
		if (top < down) {
			return -1;
		}

		top = down;

		// for again check celebrity is correct, so we check row and col for
//		that celebrity
		for (int i = 0; i < matrix.length; i++) {
			if (i == top) {
				// this is for diagonal because it always 0.
				continue;
			}
			if (matrix[top][i] == 0 && matrix[i][top] == 1) {

			} else {
				return -1;
			}
		}

		return top;
	}

}
