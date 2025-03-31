package _07_Stack_and_Queue._4_Implementation_Problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class _27_Sliding_Window_maximum {
	public static void main(String args[]) {
		int i, k = 3;
		int arr[] = { 4, 0, -1, 3, 5, 3, 6, 8 };
		ArrayList<Integer> ans;
		ans = maxSlidingWindow(arr, k);
		System.out.println("Maximum element in every " + k + " window ");
		for (i = 0; i < ans.size(); i++)
			System.out.print(ans.get(i) + "  ");

		System.out.println();

		int[] ans2 = maxSlidingWindow2(arr, k);
		for (i = 0; i < ans2.length; i++)
			System.out.print(ans2[i] + "  ");

	}

	// brute force
	// TC : O(N-K) * k
	// SC : O(N-K)
	private static ArrayList<Integer> maxSlidingWindow(int[] arr, int k) {

		ArrayList<Integer> ans = new ArrayList<Integer>();

		for (int i = 0; i <= arr.length - k; i++) {

			int maxi = arr[i];
			for (int j = i; j < i + k; j++) {
				maxi = Math.max(maxi, arr[j]);
			}
			ans.add(maxi);
		}

		return ans;
	}

	private static int[] maxSlidingWindow2(int[] arr, int k) {

		int n = arr.length;
		int[] ans = new int[n - k + 1];
		int ri = 0;

		// store index
		Deque<Integer> q = new ArrayDeque<Integer>();

		for (int i = 0; i < arr.length; i++) {
			// remove numbers out of range of k index
			if (!q.isEmpty() && q.peekFirst() <= i - k) {
				q.removeFirst();
			}

			// remove smaller elements in k range
			while (!q.isEmpty() && arr[q.peekLast()] <= arr[i]) {
				q.removeLast();
			}

			q.addLast(i);

			if (i >= k - 1) {
				ans[ri] = arr[q.peekFirst()];
				ri++;
			}

		}

		return ans;
	}

}
