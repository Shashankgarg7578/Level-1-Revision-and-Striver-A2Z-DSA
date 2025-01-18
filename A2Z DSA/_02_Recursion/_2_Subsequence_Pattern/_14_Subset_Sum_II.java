package _02_Recursion._2_Subsequence_Pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _14_Subset_Sum_II {
	public static void main(String[] args) {
		int nums[] = { 1, 2, 2, 2, 3, 3 };

		List<List<Integer>> ans = subsetsWithDup(nums);
		printAns(ans);
	}

	private static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Arrays.sort(nums);

		findSubsets(0, nums, new ArrayList<Integer>(), ans);

		return ans;
	}

	private static void findSubsets(int ind, int[] nums, ArrayList<Integer> ds, List<List<Integer>> ans) {

		ans.add(new ArrayList<Integer>(ds));

		for (int i = ind; i < nums.length; i++) {
			//condition for don't skip first 
			if (i != ind && nums[i] == nums[i - 1])
				continue;

			ds.add(nums[i]);
			findSubsets(i + 1, nums, ds, ans);
			ds.remove(ds.size() - 1);
		}

	}

	static void printAns(List<List<Integer>> ans) {
		System.out.println("The unique subsets are ");
		System.out.println(ans.toString().replace(",", " "));
	}
}
