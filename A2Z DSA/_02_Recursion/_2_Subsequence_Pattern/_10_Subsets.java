package _02_Recursion._2_Subsequence_Pattern;

import java.util.ArrayList;
import java.util.List;

public class _10_Subsets {
	public static void main(String[] args) {

		int[] nums = {1,2,3};
		List<List<Integer>> ans = subsets(nums);
		
		for(List<Integer> temp :ans) {
			System.out.println(temp);
		}
	}

	public static List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> fans = new ArrayList<>();

		if (nums == null || nums.length == 0) {
			return fans;
		}

		solution(nums, 0, new ArrayList<>(), fans);

		return fans;
	}

	public static List<Integer> solution(int[] nums, int ci, List<Integer> tempAns, List<List<Integer>> fans) {
		if (ci > nums.length - 1) {
			fans.add(new ArrayList<>(tempAns));
			return tempAns;
		}

		tempAns.add(nums[ci]);
		solution(nums, ci + 1, tempAns, fans); // yes call
		tempAns.remove(tempAns.size() - 1);

		solution(nums, ci + 1, tempAns, fans); // Nocall

		return tempAns;
	}
}
