package _10_Binary_Search._01_BS_on_1D_Arrays;

public class _06_first_or_last_occurrence_of_a_given_number_in_a_sorted_array {
	public static void main(String args[]) {
		int key = 13;
		int[] v = { 3, 4, 13, 13, 13, 20, 40 };

		// returning the last occurrence index if the element is present otherwise -1
		findFirstLastOccByBruteForce(v, key);

		int[] both = findFirstLastOccByLowerAndUpperBound(v, key);
		System.out.println("First :" + both[0] + " , Last : " + both[1]);

		System.out.println();

		int[] both02 = findFirstLastOccByBinarySearch(v, key);
		System.out.println("First :" + both02[0] + " , Last : " + both02[1]);

	}

	// TC : O(N)
	static void findFirstLastOccByBruteForce(int[] arr, int key) {

		int first = -1;
		int last = -1;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == key) {
				if (first == -1) {
					first = i;
				}
				last = i;
			}
		}

		System.out.println("First Index :" + first);
		System.out.println("Last Index :" + last);
		System.out.println();
	}

	// solve by Lower and Upper Bound code
	private static int[] findFirstLastOccByLowerAndUpperBound(int[] arr, int key) {

		int lb = lowerBound(arr, arr.length, key);

		if (lb == arr.length || arr[lb] != key) {
			return new int[] { -1, -1 };
		}

		return new int[] { lb, upperBound(arr, arr.length, key) - 1 };
	}

	private static int lowerBound(int[] arr, int n, int target) {

		int low = 0;
		int high = n - 1;

		int ans = arr.length;

		while (low <= high) {

			int mid = (low + high) / 2;

			if (arr[mid] >= target) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}

		return ans;
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

	// solve by Pure Binary Search only
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
