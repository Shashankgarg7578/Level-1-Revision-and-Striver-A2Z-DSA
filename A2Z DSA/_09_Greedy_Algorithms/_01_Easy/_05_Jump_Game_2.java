package _09_Greedy_Algorithms._01_Easy;

public class _05_Jump_Game_2 {

	public static void main(String[] args) {
		// we have to go from first index to last index by minimum jump
		int[] nums = { 2, 3, 1, 4, 1, 1, 1, 2 };

		System.out.println(jump(nums));
	}

	// we can solve by recursion, DP or space optimization
	// but here we will use Greedy new Approach

	// TC : O(N)
	// SC : O(1)
	public static int jump(int[] nums) {

		int n = nums.length;
		int l = 0, r = 0, jumps = 0;

		while (r < n - 1) {

			int farthest = 0;

			// capturing only longest jump
			for (int j = l; j <= r; j++) {
				farthest = Math.max(farthest, j + nums[j]);
			}

			l = r + 1;
			r = farthest;
			jumps = jumps + 1;

		}

		return jumps;
	}
}
