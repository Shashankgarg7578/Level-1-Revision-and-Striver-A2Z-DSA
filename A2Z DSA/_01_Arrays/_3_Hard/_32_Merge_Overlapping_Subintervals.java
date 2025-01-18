package _01_Arrays._3_Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//blog : https://takeuforward.org/data-structure/merge-overlapping-sub-intervals/
//Question : https://leetcode.com/problems/merge-intervals/
public class _32_Merge_Overlapping_Subintervals {
	public static void main(String[] args) {
		int[][] arr = { { 1, 3 }, { 2, 6 }, { 8, 9 }, { 9, 11 }, { 8, 10 }, { 2, 4 }, { 15, 18 }, { 16, 17 } };
		List<List<Integer>> ans = mergeOverlappingIntervals(arr);
		System.out.print("The merged intervals are: \n");
		for (List<Integer> it : ans) {
			System.out.print("[" + it.get(0) + ", " + it.get(1) + "] ");
		}
		System.out.println();

		int[][] arr2 = { { 1, 3 }, { 2, 6 }, { 8, 9 }, { 9, 11 }, { 8, 10 }, { 2, 4 }, { 15, 18 }, { 16, 17 } };
		List<List<Integer>> ans2 = mergeOverlappingIntervals2(arr2);
		System.out.print("The merged intervals are: \n");
		for (List<Integer> it : ans2) {
			System.out.print("[" + it.get(0) + ", " + it.get(1) + "] ");
		}
		System.out.println();
	}

	// Brute force
	// Time Complexity: O(N*logN) + O(2*N)
	// Space Complexity: O(N)
	private static List<List<Integer>> mergeOverlappingIntervals(int[][] arr) {
		// sort the given intervals:
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});
//		[[1, 3], [2, 6], [2, 4], [8, 9], [8, 10], [9, 11], [15, 18], [16, 17]]
		int n = arr.length;

		List<List<Integer>> ans = new ArrayList<List<Integer>>();

		for (int i = 0; i < n; i++) {
			int start = arr[i][0];
			int end = arr[i][1];

			// Skip all the merged intervals:
			if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {
				continue;
			}

			for (int j = i + 1; j < n; j++) {
				if (arr[j][0] <= end) {
					end = Math.max(end, arr[j][1]);
				} else {
					break;
				}
			}

			ans.add(Arrays.asList(start, end));
		}

		return ans;
	}

	//Optimal Approach
	//Time Complexity: O(N*logN) + O(N)
	//Space Complexity: O(N)
	private static List<List<Integer>> mergeOverlappingIntervals2(int[][] arr) {
		// sort the given intervals:
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});

		List<List<Integer>> ans = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {

			// if the current interval does not
			// lie in the last interval:
			if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1).get(1)) {
				ans.add(Arrays.asList(arr[i][0], arr[i][1]));
			}
			// if the current interval
			// lies in the last interval:
			else {
				ans.get(ans.size() - 1).
				set(1, Math.max(ans.get(ans.size() - 1).get(1), arr[i][1]));
			}

		}

		return ans;
	}
}
