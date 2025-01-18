package _01_Arrays._3_Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _30_4_Sum_Problem {
	public static void main(String[] args) {
		int[] nums = { 4, 3, 3, 4, 4, 2, 1, 2, 1, 1 };
		int target = 9;
		List<List<Integer>> ans = fourSum(nums, target);
		System.out.println("The quadruplets are: ");
		for (List<Integer> it : ans) {
			System.out.print("[");
			for (int ele : it) {
				System.out.print(ele + " ");
			}
			System.out.print("] ");
		}
		System.out.println();

		int[] nums2 = { 4, 3, 3, 4, 4, 2, 1, 2, 1, 1 };
		int target2 = 9;
		List<List<Integer>> ans2 = fourSum2(nums2, target2);
		System.out.println("The quadruplets are: ");
		for (List<Integer> it : ans2) {
			System.out.print("[");
			for (int ele : it) {
				System.out.print(ele + " ");
			}
			System.out.print("] ");
		}
		System.out.println();

		int[] nums3 = { 4, 3, 3, 4, 4, 2, 1, 2, 1, 1 };
		int target3 = 9;
		List<List<Integer>> ans3 = fourSum3(nums3, target3);
		System.out.println("The quadruplets are: ");
		for (List<Integer> it : ans3) {
			System.out.print("[");
			for (int ele : it) {
				System.out.print(ele + " ");
			}
			System.out.print("] ");
		}
		System.out.println();

	}

	// Brute force
	// Time Complexity: O(N4)
	// Space Complexity: O(2 * no. of the quadruplets)
	private static List<List<Integer>> fourSum(int[] nums, int target) {

		Set<List<Integer>> set = new HashSet<List<Integer>>();

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					for (int l = k + 1; l < nums.length; l++) {
						long sum = (long) nums[i] + nums[j];
						sum += nums[k];
						sum += nums[l];

						if (sum == target) {
							List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
							temp.sort(null);
							set.add(temp);
						}

					}
				}
			}
		}

		List<List<Integer>> ans = new ArrayList<List<Integer>>(set);

		return ans;
	}

	// Better
	// Time Complexity: O(N3*log(M))
	// Space Complexity: O(2 * no. of the quadruplets)+O(N)
	private static List<List<Integer>> fourSum2(int[] nums, int target) {
		Set<List<Integer>> st = new HashSet<List<Integer>>();

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {

				Set<Long> hashset = new HashSet<Long>();

				for (int k = j + 1; k < nums.length; k++) {
//				formula : nums[l] = target - (nums[i]+nums[j]+nums[k]);
					long sum = (long) nums[i] + nums[j];
					sum += nums[k];
					long fourth = target - sum;

					if (hashset.contains(fourth)) {
						List<Integer> temp = new ArrayList<>();
						temp.add(nums[i]);
						temp.add(nums[j]);
						temp.add(nums[k]);
						temp.add((int) fourth);

						temp.sort(null);
						st.add(temp);
					}
					hashset.add((long) nums[k]);
				}
			}
		}

		List<List<Integer>> ans = new ArrayList<List<Integer>>(st);

		return ans;
	}

	// Better
	// Time Complexity: O(N3*log(M))
	// Space Complexity: O(2 * no. of the quadruplets)+O(N)
	private static List<List<Integer>> fourSum3(int[] nums, int target) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();

		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {

			if (i > 0 && nums[i] == nums[i - 1])
				continue;

			for (int j = i + 1; j < nums.length; j++) {

				if (j > i + 1 && nums[j] == nums[j - 1])
					continue;

				int k = j + 1;
				int l = nums.length - 1;

				while (k < l) {
					long sum = nums[i];
					sum += nums[j];
					sum += nums[k];
					sum += nums[l];

					if (sum == target) {
						List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
						ans.add(temp);
						k++;
						l--;

						while (k < l && nums[k] == nums[k - 1])
							k++;
						while (k < l && nums[l] == nums[l + 1])
							l--;

					} else if (sum < target) {
						k++;
					} else {
						l--;
					}
				}
			}
		}

		return ans;
	}

}
