package _02_Recursion._2_Subsequence_Pattern;

import java.util.ArrayList;
import java.util.Collections;

public class _13_Subset_Sum_I {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(3);
		arr.add(1);
		arr.add(2);
		ArrayList<Integer> ans = subsetSums(arr, arr.size());
		Collections.sort(ans);
		System.out.println("The sum of each subset is ");
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
	}

	private static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int size) {
		ArrayList<Integer> ans = new ArrayList<Integer>();

		subsetSumsHelper(0, 0, arr, size, ans);

		Collections.sort(ans);

		return ans;
	}

	// Time Complexity: O(2^n)+O(2^n log(2^n))
	// Space Complexity: O(2^n)
	private static void subsetSumsHelper(int ind, int sum, ArrayList<Integer> arr, int arrSize,
			ArrayList<Integer> ans) {

		if (ind == arrSize) {
			ans.add(sum);
			return;
		}

		// Take call
		subsetSumsHelper(ind + 1, sum + arr.get(ind), arr, arrSize, ans);

		// Not Take call
		subsetSumsHelper(ind + 1, sum, arr, arrSize, ans);

	}

}
