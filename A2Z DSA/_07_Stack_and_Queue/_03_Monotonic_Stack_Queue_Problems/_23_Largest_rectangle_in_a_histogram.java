package _07_Stack_and_Queue._03_Monotonic_Stack_Queue_Problems;

import java.util.Stack;

public class _23_Largest_rectangle_in_a_histogram {
	public static void main(String args[]) {
//		int arr[] = { 2, 1, 5, 6, 2, 3, 1 };

		int arr[] = { 2, 1, 5, 6, 2, 3 };
		int n = 6;
		System.out.println("The largest area in the histogram is " + largestarea(arr, n)); // Printing the largest
		System.out.println("The largest area in the histogram is " + largestarea2(arr, n)); // Printing the largest
		// rectangle area

	}

	// Brute force
	// TC : O(4N)
	// Sc: O(2N) + O(2N)
	private static int largestarea(int[] arr, int n) {

		int[] nse = nextSmallerElement(arr);
		int[] pse = previousSmallerElements(arr);

		int maxArea = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			int tempData = arr[i] * (nse[i] - pse[i] - 1);
			maxArea = Math.max(maxArea, tempData);
		}

		return maxArea;
	}

	private static int[] previousSmallerElements(int[] arr) {
		int n = arr.length;
		int[] pse = new int[n];

		Stack<Integer> st = new Stack<Integer>();

		for (int i = 0; i < n; i++) {

			while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
				st.pop();
			}

			if (st.isEmpty()) {
				pse[i] = -1;
			} else {
				pse[i] = st.peek();
			}

			// we are storing indexes only
			st.push(i);
		}

		return pse;
	}

	private static int[] nextSmallerElement(int[] arr) {
		int n = arr.length;
		int[] nse = new int[n];

		Stack<Integer> st = new Stack<Integer>();

		for (int i = n - 1; i >= 0; i--) {

			while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
				st.pop();
			}

			if (st.isEmpty()) {
				nse[i] = n;
			} else {
				nse[i] = st.peek();
			}
			
			// we are storing indexes only
			st.push(i);
		}

		return nse;
	}

	// Optimal
	private static int largestarea2(int[] arr, int n) {

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
