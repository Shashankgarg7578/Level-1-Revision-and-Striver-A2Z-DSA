package _10_Binary_Search._02_BS_on_Answers;

public class _18_Find_the_smallest_Divisor {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int limit = 8;
		int ans = smallestDivisor(arr, limit);
		System.out.println("The minimum divisor is: " + ans);

		int ans2 = smallestDivisor2(arr, limit);
		System.out.println("The minimum divisor is: " + ans2);
	}

	// Brute force
//	Time Complexity: O(max(arr[])*N)
	private static int smallestDivisor(int[] arr, int limit) {

		int n = arr.length;

		int maxi = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			maxi = Math.max(maxi, arr[i]);
		}

		// find the smallest divisor

		for (int d = 1; d <= maxi; d++) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				sum += Math.ceil((double) arr[i] / (double) d);
			}

			if (sum <= limit) {
				return d;
			}
		}

		return -1;
	}

	// Optimal :- Binary Search
//	Time Complexity: O(log(max(arr[]))*N)
	private static int smallestDivisor2(int[] arr, int limit) {

		int n = arr.length;

		if (n > limit)
			return -1;

		int maxi = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			maxi = Math.max(maxi, arr[i]);
		}

		// find the smallest divisor
		int low = 1, high = maxi;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (sumByDiviser(arr, mid) <= limit) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}

		return low;
	}

	private static int sumByDiviser(int[] arr, int mid) {
		int n = arr.length;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += Math.ceil((double) arr[i] / (double) mid);
		}
		return sum;
	}

}
