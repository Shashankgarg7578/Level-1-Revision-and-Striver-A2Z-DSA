package Recursion._2_Subsequence_Pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _12_Combination_Sum_II {
	public static void main(String[] args) {
		int v[] = { 10, 1, 2, 7, 6, 1, 5 };
		List<List<Integer>> comb = combinationSum2(v, 8);
		System.out.println(comb.toString().replace(",", " "));
	}

	// Time Complexity:O(2^n*k)
	// Space Complexity:O(k*x)
	private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);

		findCombinationSum2(0, candidates, target, ans, new ArrayList<Integer>());

		return ans;
	}

	private static void findCombinationSum2(int ind, int[] candidates, int target, List<List<Integer>> ans,
			ArrayList<Integer> ds) {
		if (target == 0) {
			ans.add(new ArrayList<Integer>(ds));
			return;
		}

		for (int i = ind; i < candidates.length; i++) {
			if (i > ind && candidates[i] == candidates[i - 1])
				continue;
			if (candidates[i] > target)
				break;

			ds.add(candidates[i]);
			findCombinationSum2(i + 1, candidates, target - candidates[i], ans, ds);
			ds.remove(ds.size() - 1);
		}
	}
}
