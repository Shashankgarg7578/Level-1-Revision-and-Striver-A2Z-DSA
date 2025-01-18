package _01_Arrays._2_Medium;

import java.util.Arrays;
import java.util.HashMap;

//blog: https://takeuforward.org/data-structure/two-sum-check-if-a-pair-with-given-sum-exists-in-array/
//Question : https://leetcode.com/problems/two-sum/
public class _14_2Sum_Problem {
	public static void main(String[] args) {
		int n = 5;
		int[] arr = { 2, 6, 5, 8, 11 };
		int target = 14;
		int[] ans = twoSum(n, arr, target);
		System.out.println("This is the answer for variant 2: " + ans[0] + " " + ans[1]);

		int[] ans2 = twoSum2(n, arr, target);
		System.out.println("This is the answer for variant 2: " + ans2[0] + " " + ans2[1]);

		int n3 = 3;
		int[] arr3 = { 3, 2, 4 };
		int target3 = 6;
		String ans3 = twoSum3(n3, arr3, target3);
		System.out.println("This is the answer for variant 1: " + ans3);

	}

	// Brute Force
	// Time Complexity: O(N2)
	// Space Complexity: O(1)
	private static int[] twoSum(int n, int[] arr, int target) {

		int[] ans = new int[2];

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {

				if (i == j) {
					continue;
				} else {
					if (arr[i] + arr[j] == target) {
						ans[0] = i;
						ans[1] = j;
						return ans;
					}
				}

			}
		}

		return ans;
	}

	// Better
	// Time Complexity: O(N)
	// Space Complexity: O(N)
	private static int[] twoSum2(int n, int[] arr, int target) {

		int[] ans = new int[2];

		// key = value of array, value = index of array
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < n; i++) {
			if (map.containsKey(target - arr[i])) {
				ans[0] = map.get(target - arr[i]);
				ans[1] = i;
			} else {
				map.put(arr[i], i);
			}
		}

		return ans;
	}

	// Optimal : Two Pointer , but it is valid only for no or yes, 
	//           if we want to return index then it will not solve by Optimal approach because we need to store somewhere.
	// Time Complexity:
	// Space Complexity:
	private static String twoSum3(int n, int[] arr, int target) {
		Arrays.sort(arr);
		
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			if (arr[left] + arr[right] < target) {
				left++;
			} else if (arr[left] + arr[right] > target) {
				right--;
			} else if (arr[left] + arr[right] == target) {
				
				System.out.println(left +"- -" + right);
				
				return "YES";
			}

		}

		return "NO";
	}

}
