package _08_SlidingWindow_and_TwoPointer_Combined_Problems._02_Medium_Problems;

import java.util.HashMap;
import java.util.Map;

public class _14_Subarray_with_k_different_integers {
	public static void main(String[] args) {
		// we have to found subarray in which we have k types of elements.
		// for example :- [1,2,1,3]
		int[] nums = { 1, 2, 1, 3, 4 };
		int k = 3;

		System.out.println(subarraysWithKDistinct(nums, k));
		System.out.println(subarraysWithKDistinct2(nums, k) - subarraysWithKDistinct2(nums, k - 1));

	}

	// Brute force
	// TC : O(N^2)
	// SC : O(N)
	public static int subarraysWithKDistinct(int[] nums, int k) {

		int cnt = 0;

		for (int i = 0; i < nums.length; i++) {
			// element -> frequency
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();

			for (int j = i; j < nums.length; j++) {
				int val = map.getOrDefault(nums[j], 0);
				map.put(nums[j], val + 1);

				if (map.size() == k) {
					cnt = cnt + 1;
				} else if (map.size() > k) {
					break;
				}
			}

		}

		return cnt;
	}

	// in this problem we can not use directly two pointers as it left so many
	// subarrays
	// that's why we are using 3rd formula in this questions
	public static int subarraysWithKDistinct2(int[] nums, int k) {

		int cnt = 0;

		int l = 0, r = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		while (r < nums.length) {
			int val = map.getOrDefault(nums[r], 0);
			map.put(nums[r], val + 1);

			while (map.size() > k) {
				int val2 = map.getOrDefault(nums[l], 0);
				map.put(nums[l], val2 - 1);

				if (map.get(nums[l]) <= 0) {
					map.remove(nums[l]);
				}
				l++;
			}

			cnt = cnt + (r - l + 1);
			r++;
		}

		return cnt;
	}

}
