package _01_Arrays._1_Easy;

//blog : https://takeuforward.org/data-structure/count-maximum-consecutive-ones-in-the-array/
//Question : https://leetcode.com/problems/max-consecutive-ones/
public class _11_Maximum_Consecutive_Ones {
	public static void main(String[] args) {
		int nums[] = { 1, 1, 0, 1, 1, 1 };
		int ans = findMaxConsecutiveOnes(nums);
		System.out.println("The maximum  consecutive 1's are " + ans);
	}

	//Optimal
//	Time Complexity: O(N)
//	Space Complexity: O(1)
	private static int findMaxConsecutiveOnes(int[] nums) {
		int cnt = 0;
		int max = 0;

		for (int i = 0; i < nums.length; i++) {

			if(nums[i] == 1) {
				cnt++;
				max = Math.max(max, cnt);
			}else {
				cnt = 0;
			}	
		}

		return max;
	}

}
