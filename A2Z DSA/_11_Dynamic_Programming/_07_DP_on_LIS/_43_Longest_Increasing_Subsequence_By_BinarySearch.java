package _11_Dynamic_Programming._07_DP_on_LIS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _43_Longest_Increasing_Subsequence_By_BinarySearch {
	public static void main(String[] args) {

		// We use Binary Search to find the position to update in the list.
		// For example: {1, 7, 8, 4, 5, 6, -1, 9}
		// Possible increasing subsequences:
		//   - {1, 7, 8, 9}
		//   - {1, 4, 5, 6, 9}
		//   - {-1, 9}
		// Longest length = 5

		// Instead of storing all subsequences, we maintain one list.
		// Using Binary Search, we replace the element with the just-greater value (ceil).

		// This list may not represent a valid subsequence,
		// but its size gives the correct length of the Longest Increasing Subsequence (LIS).

		// Step 1: For each arr[i],
        //		   use Binary Search to find the index of the smallest number >= arr[i]
        //         If not found, append arr[i] to the list.
		
		int[] arr = { 10, 9, 2, 5, 3, 7, 101, 18 };
		int n = arr.length;

		System.out.println("The length of the longest increasing subsequence is " + longestIncreasingSubsequence(arr, n));
	}

	//Time Complexity: O(N*logN)
	//Space Complexity: O(N)
	private static int longestIncreasingSubsequence(int[] arr, int n) {

		List<Integer> temp = new ArrayList<Integer>();
		temp.add(arr[0]);

		int len = 1;

		for (int i = 1; i < n; i++) {

			if (arr[i] > temp.get(temp.size() - 1)) {
				// arr[i] > the last element of temp array
				temp.add(arr[i]);
				len++;
			} else {
				// Replacement step
				int ind = Collections.binarySearch(temp, arr[i]);
				if (ind < 0) {
					ind = -ind - 1;
				}

				temp.set(ind, arr[i]);
			}

		}

		return len;
	}
}
