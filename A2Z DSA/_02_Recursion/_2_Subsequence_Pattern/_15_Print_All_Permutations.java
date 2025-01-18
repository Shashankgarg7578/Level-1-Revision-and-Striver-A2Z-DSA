package _02_Recursion._2_Subsequence_Pattern;

import java.util.ArrayList;
import java.util.List;

//blog : https://takeuforward.org/data-structure/print-all-permutations-of-a-string-array/
//Question : https://leetcode.com/problems/permutations/
//video :- https://www.youtube.com/watch?v=f2ic2Rsc9pU&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=15
public class _15_Print_All_Permutations {
	public static void main(String[] args) {
		int nums[] = { 1, 2, 3 };
		List<List<Integer>> ls = permute(nums);
		System.out.println("All Permutations are ");
		for (int i = 0; i < ls.size(); i++) {
			for (int j = 0; j < ls.get(i).size(); j++) {
				System.out.print(ls.get(i).get(j) + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		int nums2[] = { 1, 2, 3 };
		List<List<Integer>> ls2 = permute2(nums2);
		System.out.println("All Permutations are ");
		for (int i = 0; i < ls2.size(); i++) {
			for (int j = 0; j < ls2.get(i).size(); j++) {
				System.out.print(ls2.get(i).get(j) + " ");
			}
			System.out.println();
		}
		
	}

	// with extra space
	private static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		List<Integer> ds = new ArrayList<Integer>();
		boolean[] freq = new boolean[nums.length];
		generatePermutations(nums, ds, ans, freq);
		return ans;
	}

	private static void generatePermutations(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean[] freq) {
		if (ds.size() == nums.length) {
			ans.add(new ArrayList<Integer>(ds));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!freq[i]) {
				freq[i] = true;
				ds.add(nums[i]);
				generatePermutations(nums, ds, ans, freq);
				ds.remove(ds.size() - 1);
				freq[i] = false;
			}
		}
	}

	// without extra space : swap thing
	private static List<List<Integer>> permute2(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		generatePermutations2(0, nums, ans);
		return ans;
	}

	private static void generatePermutations2(int index, int[] nums, List<List<Integer>> ans) {
		if (index == nums.length) {
			// copy the ds to ans
			List<Integer> ds = new ArrayList<>();
			for (int i = 0; i < nums.length; i++) {
				ds.add(nums[i]);
			}
			ans.add(new ArrayList<>(ds));
			return;
		}
		for (int i = index; i < nums.length; i++) {
			swap(i, index, nums);
			generatePermutations2(index + 1, nums, ans);
			swap(i, index, nums);
		}
	}

	private static void swap(int i, int j, int[] nums) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
}