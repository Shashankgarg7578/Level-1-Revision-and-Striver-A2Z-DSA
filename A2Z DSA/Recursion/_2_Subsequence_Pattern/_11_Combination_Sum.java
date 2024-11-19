package Recursion._2_Subsequence_Pattern;

import java.util.ArrayList;
import java.util.List;

public class _11_Combination_Sum {
	public static void main(String[] args) {
		int arr[] = { 2, 3, 6, 7 };
		int target = 7;
		List<List<Integer>> ls = combinationSum(arr, target);
		System.out.println("Combinations are: ");
		for (int i = 0; i < ls.size(); i++) {
			for (int j = 0; j < ls.get(i).size(); j++) {
				System.out.print(ls.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	private static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		findCombinationSum(0, candidates, target, ans, new ArrayList<>());
		return ans;
	}

	private static void findCombinationSum(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {

		if (ind == arr.length) {
			if (target == 0) {
				ans.add(new ArrayList<>(ds));
			}
			return;
		}

		if (arr[ind] <= target) {
			ds.add(arr[ind]);
			findCombinationSum(ind, arr, target - arr[ind], ans, ds);
			ds.remove(ds.size() - 1);
		}
		findCombinationSum(ind + 1, arr, target, ans, ds);
	}

}
