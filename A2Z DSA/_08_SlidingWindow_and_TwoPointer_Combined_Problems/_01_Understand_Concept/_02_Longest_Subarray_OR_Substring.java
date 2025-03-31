package _08_SlidingWindow_and_TwoPointer_Combined_Problems._01_Understand_Concept;

//2. Longest Subarray/Substring where <Condition>
// this is asked commonly, most of only in this particular problem
public class _02_Longest_Subarray_OR_Substring {

	public static void main(String[] args) {

//		1. Longest Subarray with (sum <= k) :- any consecutive portion of array is called Subarray
		int[] arr = { 2, 5, 1, 7, 10 };
		int k = 14;// sum of element

//		we have to find longest subarray in which we have to find lesser or equal to this
//		 for this type of Question we have to give (Brute, Better, Optimal) solutions

		System.out.println(longestSubarrayWithSum(arr, k));

		System.out.println(longestSubarrayWithSum2(arr, k));
		System.out.println(longestSubarrayWithSum3(arr, k));

	}

	// Brute force
	// TC : O(N^2)
	// SC : O(1)
	private static int longestSubarrayWithSum(int[] arr, int k) {
		int maxLen = 0;
		for (int i = 0; i < arr.length; i++) {
			int tempSum = 0;
			for (int j = i; j < arr.length; j++) {
				tempSum = tempSum + arr[j];
				if (tempSum <= k) {
					maxLen = Math.max(maxLen, j - i + 1);
				} else if (tempSum > k) {
					break;
				}
			}
		}

		return maxLen;
	}

	// better :- Two Pointer :- initially both on 0th index
	// 1. expand -> r
	// 2. shrink -> l (may be shrink multiple times)

	// TC : O(N + N) ~ O(2N)
	// SC : O(1)
	private static int longestSubarrayWithSum2(int[] arr, int k) {
		int maxLen = 0;

		int n = arr.length;

		int l = 0, r = 0;
		int tempSum = 0;

		while (r < n) {

			tempSum = tempSum + arr[r];

			// shrink if sum is greater
			while (tempSum > k) {
				tempSum = tempSum - arr[l];
				l++;
			}

			if (tempSum <= k) {
				maxLen = Math.max(maxLen, r - l + 1);
			}
			r = r + 1;
		}

		return maxLen;
	}

	// it is for only find out length not array.
	// remove loop for shrink , shrink only once
	private static int longestSubarrayWithSum3(int[] arr, int k) {

		int maxLen = 0;

		int n = arr.length;

		int l = 0, r = 0;
		int tempSum = 0;

		while (r < n) {

			tempSum = tempSum + arr[r];

			// shrink if sum is greater
			if (tempSum > k) {
				tempSum = tempSum - arr[l];
				l++;
			}

			if (tempSum <= k) {
				maxLen = Math.max(maxLen, r - l + 1);
			}
			r = r + 1;
		}

		return maxLen;
	}

}
