package _07_Stack_and_Queue._03_Monotonic_Stack_Queue_Problems;

import java.util.Arrays;
import java.util.Stack;

public class _16_Next_Greater_Element_2 {
	public static void main(String args[]) {

		// this is circular element
		int arr[] = { 2, 10, 12, 1, 11 };
		int arr2[] = nextGreaterElements2(arr);
		System.out.println("The next greater elements are ");
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		
		System.out.println();
		
		// this is circular element
		int arr3[] = { 2, 10, 12, 1, 11 };
		int arr4[] = nextGreaterElements3(arr3);
		System.out.println("The next greater elements are ");
		for (int i = 0; i < arr4.length; i++) {
			System.out.print(arr4[i] + " ");
		}
		
	}

	// TC: N^2
	// SC: O(N)
	private static int[] nextGreaterElements2(int[] arr) {
		int n = arr.length;
		int[] nge = new int[n];

		Arrays.fill(nge, -1);
		
		for (int i = 0; i < n; i++) {

			// we think array is double means we again copy same array then we will solve
			for (int j = i + 1; j <= i + n - 1; j++) {

				int ind = j % n;

				if (arr[ind] > arr[i]) {
					nge[i] = arr[ind];
					break;
				}

			}
		}

		return nge;
	}

	// double the array and mentioned index for dry run
	// given array size n :- { 2, 10, 12, 1, 11 }
	// new array size 2*n-1 :- { 2, 10, 12, 1, 11, 2, 10, 12, 1, 11 }
	
	private static int[] nextGreaterElements3(int[] arr) {
		int n = arr.length;
		int[] nge = new int[n];

		Stack<Integer> st = new Stack<Integer>();
		for (int i = 2 * n - 1; i >= 0; i--) {

			while (!st.isEmpty() && st.peek() <= arr[i % n]) {
				st.pop();
			}

			if (i < n) {
				if (st.isEmpty()) {
					nge[i] = -1;
				} else {
					nge[i] = st.peek();
				}
			}
			st.push(arr[i%n]);
		}

		return nge;
	}

}
