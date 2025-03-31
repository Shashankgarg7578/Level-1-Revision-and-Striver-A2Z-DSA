package _07_Stack_and_Queue._03_Monotonic_Stack_Queue_Problems;

import java.util.Stack;

//You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.
//Return the sum of all subarray ranges of nums.

public class _21_Sum_of_subarray_ranges {
	public static void main(String args[]) {
		int arr[] = { 1, 2, 3 };
		System.out.println("Sum Of Subarray Ranges is : " + sumOfSubarrayRanges(arr));
		System.out.println("Sum Of Subarray Minimum is : " + sumOfSubarrayRanges2(arr));

	}

	private static int sumOfSubarrayRanges(int[] arr) {
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			int largest = arr[i];
			int smallest = arr[i];

			for (int j = i + 1; j < arr.length; j++) {
				largest = Math.max(largest, arr[j]);
				smallest = Math.min(smallest, arr[j]);
				sum = (sum + (largest - smallest));
			}
		}

		return sum;
	}

	// Optimal
//Step 1:- find sumOfSubarrayMinimum
//Step 2:- find sumOfSubarrayMaximum
//Step 3:- subtract :- (sumOfSubarrayMaximum - sumOfSubarrayMinimum)
	// TC : O(10N) ~ O(N)
	private static int sumOfSubarrayRanges2(int[] arr) {
		return sumOfSubarrayMaximum(arr) - sumOfSubarrayMinimum(arr);
	}

	// for minimum sum
	private static int sumOfSubarrayMinimum(int[] arr) {
		int mod = (int) (1e9 + 7);

		long total = 0;
		int[] nse = nextSmallerElement(arr);
		int[] psee = previousSmallerElementEqual(arr);

		for (int i = 0; i < arr.length; i++) {
			int left = i - psee[i];
			int right = nse[i] - i;

			// Apply modulo at each step to avoid overflow
			long contribution = (long) arr[i] * left % mod; // First, multiply by left
			contribution = contribution * right % mod; // Then multiply by right
			total = (total + contribution) % mod; // Finally, add to total and apply modulo
		}

		return (int) total;
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

	private static int[] previousSmallerElementEqual(int[] arr) {
		int n = arr.length;
		int[] psee = new int[n];

		Stack<Integer> st = new Stack<Integer>();

		for (int i = 0; i < n; i++) {

			while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
				st.pop();
			}

			if (st.isEmpty()) {
				psee[i] = -1;
			} else {
				psee[i] = st.peek();
			}
			// we are storing indexes only
			st.push(i);
		}

		return psee;
	}

	public static int sumOfSubarrayMaximum(int[] arr) {
		int mod = (int) (1e9 + 7);

		long total = 0;
		int[] nle = nextLargerElement(arr); // Change: Next Larger Element
		int[] ple = previousLargerElementEqual(arr); // Change: Previous Larger Element

		for (int i = 0; i < arr.length; i++) {
			int left = i - ple[i]; // Left distance
			int right = nle[i] - i; // Right distance

			// Apply modulo at each step to avoid overflow
			long contribution = (long) arr[i] * left % mod; // Multiply by left
			contribution = contribution * right % mod; // Then multiply by right
			total = (total + contribution) % mod; // Add to total and apply modulo
		}

		return (int) total;
	}

	// Find Next Larger Element (NLE) for each index
	private static int[] nextLargerElement(int[] arr) {
		int n = arr.length;
		int[] nle = new int[n];

		Stack<Integer> st = new Stack<Integer>();

		for (int i = n - 1; i >= 0; i--) {
			while (!st.isEmpty() && arr[st.peek()] <= arr[i]) { // Changed condition to 'less than or equal'
				st.pop();
			}

			if (st.isEmpty()) {
				nle[i] = n; // No larger element, set to size of array
			} else {
				nle[i] = st.peek(); // Index of next larger element
			}
			st.push(i);
		}

		return nle;
	}

	// Find Previous Larger Element Equal (PLE) for each index
	private static int[] previousLargerElementEqual(int[] arr) {
		int n = arr.length;
		int[] ple = new int[n];

		Stack<Integer> st = new Stack<Integer>();

		for (int i = 0; i < n; i++) {
			while (!st.isEmpty() && arr[st.peek()] < arr[i]) { // Changed condition to 'less than'
				st.pop();
			}

			if (st.isEmpty()) {
				ple[i] = -1; // No larger element, set to -1
			} else {
				ple[i] = st.peek(); // Index of previous larger element
			}
			st.push(i);
		}

		return ple;
	}

}
