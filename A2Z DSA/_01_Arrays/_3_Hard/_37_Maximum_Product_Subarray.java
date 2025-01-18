package _01_Arrays._3_Hard;

public class _37_Maximum_Product_Subarray {
	public static void main(String[] args) {
		int nums[] = { -2, 0, -1 };
		int answer = maxProductSubArray(nums);
		System.out.println("The maximum product subarray is: " + answer);

		int nums2[] = { 2, 3, -2, 4 };
		int answer2 = maxProductSubArray2(nums2);
		System.out.println("The maximum product subarray is: " + answer2);
	}

	// Brute force Approach
	// Time Complexity: O(N^3)
	// Space Complexity: O(1)
	static int maxProductSubArray(int arr[]) {
		int result = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int prod = 1;
				for (int k = i; k <= j; k++) {
					prod *= arr[k];
				}
				// this is all number product
				result = Math.max(result, prod);
				// for number alone check
				result = Math.max(result, arr[j]);
			}
		}
		return result;
	}

	// Better
	// Time Complexity: O(N^2)
	// Space Complexity: O(1)
	static int maxProductSubArray2(int arr[]) {
		int result = arr[0];
		for (int i = 0; i < arr.length - 1; i++) {
			int p = arr[i];
			for (int j = i + 1; j < arr.length; j++) {

				// this is all number product
				result = Math.max(result, p);

				// for number alone check
				result = Math.max(result, arr[j]);
				p *= arr[j];

			}
			result = Math.max(result, p);
		}
		return result;
	}
}
