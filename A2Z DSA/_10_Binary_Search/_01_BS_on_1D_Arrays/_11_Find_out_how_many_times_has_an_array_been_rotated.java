package _10_Binary_Search._01_BS_on_1D_Arrays;

public class _11_Find_out_how_many_times_has_an_array_been_rotated {
	public static void main(String[] args) {
		int[] arr = { 4, 5, 6, 7, 0, 1, 2, 3 };
		int ans = findKRotation(arr);
		System.out.println("The array is rotated " + ans + " times.");
	}

	// same as previous Question
	private static int findKRotation(int[] arr) {

		int low = 0;
		int high = arr.length - 1;
		int index = -1;
		int minAns = Integer.MAX_VALUE;

		while (low <= high) {

			int mid = (low + high) / 2;

			// search space is already sorted
			// then arr[low] will always be
			// the minimum in that search space:
			if (arr[low] <= arr[high]) {
				if (arr[low] < minAns) {
					minAns = arr[low];
					index = low;
				}
				break;
			}

			if (arr[low] <= arr[mid]) {
				if (arr[low] < minAns) {
					minAns = arr[low];
					index = low;
				}
				low = mid + 1;
			} else {
				if (arr[mid] < minAns) {
					minAns = arr[mid];
					index = mid;
				}
				high = mid - 1;
			}

		}

		return index;
	}
}
