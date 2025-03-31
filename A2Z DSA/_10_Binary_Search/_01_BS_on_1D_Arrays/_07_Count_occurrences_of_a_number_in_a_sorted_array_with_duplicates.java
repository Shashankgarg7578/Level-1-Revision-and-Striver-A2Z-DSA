package _10_Binary_Search._01_BS_on_1D_Arrays;

public class _07_Count_occurrences_of_a_number_in_a_sorted_array_with_duplicates {

	public static void main(String[] args) {
		int[] arr = { 2, 4, 6, 8, 8, 8, 11, 13 };
		int n = arr.length, x = 8;
		int ans = count(arr, n, x);
		System.out.println("The number of occurrences is: " + ans);
	}

	private static int count(int[] arr, int n, int x) {

		int[] ans = findFirstLastOccByBinarySearch(arr, x);

		if (ans[0] == -1) {
			return 0;
		}

		return (ans[1] - ans[0] + 1);
	}

	// Previous @uestion solve by Pure Binary Search only
	private static int[] findFirstLastOccByBinarySearch(int[] arr, int key) {

		int fo = firstOccranceInBinarySearch(arr, arr.length, key);

		if (fo == -1) {
			return new int[] { -1, -1 };
		}

		int lo = lastOccranceInBinarySearch(arr, arr.length, key);

		return new int[] { fo, lo };
	}

	private static int firstOccranceInBinarySearch(int[] arr, int n, int target) {
		int first = -1;

		int low = 0, high = n - 1;

		while (low <= high) {

			int mid = (low + high) / 2;

			if (arr[mid] == target) {
				first = mid;
				high = mid - 1;
			} else if (arr[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return first;
	}

	private static int lastOccranceInBinarySearch(int[] arr, int n, int target) {
		int last = -1;

		int low = 0, high = n - 1;

		while (low <= high) {

			int mid = (low + high) / 2;

			if (arr[mid] == target) {
				last = mid;
				low = mid + 1;
			} else if (arr[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return last;
	}

}
