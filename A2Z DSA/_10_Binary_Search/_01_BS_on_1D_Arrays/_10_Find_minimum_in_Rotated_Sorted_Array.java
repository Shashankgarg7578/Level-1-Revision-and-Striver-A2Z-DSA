package _10_Binary_Search._01_BS_on_1D_Arrays;

public class _10_Find_minimum_in_Rotated_Sorted_Array {
	public static void main(String[] args) {
		int[] arr = { 4, 5, 6, 7, 0, 1, 2, 3 };
		int ans = findMin(arr);
		System.out.println("The minimum element is: " + ans);
		
		int ans2 = findMin2(arr);
		System.out.println("The minimum element is: " + ans2);

	}

	private static int findMin(int[] arr) {

		int low = 0;
		int high = arr.length - 1;

		int minAns = Integer.MAX_VALUE;

		while (low <= high) {

			int mid = (low + high) / 2;

			if (arr[low] <= arr[mid]) {
				minAns = Math.min(minAns, arr[low]);
				low = mid + 1;
			} else {
				minAns = Math.min(minAns, arr[mid]);
				high = mid - 1;
			}

		}

		return minAns;
	}

	// update with little observation
	private static int findMin2(int[] arr) {

		int low = 0;
		int high = arr.length - 1;

		int minAns = Integer.MAX_VALUE;

		while (low <= high) {

			int mid = (low + high) / 2;

			// search space is already sorted
			// then arr[low] will always be
			// the minimum in that search space:
			if (arr[low] <= arr[high]) {
				minAns = Math.min(minAns, arr[low]);
				break;
			}

			if (arr[low] <= arr[mid]) {
				minAns = Math.min(minAns, arr[low]);
				low = mid + 1;
			} else {
				minAns = Math.min(minAns, arr[mid]);
				high = mid - 1;
			}

		}

		return minAns;
	}

}
