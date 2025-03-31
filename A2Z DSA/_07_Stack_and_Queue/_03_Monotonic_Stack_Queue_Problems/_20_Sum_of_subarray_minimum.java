package _07_Stack_and_Queue._03_Monotonic_Stack_Queue_Problems;

import java.util.Stack;


public class _20_Sum_of_subarray_minimum {
	public static void main(String args[]) {
		int arr[] = { 3, 1, 2, 4 };
		System.out.println("Sum Of Subarray Minimum is : " + sumOfSubarrayMinimum(arr));
		System.out.println("Sum Of Subarray Minimum is : " + sumOfSubarrayMinimum2(arr));

	}
	
	//generate all subarray and from every subarray pick smallest element 
    //and take in sum

	// Brute force
	// TC: N^2
	private static int sumOfSubarrayMinimum(int[] arr) {

		int mod = (int) (1e9 + 7);
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			int min = arr[i];

			for (int j = i; j < arr.length; j++) {
				min = Math.min(min, arr[j]);
				sum = (sum + min) % mod;
			}
		}

		return sum;
	}

	// watch video if dont know the how we drive
	// Optimal
    // dry run for 3 in given array :- 1, 4, 6, 7, 3, 7, 8, 1
	   
	private static int sumOfSubarrayMinimum2(int[] arr) {
		int mod = (int) (1e9 + 7);
		
		long total = 0;
		//this both stored indexes
		int[] nse = nextSmallerElement(arr);
		int[] psee = previousSmallerElementEqual(arr);

		for(int i = 0; i< arr.length;i++) {
			int left = i - psee[i];
			int right = nse[i] - i;
			
			// Apply modulo at each step to avoid overflow
            long contribution = (long) arr[i] * left % mod;  // First, multiply by left
            contribution = contribution * right % mod;       // Then multiply by right
            total = (total + contribution) % mod;              // Finally, add to total and apply modulo
		}
		
		return (int)total;
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

}
