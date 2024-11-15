package Arrays._3_Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//blog : https://takeuforward.org/data-structure/3-sum-find-triplets-that-add-up-to-a-zero/
//Question : https://leetcode.com/problems/3sum/
public class _29_3_Sum_Problem {

	public static void main(String[] args) {
		int[] arr = { -1, 0, 1, 2, -1, -4 };
		int n = arr.length;
		List<List<Integer>> ans = triplet(n, arr);
		for (List<Integer> it : ans) {
			System.out.print("[");
			for (Integer i : it) {
				System.out.print(i + " ");
			}
			System.out.print("] ");
		}
		System.out.println();

		int[] arr2 = { -1, 0, 1, 2, -1, -4 };
		int n2 = arr2.length;
		List<List<Integer>> ans2 = triplet2(n2, arr2);
		for (List<Integer> it : ans2) {
			System.out.print("[");
			for (Integer i : it) {
				System.out.print(i + " ");
			}
			System.out.print("] ");
		}
		System.out.println();

		int[] arr3 = { -2, -2, -2, -1, -1, -1, 0, 0, 0, 2, 2, 2, 2 };
		int n3 = arr3.length;
		List<List<Integer>> ans3 = triplet3(n3, arr3);
		for (List<Integer> it : ans3) {
			System.out.print("[");
			for (Integer i : it) {
				System.out.print(i + " ");
			}
			System.out.print("] ");
		}
		System.out.println();

	}

	// Brute force
	// Time Complexity: O(N3 * log(no. of unique triplets))
	// Space Complexity: O(2 * no. of the unique triplets)
	private static List<List<Integer>> triplet(int n, int[] arr) {

		Set<List<Integer>> st = new HashSet<List<Integer>>();

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				for (int k = j + 1; k < arr.length; k++) {

					if (arr[i] + arr[j] + arr[k] == 0) {
						List<Integer> tempList = Arrays.asList(arr[i], arr[j], arr[k]);
						tempList.sort(null);
						st.add(tempList);
					}

				}
			}
		}
		List<List<Integer>> ans = new ArrayList<>(st);
		return ans;
	}

	// Better
	// Time Complexity: O(N2 * log(no. of unique triplets))
	// Space Complexity: O(2 * no. of the unique triplets) + O(N)
	// refer :
	// https://www.youtube.com/watch?v=DhFh8Kw7ymk&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=21&t=1243s
	private static List<List<Integer>> triplet2(int n, int[] arr) {
		Set<List<Integer>> st = new HashSet<List<Integer>>();

		for (int i = 0; i < arr.length; i++) {
			Set<Integer> hashSet = new HashSet<Integer>();
			for (int j = i + 1; j < arr.length; j++) {

				int third = -(arr[i] + arr[j]);

				if (hashSet.contains(third)) {
					List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
					temp.sort(null);
					st.add(temp);
				}
				hashSet.add(arr[j]);
			}
		}

		List<List<Integer>> ans = new ArrayList<>(st);
		return ans;
	}

	// Optimal : Two Pointer : same as target sum pair but in this Q we have 3 pointer
	// Time Complexity: O(NlogN)+O(N2)
	// Space Complexity: O(no. of quadruplets),
	private static List<List<Integer>> triplet3(int n, int[] arr) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			// remove duplicates:
			if (i != 0 && arr[i] == arr[i - 1]) {
				continue;
			}

			// moving 2 pointers:
			int j = i + 1;
			int k = arr.length - 1;

			while (j < k) {
				int sum = arr[i] + arr[j] + arr[k];

				if (sum < 0) {
					j++;
				} else if (sum > 0) {
					k--;
				} else {
					List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
					temp.sort(null);
					ans.add(temp);
					j++;
					k--;

					// skip the duplicates:
					while (j < k && arr[j] == arr[j - 1])
						j++;
					while (j < k && arr[k] == arr[k + 1])
						k--;
				}
			}
		}

		return ans;
	}

}
