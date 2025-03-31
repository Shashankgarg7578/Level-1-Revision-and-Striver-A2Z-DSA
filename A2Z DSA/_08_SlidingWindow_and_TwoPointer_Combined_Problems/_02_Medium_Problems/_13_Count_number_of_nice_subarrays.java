package _08_SlidingWindow_and_TwoPointer_Combined_Problems._02_Medium_Problems;

public class _13_Count_number_of_nice_subarrays {
	public static void main(String[] args) {

		// we have to found subarray in which we have k elements as odd.
		// for example :- [1,1,2,1]
		int[] nums = { 1, 1, 2, 1, 1 };

		// as this problem is same as previous problem and we convert given array to
		// [1,1,0,1,1]

		int k = 3;

		System.out.println(numberOfSubarrays(nums, k) - numberOfSubarrays(nums, k - 1));
	}

	public static int numberOfSubarrays(int[] nums, int k) {

		if (k < 0) {
			return 0;
		}

		int n = nums.length;
		int l = 0, r = 0;
		int cnt = 0;
		int sum = 0;

		while (r < n) {

			sum += nums[r] % 2;

			while (sum > k) {
				sum = sum - nums[l] % 2;
				l = l + 1;
			}

			cnt = cnt + (r - l + 1);

			r = r + 1;
		}

		return cnt;
	}
}
