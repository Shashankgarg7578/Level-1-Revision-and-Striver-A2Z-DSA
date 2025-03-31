package _10_Binary_Search._01_BS_on_1D_Arrays;

public class _03_Implement_Upper_Bound {
	public static void main(String[] args) {
		int[] arr = { 3, 5, 8, 15, 19 };
		int n = 5, x = 8;
		int ind = upperBound(arr, n, x);
		System.out.println("The lower bound is the index: " + ind);
	}

	private static int upperBound(int[] arr, int n, int target) {

		int low = 0;
		int high = n - 1;

		int ans = arr.length;

		while (low <= high) {

			int mid = (low + high) / 2;

			if (arr[mid] > target) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}

		return ans;
	}
}
