package _08_SlidingWindow_and_TwoPointer_Combined_Problems._01_Understand_Concept;

public class _01_Contant_Window {
	public static void main(String[] args) {

		int[] arr = { -1, 2, 3, 3, 4, 5, -1 };
		int k = 4;//// k is window length
		System.out.println(maxmiumSumInWindowK(arr, k));

	}

	// 1. Constant Window := not much asked in interview
	// Use Two Pointers
	public static int maxmiumSumInWindowK(int[] arr, int k) {

		int maxSum = Integer.MIN_VALUE;

		int n = arr.length;
		int l = 0;
		int r = k - 1;

		int sum = 0;

		for (int i = 0; i < k; i++) {
			sum += arr[i];
		}

		while (r < n - 1) {

			sum = sum - arr[l];

			l++;
			r++;

			sum = sum + arr[r];

			maxSum = Math.max(maxSum, sum);

		}

		return maxSum;
	}

}
