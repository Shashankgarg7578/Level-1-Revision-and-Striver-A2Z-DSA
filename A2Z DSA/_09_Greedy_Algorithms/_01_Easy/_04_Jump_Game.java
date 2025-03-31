package _09_Greedy_Algorithms._01_Easy;

public class _04_Jump_Game {

	public static void main(String[] args) {
		// we have to go from first index to last index by jump, so are you able to go on last?
		int[] nums = { 1, 2, 4, 1, 1, 0, 2, 5 };
//		               0, 1, 2, 3, 4, 5, 6, 7

		System.out.print("Array representing maximum jump from each index: ");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();

		boolean ans = canJump(nums);

		if (ans) {
			System.out.println("It is possible to reach the last index.");
		} else {
			System.out.println("It is not possible to reach the last index.");
		}
	}

	// TC : O(N)
	// SC : O(1)
	private static boolean canJump(int[] nums) {

		int maxIndex = 0;

		for (int i = 0; i < nums.length; i++) {
			if (i > maxIndex) {
				return false;
			}

			maxIndex = Math.max(maxIndex, nums[i] + i);

		}

		return true;
	}

}
