package _10_Binary_Search._01_BS_on_1D_Arrays;

public class _01_Binary_Search_to_find_X_in_sorted_array {
	public static void main(String[] args) {
		int[] a = { 3, 4, 6, 7, 9, 12, 16, 17 };
		int target = 6;
		int ind = iterativeBinarySearch(a, target);
		if (ind == -1)
			System.out.println("The target is not present.");
		else
			System.out.println("The target is at index: " + ind);

		int ind2 = recursiveBinarySearch(a, 0, a.length - 1, target);
		if (ind2 == -1)
			System.out.println("The target is not present.");
		else
			System.out.println("The target is at index: " + ind);

	}

	// TC : O(logN)
	public static int iterativeBinarySearch(int[] arr, int target) {
		int n = arr.length;
		int low = 0, high = n - 1;

		while (low <= high) {

			int mid = (low + high) / 2;

			// if value is greater then last index value
//			int mid = (low + ((high - low) / 2)); 

			if (arr[mid] == target) {
				return mid;
			} else if (target > arr[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}

		}

		return -1;
	}

	// TC : O(logN)
	public static int recursiveBinarySearch(int[] arr, int low, int high, int target) {

		if (low > high) {
			return -1;
		}

		int mid = (low + high) / 2;

		if (arr[mid] == target) {
			return mid;
		} else if (target > arr[mid]) {
			return recursiveBinarySearch(arr, mid + 1, high, target);
		}
		return recursiveBinarySearch(arr, low, mid - 1, target);
	}
}
