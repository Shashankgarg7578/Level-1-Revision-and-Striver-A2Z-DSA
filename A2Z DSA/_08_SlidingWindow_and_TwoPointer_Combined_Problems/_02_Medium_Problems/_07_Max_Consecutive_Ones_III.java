package _08_SlidingWindow_and_TwoPointer_Combined_Problems._02_Medium_Problems;

public class _07_Max_Consecutive_Ones_III {
	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
		int k = 2;// means k time 0 flips(change) possible with 1
		System.out.println(longestOnes1(arr, k));
		System.out.println(longestOnes2(arr, k));
		System.out.println(longestOnes3(arr, k));

	}

	// TC : O(N^2)
	// SC : O(1)
	public static int longestOnes1(int[] nums, int k) {
		int n = nums.length;
		int maxlen = 0;

		for (int i = 0; i < n; i++) {

			int zeros = 0;

			for (int j = i; j < n; j++) {
				if (nums[j] == 0) {
					zeros++;
				}

				if (zeros <= k) {
					int len = j - i + 1;
					maxlen = Math.max(maxlen, len);
				} else {
					break;
				}

			}

		}

		return maxlen;
	}

	// Better :- Two Pointer :- Shrink till 0 less or equal to k.
	// TC : O(N + N) ~ O(2N)
	// SC : O(1)
	public static int longestOnes2(int[] nums, int k) {
		int n = nums.length;
		int maxlen = 0;
		int l = 0, r = 0;

		int zeros = 0;

		while (r < n) {

			if (nums[r] == 0) {
				zeros++;
			}

			// for shrink
			while (zeros > k) {
				if (nums[l] == 0) {
					zeros--;
				}
				l++;
			}

			if (zeros <= k) {
				int len = r - l + 1;
				maxlen = Math.max(maxlen, len);
			}

			r++;
		}

		return maxlen;
	}

	// Optimal :- one time shrink only
	// TC : O(N)
	// SC : O(1)
	public static int longestOnes3(int[] nums, int k) {
		int n = nums.length;
		int maxlen = 0;
		int l = 0, r = 0;

		int zeros = 0;

		while (r < n) {

			if (nums[r] == 0) {
				zeros++;
			}

			if (zeros > k) {
				if (nums[l] == 0) {
					zeros--;
				}
				l++;
			}

			if (zeros <= k) {
				int len = r - l + 1;
				maxlen = Math.max(maxlen, len);
			}

			r++;
		}

		return maxlen;
	}

}
