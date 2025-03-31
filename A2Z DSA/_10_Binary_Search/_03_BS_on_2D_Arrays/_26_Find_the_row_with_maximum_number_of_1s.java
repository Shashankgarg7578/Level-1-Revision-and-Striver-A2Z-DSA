package _10_Binary_Search._03_BS_on_2D_Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class _26_Find_the_row_with_maximum_number_of_1s {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
		matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
		matrix.add(new ArrayList<>(Arrays.asList(0, 0, 1)));
		matrix.add(new ArrayList<>(Arrays.asList(0, 0, 0)));

		int n = 3, m = 3;
		System.out.println("The row with the maximum number of 1's is: " + rowWithMax1s(matrix, n, m));

		System.out.println("The row with the maximum number of 1's is: " + rowWithMax1s2(matrix, n, m));

	}

	// Time Complexity: O(n * m)
//	Space Complexity: O(1) 
	private static int rowWithMax1s(ArrayList<ArrayList<Integer>> matrix, int n, int m) {

		int cnt_max = 0;

		int index = -1;

		for (int i = 0; i < n; i++) {
			int cnt_ones = 0;

			for (int j = 0; j < m; j++) {
				cnt_ones += matrix.get(i).get(j);
			}

			if (cnt_ones > cnt_max) {
				cnt_max = cnt_ones;
				index = i;
			}
		}

		return index;
	}

	// Optimal :- Binary Search
//	Time Complexity: O(n X logm)
//	Space Complexity: O(1) 
	private static int rowWithMax1s2(ArrayList<ArrayList<Integer>> matrix, int n, int m) {

		int cnt_max = 0;

		int index = -1;

		for (int i = 0; i < n; i++) {
			int cnt_ones = m - lowerBound(matrix.get(i), m, 1);

			if (cnt_ones > cnt_max) {
				cnt_max = cnt_ones;
				index = i;
			}
		}

		return index;
	}

	public static int lowerBound(ArrayList<Integer> arr, int n, int x) {
		int low = 0, high = n - 1;
		int ans = n;

		while (low <= high) {
			int mid = (low + high) / 2;
			// maybe an answer
			if (arr.get(mid) >= x) {
				ans = mid;
				// look for smaller index on the left
				high = mid - 1;
			} else {
				low = mid + 1; // look on the right
			}
		}
		return ans;
	}

}
