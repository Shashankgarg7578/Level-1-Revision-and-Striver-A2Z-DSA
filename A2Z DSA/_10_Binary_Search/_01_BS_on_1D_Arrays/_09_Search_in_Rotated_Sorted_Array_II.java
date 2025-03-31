package _10_Binary_Search._01_BS_on_1D_Arrays;

public class _09_Search_in_Rotated_Sorted_Array_II {
	public static void main(String[] args) {
		int[] arr = { 7, 8, 1, 2, 3, 3, 3, 4, 5, 6 };
		int k = 3;
		boolean ans = searchInARotatedSortedArrayII(arr, k);
		if (ans == false)
			System.out.println("Target is not present.");
		else
			System.out.println("Target is present in the array.");
	}

	
	//Same as previous question just one condition changed
	private static boolean searchInARotatedSortedArrayII(int[] arr, int k) {
		int n = arr.length;
		int low = 0;
		int high = n - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (arr[mid] == k) {
				return true;
			}

			if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
				high = high - 1;
				low = low + 1;
				continue;
			}

			if (arr[low] <= arr[mid]) {
				// left half sorted

				if (arr[low] <= k && k <= arr[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}

			} else {
				// right half sorted

				if (arr[mid] <= k && k <= arr[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}

			}

		}

		return false;
	}
}
