package _08_SlidingWindow_and_TwoPointer_Combined_Problems._02_Medium_Problems;

//related to Arrays :- Q26. Count sub-arrays with given sum (in this we have - or + integers)
//                      In this we solve with TC:O(N), SC:O(N)
public class _12_Binary_subarray_with_sum {

	// we have pick sub-array which given sum is equal to k
	public static void main(String[] args) {

		int[] nums = { 1, 0, 1, 0, 1 };

		int goal = 2;

		System.out.println(numSubarraysWithSum(nums, goal) - numSubarraysWithSum(nums, goal - 1));

	}

	// here in this if we use two pointer as l,r=0 and shrink multiple solution then
	// it miss more sub-array that why we will use another way

	// so first we will solve for :- no. of subarrays where sum <= goal instead of
	// directly solve for =, here we are using 3rd formula which we learn in first
	// TC : O(N)
	// SC : O(1)
	public static int numSubarraysWithSum(int[] nums, int goal) {

		if (goal < 0) {
			return 0;
		}

		int n = nums.length;
		int l = 0, r = 0;
		int cnt = 0;
		int sum = 0;

		while (r < n) {

			sum += nums[r];

			while (sum > goal) {
				sum = sum - nums[l];
				l = l + 1;
			}

			cnt = cnt + (r - l + 1);

			r = r + 1;
		}

		return cnt;
	}

}
