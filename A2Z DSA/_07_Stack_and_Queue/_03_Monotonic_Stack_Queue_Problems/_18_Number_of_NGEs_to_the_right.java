package _07_Stack_and_Queue._03_Monotonic_Stack_Queue_Problems;

import java.util.Arrays;
import java.util.Stack;

public class _18_Number_of_NGEs_to_the_right {
	// Function to count elements greater than arr[indices[i]] to the right using a
	// stack
	public static int[] countGreaterElements(int[] arr, int[] indices) {
		int n = arr.length;
		int[] result = new int[n]; // This will hold the count of greater elements to the right for each index
		Arrays.fill(result, 0); // Initialize with 0

		// Stack to hold indices of elements in decreasing order
		Stack<Integer> stack = new Stack<>();

		// Traverse the array from right to left
		for (int i = n - 1; i >= 0; i--) {
			// Count how many elements in the stack are greater than arr[i]
			while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
				stack.pop(); // Pop elements that are less than or equal to arr[i]
			}
			// The remaining elements in the stack are greater than arr[i]
			result[i] = stack.size();

			// Push the current index onto the stack
			stack.push(i);
		}

		// Prepare the final result array based on the queries
		int[] output = new int[indices.length];
		for (int i = 0; i < indices.length; i++) {
			output[i] = result[indices[i]];
		}

		return output;
	}

	//find number of greater elements to the query index in array
	public static void main(String[] args) {
		// Test example 1
		int[] arr1 = { 3, 4, 2, 7, 5, 8, 10, 6 };
		int[] queries1 = { 0, 5 };
		int[] result1 = countGreaterElements(arr1, queries1);
		System.out.print("Output: ");
		for (int res : result1) {
			System.out.print(res + " ");
		}
		System.out.println();

		// Test example 2
		int[] arr2 = { 1, 2, 3, 4, 1 };
		int[] queries2 = { 0, 3 };
		int[] result2 = countGreaterElements(arr2, queries2);
		System.out.print("Output: ");
		for (int res : result2) {
			System.out.print(res + " ");
		}
	}
}
