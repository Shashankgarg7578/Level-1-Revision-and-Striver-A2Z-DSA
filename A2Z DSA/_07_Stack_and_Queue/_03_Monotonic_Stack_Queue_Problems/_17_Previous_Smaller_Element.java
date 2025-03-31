package _07_Stack_and_Queue._03_Monotonic_Stack_Queue_Problems;

import java.util.Stack;

public class _17_Previous_Smaller_Element {

	public static void main(String[] args) {
		int arr[] = { 4, 5, 2, 10, 8 };

		int arr2[] = previousSmallerElements(arr);
		System.out.println("The next greater elements are ");
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
	}

	//TC: 2N
	//SC: O(N) + O(N)
	private static int[] previousSmallerElements(int[] arr) {
		int n = arr.length;
		int[] pse = new int[n];

		Stack<Integer> st = new Stack<Integer>();

		for (int i = 0; i < n; i++) {

			while (!st.isEmpty() && st.peek() >= arr[i]) {
				st.pop();
			}

			if (st.isEmpty()) {
				pse[i] = -1;
			} else {
				pse[i] = st.peek();
			}

			st.push(arr[i]);

		}

		return pse;
	}

}
