package _07_Stack_and_Queue._03_Monotonic_Stack_Queue_Problems;

import java.util.Stack;

public class _15_Next_Greater_Element {
	public static void main(String args[]) {
		int arr[] = { 5, 7, 1, 2, 6, 0 };

		int arr2[] = nextGreaterElements(arr);
		System.out.println("The next greater elements are ");
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}

	}

//	Time Complexity: O(2N)
//	Space Complexity: O(N) + O(N)
	private static int[] nextGreaterElements(int[] arr) {
		int n = arr.length;

		int nge[] = new int[n];

		Stack<Integer> st = new Stack<Integer>();

		for (int i = n - 1; i >= 0; i--) {

			while (!st.isEmpty() && st.peek() < arr[i]) {
				st.pop();
			}

			if (st.isEmpty()) {
				nge[i] = -1;
			} else {
				nge[i] = st.peek();
			}

			st.push(arr[i]);
		}

		return nge;
	}
}
