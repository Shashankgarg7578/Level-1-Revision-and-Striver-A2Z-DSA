package _01_Arrays._2_Medium;

//blog: https://takeuforward.org/data-structure/kadanes-algorithm-maximum-subarray-sum-in-an-array/
//Question : https://leetcode.com/problems/maximum-subarray/
public class _17_Kadanes_Algorithm_maximum_subarray_sum {

	public static void main(String[] args) {
		int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int n = arr.length;
		int maxSum = maxSubarraySum(arr, n);
		System.out.println("The maximum subarray sum is: " + maxSum);

		int maxSum2 = maxSubarraySum2(arr, n);
		System.out.println("The maximum subarray sum is: " + maxSum2);

		int maxSum3 = maxSubarraySum3(arr, n);
		System.out.println("The maximum subarray sum is: " + maxSum3);
	}

	// Brute force
	// Time Complexity: O(N3)
	// Space Complexity: O(1)
	private static int maxSubarraySum(int[] arr, int n) {
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {

				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum += arr[k];
				}
				if (maxSum < sum) {
					maxSum = sum;
				}
			}
		}

		return maxSum;
	}

	// Better
	// Time Complexity: O(N^2)
	// Space Complexity: O(1)
	private static int maxSubarraySum2(int[] arr, int n) {

		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum += arr[j];
				if (maxSum < sum) {
					maxSum = sum;
				}
			}
		}

		return maxSum;
	}

	// Optimal : Kadane's Algorithm
	// Time Complexity: O(N)
	// Space Complexity: O(1)
	private static int maxSubarraySum3(int[] arr, int n) {

		int maxSum = Integer.MIN_VALUE;

		int sum = 0;
		for(int i = 0; i < arr.length ; i++) {
			sum += arr[i];
			
			if(sum > maxSum) {
				maxSum = sum;
			}
			
			// If sum < 0: discard the sum calculated
			if(sum < 0) {
				sum = 0;
			}
		}

        // To consider the sum of the empty subarray
        // uncomment the following check:

        //if (maxi < 0) maxi = 0;

		return maxSum;
	}
	
}












