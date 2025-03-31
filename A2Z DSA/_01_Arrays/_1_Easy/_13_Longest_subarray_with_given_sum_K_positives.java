package _01_Arrays._1_Easy;

import java.util.HashMap;
import java.util.Map;

//blog : https://takeuforward.org/data-structure/longest-subarray-with-given-sum-k/
//Question : https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=longest-sub-array-with-sum-k
public class _13_Longest_subarray_with_given_sum_K_positives {

	public static void main(String[] args) {
		int[] a = { 2, 3, 5, 1, 9, 4, 4, 1, 1 };
		int k = 10;
		int len = getLongestSubarray(a, k);
		System.out.println("The length of the longest subarray is: " + len);

		int len2 = getLongestSubarray2(a, k);
		System.out.println("The length of the longest subarray is: " + len2);

		int[] a2 = { 1, 2, 3, 1, 1, 1, 1, 3, 3 };
		int k2 = 6;
		int len3 = getLongestSubarray3(a2, k2);
		System.out.println("The length of the longest subarray is: " + len3);
	}

	// Brute force
	// Time Complexity: O(N3)
	// Space Complexity: O(1)
	private static int getLongestSubarray(int[] arr, int k) {

		int maxSubArrLen = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int sum = 0;
				for (int m = i; m <= j; m++) {
					sum += arr[m];
				}
				if (sum == k) {
					maxSubArrLen = Math.max(maxSubArrLen, j - i + 1);
				}
			}
		}

		return maxSubArrLen;
	}

	// Better but this only we can use with positive but not with 0's
	// Time Complexity: O(N) or O(N*logN)
	// Space Complexity: O(N)
	// for better understanding :-
	// https://www.youtube.com/watch?v=frf7qxiN2qU&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=7
	private static int getLongestSubarray2(int[] arr, int k) {
		
//		2, 3, 5, 1, 9, 4, 4, 1, 1
//		10
		
//		this is the Map<Sum, Index>
		Map<Integer, Integer> preSumMap = new HashMap<Integer, Integer>();

		int preSum = 0;

		int maxLen = 0;
		for (int i = 0; i < arr.length; i++) {
			// calculate the prefix sum till index i:
			preSum += arr[i];

			// if the preSum = k, update the maxLen:
			if (preSum == k) {
				maxLen = Math.max(maxLen, i + 1);
			}

			// calculate the preSum of remaining part i.e. x-k:
			int rem = preSum - k;

			// Calculate the length and update maxLen:
			if (preSumMap.containsKey(rem)) {
				int val = i - preSumMap.get(rem);
				maxLen = Math.max(maxLen, val);
			}

			// Finally, update the map checking the conditions: if we wont use the check
//			before putting then dry run for this : { 2, 0, 0, 3 }
			if (!preSumMap.containsKey(preSum)) {
				preSumMap.put(preSum, i);
			}
		}

		return maxLen;
	}

	// Optimal (Two Pointer or Greedy) :- but we can use this with only Positive
	// Time Complexity: O(1)
	// Space Complexity: O(1)
	// for better understanding :-
	// https://www.youtube.com/watch?v=frf7qxiN2qU&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=7
	private static int getLongestSubarray3(int[] arr, int k) {
		int maxLen = 0;
		int left = 0, right = 0;
		int sum = 0;

		while (right < arr.length) {

			// if sum > k, reduce the subarray from left
			// until sum becomes less or equal to k.
			while (left <= right && sum > k) {
				sum -= arr[left];
				left++;
			}

			sum += arr[right];

			// if sum = k, update the maxLen i.e. answer:
			if (sum == k) {
				maxLen = Math.max(maxLen, right - left + 1);
			}

			// Move forward thw right pointer:
			right++;
		}

		return maxLen;
	}

}
